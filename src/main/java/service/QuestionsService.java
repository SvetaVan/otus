package service;

import domain.Questions;

public interface QuestionsService {

    Questions loadQuestionsFromCSV(String csvFileName);

}
