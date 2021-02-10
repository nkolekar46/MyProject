package com.test.utils;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="onlineExam_table")
public class onlineExam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int examId;
	private String examName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Question> que;
	
	public onlineExam() {
		// TODO Auto-generated constructor stub
	}

	public onlineExam(int examId, String examName, List<Question> que) {
		super();
		this.examId = examId;
		this.examName = examName;
		this.que = que;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public List<Question> getQue() {
		return que;
	}

	public void setQue(List<Question> que) {
		this.que = que;
	}

	@Override
	public String toString() {
		return "onlineExam [examId=" + examId + ", examName=" + examName + ", que=" + que + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + examId;
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
		onlineExam other = (onlineExam) obj;
		if (examId != other.examId)
			return false;
		return true;
	}
	
	

}
