package cc.roberto.easygoband;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import cc.roberto.easygoband.services.RecruitmentService;
import cc.roberto.easygoband.services.RecruitmentServiceImpl;

/**
 * Configuración de la aplicación para la ejecución por línea de comandos.
 */
@SpringBootApplication
public class Application {

	public static void main(String args[]) {
	    SpringApplication app = new SpringApplication(Application.class);
	    app.setBannerMode(Mode.OFF);
	    app.run(args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public RecruitmentService recruitmentService(RestTemplate restTemplate) {
	    return new RecruitmentServiceImpl(restTemplate);
	}
	
	@Bean
	public ApplicationRunner run(RecruitmentService recruitmentService) throws Exception {
		return new Runner(recruitmentService);
	}
}
