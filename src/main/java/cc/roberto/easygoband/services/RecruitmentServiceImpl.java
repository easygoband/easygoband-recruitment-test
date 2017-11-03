package cc.roberto.easygoband.services;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import cc.roberto.easygoband.domain.Parent;

public class RecruitmentServiceImpl implements RecruitmentService {

    private static final String SERVICE_URI =
            "https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/{eventId}";
    
    private static final String EVENT_ID = "1";
    
    private static final String AUTHORIZATION_HEADER_CONTENT = "Basic cJmAc71jah17sgqi1jqaksvaksda=";
    
    private RestTemplate restTemplate;
    
    @Autowired
    public RecruitmentServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
	public List<Parent> find(String sessionName) {
	    HttpHeaders requestHeaders = new HttpHeaders();
	    requestHeaders.set("Authorization", AUTHORIZATION_HEADER_CONTENT);
	    
	    HttpEntity<List<Parent>> request = new HttpEntity<>(requestHeaders);
	    
		ResponseEntity<List<Parent>> response = restTemplate.exchange(
				SERVICE_URI,
				HttpMethod.GET,
				request,
				new ParameterizedTypeReference<List<Parent>>() {},
				EVENT_ID);
		
		if (HttpStatus.OK != response.getStatusCode()) {
		    throw new RuntimeException(
		            String.format(
		                    "La llamada al servicio ha fallado con el código http %d.",
		                    response.getStatusCodeValue()));
		}
		
		return
		        response
		        .getBody()
		        .stream()
		        .filter(sessionFilter(sessionName))
		        .collect(toList());
	}

    private Predicate<Parent> sessionFilter(String sessionName) {
        return
                StringUtils.isEmpty(sessionName) ?
		                p -> true :
	                    p -> p.getSessions().stream().anyMatch(s ->
	                            s.getName().equals(sessionName));
    }
}
