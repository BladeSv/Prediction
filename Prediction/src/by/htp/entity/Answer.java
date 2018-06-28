package by.htp.entity;

public class Answer implements Comparable<Answer> {
	private String answer;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public int compareTo(Answer o) {

		return this.answer.compareTo(o.getAnswer());
	}

}
