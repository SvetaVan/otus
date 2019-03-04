package domain;

import java.util.List;

public class Questions {
    private List<List<String>> question;

    public Questions(List<List<String>> question) {
        this.question = question;
    }

    public List<List<String>> getQuestion() {
        return question;
    }

    public void setQuestion(List<List<String>> question) {
        this.question = question;
    }
}
