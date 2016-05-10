package br.edu.ifpb.analyzerQuestions.stackExchangeAPI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.edu.ifpb.analyzerQuestions.entities.Question;

/**
 * 
 * @author franck
 *
 */

/**
 * Modelo para representar uma lista de questões, uso na API do SE
 *
 */
public class QuestionsList implements Iterable<Question> {

	private List<Question> questions = new ArrayList<Question>();

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "QuestionsList [questions="
				+ (questions != null ? questions.subList(0,
						Math.min(questions.size(), maxLen)) : null) + "]";
	}

	public Iterator<Question> iterator() {
		return questions.iterator();
	}
}
