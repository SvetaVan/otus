package questionnaire.config;


import questionnaire.dao.QuestionsDAO;
import questionnaire.dao.UserDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import questionnaire.service.QuestionsService;
import questionnaire.service.QuestionsServiceImpl;
import questionnaire.service.UserService;
import questionnaire.service.UserServiceImpl;


@Configuration
public class ServiceConfig {


    @Bean
    public QuestionsService questionsService(QuestionsDAO questionsDAO){
        return new QuestionsServiceImpl(questionsDAO);
    }

    @Bean
    public UserService userService(UserDAO userDAO){
        return new UserServiceImpl(userDAO);
    }


}
