package questionnaire.service;


import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import questionnaire.dao.QuestionsDAOImpl;
import questionnaire.dao.UserDAOImpl;
import questionnaire.domain.User;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AskingQuestionsServiceTest {

    private AskingQuestionsService askingQuestionsService;

    @Test
    void askQuestionsTest() {

        UserInteractionService uis = createUserInteractionMock();

        askingQuestionsService = new AskingQuestionsService(
                new UserServiceImpl(new UserDAOImpl())
                , new QuestionsServiceImpl(new QuestionsDAOImpl())
                , uis);

        askingQuestionsService.askQuestions();

        EasyMock.verify(uis);
    }

    private UserInteractionService createUserInteractionMock() {
        UserInteractionService uis = EasyMock.createMock(UserInteractionService.class);

        EasyMock.expect(uis.requestName()).andReturn("Vasya");
        EasyMock.expect(uis.requestSurname()).andReturn("Pupkin");
        User user = new User("Vasya", "Pupkin");
        EasyMock.expect(uis.greetingUser(EasyMock.anyObject())).andReturn("Hello "+user.getName());
        EasyMock.expect(uis.intro()).andReturn("Please answer questions");
        EasyMock.expect(uis.question(0)).andReturn("q1");
        EasyMock.expect(uis.requestAnswer()).andReturn("a1");
        EasyMock.expect(uis.question(1)).andReturn("q2");
        EasyMock.expect(uis.requestAnswer()).andReturn("a2");
        EasyMock.expect(uis.question(2)).andReturn("q3");
        EasyMock.expect(uis.requestAnswer()).andReturn("a3");
        EasyMock.expect(uis.goodbye()).andReturn("Thank you for your time!");

        EasyMock.replay(uis);

        return uis;
    }

}
