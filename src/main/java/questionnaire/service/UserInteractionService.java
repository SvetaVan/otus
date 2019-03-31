package questionnaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import questionnaire.domain.User;

import java.util.Locale;

@Component
public class UserInteractionService {

    @Autowired
    private MessageSource messageSource;

    private final Locale localization;


    public UserInteractionService(@Value("${localization}") String localization) {
        if (localization.equals("ru")) {
            this.localization = Locale.forLanguageTag("ru");
        } else {
            this.localization = Locale.ENGLISH;
        }
    }

    public String requestName(String name){
        return "Name is" + name;

    }

    public String requestSurname(String surname){
        return "Surname is" + surname;
    }

    public String greetingUser(User user){
        return String.format(
                messageSource.getMessage("greeting.user", null, localization)
                , user.getName()
                , user.getSurname()
        );
    }

    public String intro(){
        return messageSource.getMessage("introduction", null, localization);
    }

    public String question(int questionNumber){
        return messageSource.getMessage("question" + questionNumber, null, localization);
    }

    public String requestAnswer(){
        return messageSource.getMessage("request.answer", null, localization);
    }

    public String goodbye (){
        return messageSource.getMessage("goodbye.message", null, localization);
    }

}
