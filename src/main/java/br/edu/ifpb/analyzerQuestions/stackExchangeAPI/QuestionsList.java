package br.edu.ifpb.analyzerQuestions.stackExchangeAPI;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.analyzerQuestions.entities.Question;

public class QuestionsList {

	private List<Question> questions;

	public QuestionsList() {
		questions = new ArrayList<Question>();
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

}
