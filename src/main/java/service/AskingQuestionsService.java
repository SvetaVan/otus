package service;

import domain.Questions;
import domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AskingQuestionsService {
    private final UserService userService;
    private final QuestionsService questionsService;

    public AskingQuestionsService(UserService userService, QuestionsService questionsService) {
        this.userService = userService;
        this.questionsService = questionsService;
    }

    public void askQuestions (String fileName){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String name = scanner.nextLine();
        System.out.println("Enter your surname: ");
        String surname = scanner.nextLine();

        User user = userService.identifyUser(name, surname);
        Questions questions = questionsService.loadQuestionsFromCSV(fileName);
        System.out.println(String.format("Hello, %s %s!", user.getName(), user.getSurname()));
        System.out.println("Please answer several questions: ");

        List<String> answers = new ArrayList<>();
        for (List<String> question : questions.getQuestion()) {
            if(question.get(0).contains("Question")){
                continue;
            }
            System.out.println(question);
            System.out.println("Please enter your answer: ");
            String answer = scanner.nextLine();
            answers.add(answer);
        }
        System.out.println("Thank you for your time! Your answers are: ");
        for (String answer : answers) {
            System.out.println(answer);
        }
    }






}
