package questionnaire.service;

import org.apache.commons.lang3.LocaleUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import questionnaire.domain.Questions;
import questionnaire.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


@Component
public class AskingQuestionsService {
    @Autowired
    private MessageSource messageSource;

    private final UserService userService;
    private final QuestionsService questionsService;
    private final String csvFileAddress;
    private final String localization;

    @Autowired
    public AskingQuestionsService(UserService userService
            , QuestionsService questionsService
            , @Value("${csvaddress}") String csvFileAddress
            , @Value("${localization}") String localization
    ) {
        this.userService = userService;
        this.questionsService = questionsService;
        this.csvFileAddress = csvFileAddress;
        this.localization = localization;
    }

    public void askQuestions (String fileName){
        Locale localeToUse = Locale.ENGLISH;
        if (localization.equals("ru")){
            localeToUse = new Locale("ru");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println(messageSource.getMessage("request.user.name", null, localeToUse));
        String name = scanner.nextLine();

        System.out.println(messageSource.getMessage("request.user.surname", null, localeToUse));
        String surname = scanner.nextLine();

        User user = userService.identifyUser(name, surname);
        Questions questions = questionsService.loadQuestionsFromCSV(fileName);
        System.out.println(String.format(
                messageSource.getMessage("greeting.user", null, localeToUse)
                , user.getName()
                , user.getSurname())
        );
        System.out.println(messageSource.getMessage("introduction", null, localeToUse));

        List<String> answers = new ArrayList<>();

        for (int i = 0; i < questions.getQuestion().size(); i++){
            if(questions.getQuestion().get(i).contains("Question")){
                continue;
            }
            System.out.println(messageSource.getMessage("question" + i, null, localeToUse));
            System.out.println(messageSource.getMessage("request.answer", null, localeToUse));
            String answer = scanner.nextLine();
            answers.add(answer);
        }
        System.out.println(messageSource.getMessage("goodbye.message", null, localeToUse));
        for (String answer : answers) {
            System.out.println(answer);
        }
    }

    public String getCsvFileAddress() {
        return csvFileAddress;
    }

}
