package questionnaire.service;


import org.easymock.EasyMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import questionnaire.dao.QuestionsDAO;
import questionnaire.dao.QuestionsDAOImpl;
import questionnaire.dao.UserDAOImpl;
import questionnaire.domain.Questions;
import questionnaire.domain.User;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@PropertySource("classpath:testprops.properties")
@ExtendWith(MockitoExtension.class)
public class AskingQuestionsServiceTest extends AbstractJUnit4SpringContextTests {

    @Mock
    private UserInteractionService userInteractionService;

    private AskingQuestionsService askingQuestionsService;

   /* @BeforeEach
    void setUp() {
        askingQuestionsService = new AskingQuestionsService(
                new UserServiceImpl(new UserDAOImpl())
                , new QuestionsServiceImpl(new QuestionsDAOImpl())
                , userInteractionService
                , "${csvaddress}");
    }*/

    @Test
    void askQuestionsTest() {

        UserInteractionService uis = createUserInteractionMock();


        askingQuestionsService = new AskingQuestionsService(
                new UserServiceImpl(new UserDAOImpl())
                , new QuestionsServiceImpl(new QuestionsDAOImpl())
                , uis
                , "/Users/svetlanavanyushina/IdeaProjects/otus/src/main/resources/question.csv");


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
        EasyMock.expect(uis.question(1)).andReturn("q1");
        EasyMock.expect(uis.requestAnswer()).andReturn("a1");
        EasyMock.expect(uis.question(2)).andReturn("q2");
        EasyMock.expect(uis.requestAnswer()).andReturn("a2");
        EasyMock.expect(uis.question(3)).andReturn("q3");
        EasyMock.expect(uis.requestAnswer()).andReturn("a3");
        EasyMock.expect(uis.goodbye()).andReturn("Thank you for your time!");

        EasyMock.replay(uis);

        return uis;
    }


}
