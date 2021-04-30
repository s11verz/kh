package study.beans;

public class QuizDto {
	private int quizNo;
	private String quizContent;
	@Override
	public String toString() {
		return "QuizDto [quizNo=" + quizNo + ", quizContent=" + quizContent + "]";
	}
	public int getQuizNo() {
		return quizNo;
	}
	public void setQuizNo(int quizNo) {
		this.quizNo = quizNo;
	}
	public String getQuizContent() {
		return quizContent;
	}
	public void setQuizContent(String quizContent) {
		this.quizContent = quizContent;
	}
	public QuizDto() {
		super();
	}
}