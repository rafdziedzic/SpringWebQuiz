package dziedzic.rafal.webQuiz.model;

public class Question {
    public String questionText;
    public String answersA;
    public String answersC;
    public String answersB;
    public int userAnswer;
    private int correctAnswer;

    public Question(String questionText, String answersA, String answersC, String answersB, int correctAnswer) {
        this.questionText = questionText;
        this.answersA = answersA;
        this.answersC = answersC;
        this.answersB = answersB;
        this.correctAnswer = correctAnswer;
    }

    public Question() {
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswersA() {
        return answersA;
    }

    public void setAnswersA(String answersA) {
        this.answersA = answersA;
    }

    public String getAnswersC() {
        return answersC;
    }

    public void setAnswersC(String answersC) {
        this.answersC = answersC;
    }

    public String getAnswersB() {
        return answersB;
    }

    public void setAnswersB(String answersB) {
        this.answersB = answersB;
    }

    public int getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionText='" + questionText + '\'' +
                ", answersA='" + answersA + '\'' +
                ", answersC='" + answersC + '\'' +
                ", answersB='" + answersB + '\'' +
                ", userAnswer=" + userAnswer +
                ", correctAnswer=" + correctAnswer +
                '}';
    }
}
