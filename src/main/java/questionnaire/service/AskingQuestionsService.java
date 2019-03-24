package questionnaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import questionnaire.domain.User;

import java.util.ArrayList;
import java.util.List;


@Component
public class AskingQuestionsService {

    private final UserService userService;
    private final QuestionsService questionsService;
    private final UserInteractionService userInteractionService;


    @Autowired
    public AskingQuestionsService(UserService userService
            , QuestionsService questionsService
            , UserInteractionService userInteractionService
    ) {
        this.userService = userService;
        this.questionsService = questionsService;
        this.userInteractionService = userInteractionService;
    }


    public void askQuestions (){

        String name = userInteractionService.requestName();
        String surname = userInteractionService.requestSurname();
        User user = userService.identifyUser(name, surname);
        userInteractionService.greetingUser(user);
        userInteractionService.intro();

        List<String> answers = new ArrayList<>();

        for (int i = 0; i < 3; i++){
            userInteractionService.question(i);
            String answer = userInteractionService.requestAnswer();
            answers.add(answer);
        }
        userInteractionService.goodbye();
        for (String answer : answers) {
            System.out.println(answer);
        }
    }


}
