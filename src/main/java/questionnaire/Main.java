package questionnaire;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import questionnaire.service.AskingQuestionsService;

@PropertySource("classpath:props.properties")
@ComponentScan
@Configuration
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        AskingQuestionsService askingQuestionsService = context.getBean(AskingQuestionsService.class);
        askingQuestionsService.askQuestions();
    }
}
