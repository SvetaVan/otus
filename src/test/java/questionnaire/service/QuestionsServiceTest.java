package questionnaire.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import questionnaire.dao.QuestionsDAO;
import questionnaire.domain.Questions;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class QuestionsServiceTest {
    @Mock
    private QuestionsDAO questionsDAO;

    private QuestionsService questionsService;

    @BeforeEach
    void setUp() {
        questionsService = new QuestionsServiceImpl(questionsDAO);
    }

    @Test
    void loadQuestions() {
        List<List<String>> listOfQuestions = new ArrayList<>();
        List<String> question1 = new ArrayList<>();
        question1.add("q1");
        question1.add("a1");
        question1.add("a2");
        question1.add("a3");
        listOfQuestions.add(question1);

        List<String> question2 = new ArrayList<>();
        question2.add("q2");
        question2.add("a1");
        question2.add("a2");
        question2.add("a3");
        listOfQuestions.add(question2);

        given(questionsDAO.loadQuestionsFromCSV(any())).willReturn(new Questions(listOfQuestions));

        assertThat(questionsService.loadQuestionsFromCSV("address")).isNotNull().hasNoNullFieldsOrProperties();

    }


}
