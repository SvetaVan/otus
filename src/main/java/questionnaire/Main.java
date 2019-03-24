package questionnaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import questionnaire.config.YamlProps;
import questionnaire.service.AskingQuestionsService;

@EnableConfigurationProperties(YamlProps.class)
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        AskingQuestionsService askingQuestionsService = context.getBean(AskingQuestionsService.class);
        askingQuestionsService.askQuestions();
    }
}
