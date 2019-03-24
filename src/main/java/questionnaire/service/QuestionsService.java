package questionnaire.service;

import questionnaire.domain.Questions;

public interface QuestionsService {

    Questions loadQuestionsFromCSV(String csvFileName);

}
