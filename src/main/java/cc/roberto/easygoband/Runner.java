package cc.roberto.easygoband;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import cc.roberto.easygoband.domain.Parent;
import cc.roberto.easygoband.domain.ParentPrinter;
import cc.roberto.easygoband.services.RecruitmentService;

/**
 * Ejecuta la aplicación por línea de comandos.
 */
public class Runner implements ApplicationRunner {

    private RecruitmentService recruitmentService;
    
    public Runner(RecruitmentService recruitmentService) {
        this.recruitmentService = recruitmentService;
    }
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String sessionName = null;
        
        if (args.containsOption("sessionName")) {
            List<String> sessionNameValues = args.getOptionValues("sessionName");
            if (sessionNameValues.size() > 0) {
                sessionName = sessionNameValues.get(sessionNameValues.size() - 1);
            }
        }
        
        List<Parent> data = recruitmentService.find(sessionName);
        
        data.forEach(p -> System.out.println(ParentPrinter.print(p)));
    }
}
