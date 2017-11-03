package cc.roberto.easygoband;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import cc.roberto.easygoband.services.RecruitmentService;
import cc.roberto.easygoband.services.RecruitmentServiceImpl;

/**
 * Configuración de la aplicación para la ejecución de los tests.
 */
@Configuration
public class TestApplication {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public RecruitmentService recruitmentService(RestTemplate restTemplate) {
	    return new RecruitmentServiceImpl(restTemplate);
	}
}
