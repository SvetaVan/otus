package service;

import dao.QuestionsDAO;
import domain.Questions;

public class QuestionsServiceImpl implements QuestionsService {
    private final QuestionsDAO questionsDAO;

    public QuestionsServiceImpl(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }


    @Override
    public Questions loadQuestionsFromCSV(String csvFile_name) {
        return questionsDAO.loadQuestionsFromCSV(csvFile_name);
    }

}
