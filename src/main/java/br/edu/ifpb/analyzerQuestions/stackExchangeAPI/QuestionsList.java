package br.edu.ifpb.analyzerQuestions.stackExchangeAPI;

import java.util.Arrays;

import br.edu.ifpb.analyzerQuestions.entities.Question;

public class QuestionsList{

	private Question questions[];

	public Question[] getQuestions() {
		return questions;
	}

	public void setQuestions(Question[] questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "QuestionsList [questions="
				+ (questions != null ? Arrays.asList(questions).subList(0,
						Math.min(questions.length, maxLen)) : null)
				+ ", getQuestions()="
				+ (getQuestions() != null ? Arrays.asList(getQuestions())
						.subList(0, Math.min(getQuestions().length, maxLen))
						: null) + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
