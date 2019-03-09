package questionnaire.dao;

import questionnaire.domain.Questions;

public interface QuestionsDAO {
    Questions loadQuestionsFromCSV(String csvFileName);
}
