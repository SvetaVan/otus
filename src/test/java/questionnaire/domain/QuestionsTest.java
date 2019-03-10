package questionnaire.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


@DisplayName("Class Questions")
class QuestionsTest {

    @Test
    @DisplayName("creates questions list correctly")
    void listQuestions(){
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
        Questions questions = new Questions(listOfQuestions);

        assertThat(listOfQuestions).hasSize(2);
        assertThat(question1).containsExactlyInAnyOrder("q1","a1","a2","a3").doesNotContain("q2");
        assertThat(question2).containsExactlyInAnyOrder("q2","a1","a2","a3").doesNotContain("q1");



    }



}
