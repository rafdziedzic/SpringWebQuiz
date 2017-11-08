package model;

public class Question {
    public String questionText;
    public String answers;
    public int correctAnswer;

    public Question(String questionText, String answers, int correctAnswer) {
        this.questionText = questionText;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (correctAnswer != question.correctAnswer) return false;
        if (questionText != null ? !questionText.equals(question.questionText) : question.questionText != null)
            return false;
        return answers != null ? answers.equals(question.answers) : question.answers == null;
    }

    @Override
    public int hashCode() {
        int result = questionText != null ? questionText.hashCode() : 0;
        result = 31 * result + (answers != null ? answers.hashCode() : 0);
        result = 31 * result + correctAnswer;
        return result;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionText='" + questionText + '\'' +
                ", answers='" + answers + '\'' +
                ", correctAnswer=" + correctAnswer +
                '}';
    }
}
