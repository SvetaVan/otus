package questionnaire.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.stereotype.Component;
import questionnaire.domain.User;
import questionnaire.service.UserInteractionService;
import questionnaire.service.UserService;

import java.util.ArrayList;
import java.util.List;


@ShellComponent
public class AskingQuestionsCommands {

    private final UserService userService;
    private final UserInteractionService userInteractionService;


    @Autowired
    public AskingQuestionsCommands(UserService userService
            , UserInteractionService userInteractionService
    ) {
        this.userService = userService;
        this.userInteractionService = userInteractionService;
    }

    @ShellMethod("Asking user name")
    public String requestName(@ShellOption String name) {
        return userInteractionService.requestName(name);
    }

    @ShellMethod("Asking user surname")
    public String requestSurname(@ShellOption String surname) {
        return userInteractionService.requestSurname(surname);
    }

    @ShellMethod("Identify user")
    public String identifyUser(@ShellOption String name, @ShellOption String surname) {
        User user = userService.identifyUser(name, surname);
        return userInteractionService.greetingUser(user);
    }

    @ShellMethod("Introduction")
    public String intro(){
        return userInteractionService.intro();
    }

    @ShellMethod("Asking questions")
    public String askQuestion(@ShellOption int questionNumber){
        return userInteractionService.question(questionNumber);
    }

    @ShellMethod("Answer questions")
    public String answerQuestion(@ShellOption String answer){
        return userInteractionService.requestAnswer();
    }

    @ShellMethod("Goodbye")
    public String goodbye(){
        return userInteractionService.goodbye();
    }
}
