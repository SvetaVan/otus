package questionnaire.dao;

import questionnaire.domain.Questions;
import org.springframework.stereotype.Component;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvListReader;
import org.supercsv.io.ICsvListReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionsDAOImpl implements QuestionsDAO {

    @Override
    public Questions loadQuestionsFromCSV(String csvFileName) {
        return new Questions(readWithCsvBeanReader(csvFileName));
    }

    private static List<List<String>> readWithCsvBeanReader(String csvFileName){

        List<List<String>> questionsToReturn = new ArrayList<>();
        try (ICsvListReader listReader  = new CsvListReader(new FileReader(csvFileName), CsvPreference.STANDARD_PREFERENCE)){

            final CellProcessor[] processors = getProcessors();

            List<Object> questionAnswersList;
            while((questionAnswersList = listReader.read(processors)) != null ) {
                questionsToReturn.add(convertToString(questionAnswersList));
            }
        } catch (Exception e) {
            new IllegalStateException(e);
        }
        return questionsToReturn;
    }

    private static List<String> convertToString(List<Object> objectList){
        return objectList.stream().map(e->String.valueOf(e)).collect(Collectors.toList());
    }

    private static CellProcessor[] getProcessors() {
        return new CellProcessor[]{
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
        };
    }

}
