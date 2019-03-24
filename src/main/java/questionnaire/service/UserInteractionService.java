package questionnaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import questionnaire.config.YamlProps;
import questionnaire.domain.User;

import java.util.Locale;
import java.util.Scanner;

@Component
public class UserInteractionService {

    @Autowired
    private MessageSource messageSource;

    private final Locale localization;


    public UserInteractionService(YamlProps yamlProps) {
        if (yamlProps.getLocale().equals("ru")) {
            this.localization = Locale.forLanguageTag("ru");
        } else {
            this.localization = Locale.ENGLISH;
        }
    }

    public String requestName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(messageSource.getMessage("request.user.name", null, localization));
        return scanner.nextLine();

    }

    public String requestSurname(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(messageSource.getMessage("request.user.surname", null, localization));
        return scanner.nextLine();
    }

    public String greetingUser(User user){
        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format(
                messageSource.getMessage("greeting.user", null, localization)
                , user.getName()
                , user.getSurname())
        );
        return scanner.nextLine();
    }

    public String intro(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(messageSource.getMessage("introduction", null, localization));
        return scanner.nextLine();
    }

    public String question(int questionNumber){
        Scanner scanner = new Scanner(System.in);
        System.out.println(messageSource.getMessage("question" + questionNumber, null, localization));
        return scanner.nextLine();
    }

    public String requestAnswer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(messageSource.getMessage("request.answer", null, localization));
        return scanner.nextLine();
    }

    public String goodbye (){
        Scanner scanner = new Scanner(System.in);
        System.out.println(messageSource.getMessage("goodbye.message", null, localization));
        return scanner.nextLine();
    }

}
