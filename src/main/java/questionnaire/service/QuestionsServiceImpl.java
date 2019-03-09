package questionnaire.service;

import questionnaire.dao.QuestionsDAO;
import questionnaire.domain.Questions;

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
