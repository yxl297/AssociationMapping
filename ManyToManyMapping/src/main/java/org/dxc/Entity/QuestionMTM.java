package org.dxc.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="questionMTM")
public class QuestionMTM {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String questionName;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="q_ans",
		joinColumns = { @JoinColumn(name = "q_id") },
		inverseJoinColumns = { @JoinColumn(name = "ans_id") })
	private List<AnswerMTM> answers;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public List<AnswerMTM> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerMTM> answers) {
		this.answers = answers;
	}

	
}
