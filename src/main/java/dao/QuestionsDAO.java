package dao;

import domain.Questions;

public interface QuestionsDAO {
    Questions loadQuestionsFromCSV(String csvFileName);
}
