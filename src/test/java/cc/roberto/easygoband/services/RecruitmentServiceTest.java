package cc.roberto.easygoband.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import cc.roberto.easygoband.TestApplication;
import cc.roberto.easygoband.domain.Parent;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestApplication.class)
@RestClientTest(RecruitmentService.class)
public class RecruitmentServiceTest {
	
	@Autowired
	private RecruitmentService recruitmentService;

	@Autowired
    private MockRestServiceServer server;
	
	@Test
	public void emptyResponse() {
	    server
	        .expect(requestTo("https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/1"))
	        .andExpect(method(HttpMethod.GET))
	        .andRespond(
	                withSuccess(
	                        "[]",
	                        MediaType.APPLICATION_JSON));
	    
	    List<Parent> result = recruitmentService.find(null);
	    
	    server.verify();
	    
		assertThat(result).isEmpty();
	}
    
    @Test
    public void one() {
        server
            .expect(requestTo("https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/1"))
            .andExpect(method(HttpMethod.GET))
            .andRespond(
                    withSuccess(
                            "[" +
                            "  {" +
                            "    \"access_group_name\":\"Abono\"," +
                            "    \"access_group_id\":1," +
                            "    \"total_uses\":0," +
                            "    \"sessions\":" +
                            "      [" +
                            "        {" +
                            "          \"name\":\"01-ABONO\"," +
                            "          \"id\":19" +
                            "        }" +
                            "      ]," +
                            "    \"event_id\":1," +
                            "    \"structure_decode\":false," +
                            "    \"name\":\"TKT CE ABONO 95\"," +
                            "    \"modified\":\"2017-05-30T17:42:27.000Z\"," +
                            "    \"id\":78," +
                            "    \"basic_product_id\":27" +
                            "  }" +
                            "]",
                            MediaType.APPLICATION_JSON));
        
        List<Parent> result = recruitmentService.find(null);
        
        server.verify();
        
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getAccessGroupName()).isEqualTo("Abono");
        // TODO Rest of properties.
    }
    
    @Test
    public void filter() {
        server
            .expect(requestTo("https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/1"))
            .andExpect(method(HttpMethod.GET))
            .andRespond(
                    withSuccess(
                            "[" +
                            "  {" +
                            "    \"access_group_name\":\"Abono\"," +
                            "    \"access_group_id\":1," +
                            "    \"total_uses\":0," +
                            "    \"sessions\":" +
                            "      [" +
                            "        {" +
                            "          \"name\":\"01-ABONO\"," +
                            "          \"id\":19" +
                            "        }" +
                            "      ]," +
                            "    \"event_id\":1," +
                            "    \"structure_decode\":false," +
                            "    \"name\":\"TKT CE ABONO 95\"," +
                            "    \"modified\":\"2017-05-30T17:42:27.000Z\"," +
                            "    \"id\":78," +
                            "    \"basic_product_id\":27" +
                            "  }," +
                            "  {" +
                            "    \"access_group_name\":\"Sábado\"," +
                            "    \"access_group_id\":1," +
                            "    \"total_uses\":0," +
                            "    \"sessions\":" +
                            "      [" +
                            "        {" +
                            "          \"name\":\"04-SABADO\"," +
                            "          \"id\":19" +
                            "        }" +
                            "      ]," +
                            "    \"event_id\":1," +
                            "    \"structure_decode\":false," +
                            "    \"name\":\"TKT CE ABONO 95\"," +
                            "    \"modified\":\"2017-05-30T17:42:27.000Z\"," +
                            "    \"id\":78," +
                            "    \"basic_product_id\":27" +
                            "  }" +
                            "]",
                            MediaType.APPLICATION_JSON));
        
        List<Parent> result = recruitmentService.find("04-SABADO");
        
        server.verify();
        
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getAccessGroupName()).isEqualTo("Sábado");
    }
}
