package com.assignment.easygoband.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.assignment.easygoband.constants.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class EasyGoBandService implements IEasyGoBandService{

	Logger logger = LoggerFactory.getLogger(EasyGoBandService.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public List<Map<String, Object>> getProviders(String event) {
		Optional<String> eventOpt = Optional.ofNullable(event);
		ResponseEntity<String> response = null;
		List<Map<String, Object>> resObj = null;
		try {
			if(eventOpt.isPresent()) {

				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				headers.add("Authorization","Basic cJmAc71jah17sgqi1jqaksvaksda=");
				
				HttpEntity<String> entity = new HttpEntity<String>(headers);
				
				response = restTemplate.exchange(
						Constants.PROVIDER_URI,
				        HttpMethod.GET,
				        entity,
				        String.class,
				        eventOpt.get()
				);
			}
		} 
		catch (RestClientException e) {
			logger.error("Exception while making the rest call", e);
		}
		catch (Exception e) {
			logger.error("Exception while making the rest call", e);
		}
		if(null != response.getBody()) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				resObj = mapper.readValue(response.getBody(), new TypeReference<List<Map<String, Object>>>(){});
			} catch (JsonProcessingException e) {
				logger.error("Exception while processing the json", e);
			}
			catch (Exception e) {
				logger.error("Exception while mapping json to object", e);
			}
			
		}
		return resObj;
	}

}
