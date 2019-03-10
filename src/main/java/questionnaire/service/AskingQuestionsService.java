package questionnaire.service;

import org.springframework.beans.factory.annotation.Value;
import questionnaire.domain.Questions;
import questionnaire.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Component
public class AskingQuestionsService {

    private final UserService userService;
    private final QuestionsService questionsService;
    private final UserInteractionService userInteractionService;
    private final String csvFileAddress;


    @Autowired
    public AskingQuestionsService(UserService userService
            , QuestionsService questionsService
            , UserInteractionService userInteractionService
            , @Value("${csvaddress}") String csvFileAddress
    ) {
        this.userService = userService;
        this.questionsService = questionsService;
        this.csvFileAddress = csvFileAddress;
        this.userInteractionService = userInteractionService;
    }


    public void askQuestions (){

        String name = userInteractionService.requestName();
        String surname = userInteractionService.requestSurname();
        User user = userService.identifyUser(name, surname);
        Questions questions = questionsService.loadQuestionsFromCSV(csvFileAddress);
        userInteractionService.greetingUser(user);
        userInteractionService.intro();

        List<String> answers = new ArrayList<>();

        for (int i = 0; i < questions.getQuestion().size(); i++){
            if(questions.getQuestion().get(i).contains("Question")){
                continue;
            }
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
