package com.test.utils;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="question_table")
public class Question {	
	
	@Id
	private int quesId;
	private int examId;
	private String examQuestion;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String correctAns;
	
	public Question() {
		// TODO Auto-generated constructor stub
	}

	public Question(int quesId, int examId, String examQuestion, String option1, String option2, String option3,
			String option4, String correctAns) {
		super();
		this.quesId = quesId;
		this.examId = examId;
		this.examQuestion = examQuestion;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correctAns = correctAns;
	}

	public int getQuesId() {
		return quesId;
	}

	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public String getExamQuestion() {
		return examQuestion;
	}

	public void setExamQuestion(String examQuestion) {
		this.examQuestion = examQuestion;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCorrectAns() {
		return correctAns;
	}

	public void setCorrectAns(String correctAns) {
		this.correctAns = correctAns;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + quesId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (quesId != other.quesId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Question [quesId=" + quesId + ", examId=" + examId + ", examQuestion=" + examQuestion + ", option1="
				+ option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4 + ", correctAns="
				+ correctAns + "]";
	}

	
	
	
	

}
