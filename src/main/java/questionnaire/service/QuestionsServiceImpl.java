package questionnaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import questionnaire.dao.QuestionsDAO;
import questionnaire.domain.Questions;

@Service
public class QuestionsServiceImpl implements QuestionsService {
    private final QuestionsDAO questionsDAO;

    @Autowired
    public QuestionsServiceImpl(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }


    @Override
    public Questions loadQuestionsFromCSV(String csvFile_name) {
        return questionsDAO.loadQuestionsFromCSV(csvFile_name);
    }

}
