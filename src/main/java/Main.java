import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AskingQuestionsService;

public class Main {

    private static final  String CSV_FILE_LOCATION = "/Users/svetlanavanyushina/IdeaProjects/otus/src/main/resources/question.csv";

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        AskingQuestionsService askingQuestionsService = context.getBean(AskingQuestionsService.class);

        askingQuestionsService.askQuestions(CSV_FILE_LOCATION);

    }
}
