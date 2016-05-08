package br.edu.ifpb.analyzerQuestions;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifpb.analyzerQuestions.analyzers.QuestionsAnalyzer;
import br.edu.ifpb.analyzerQuestions.entities.Question;
import br.edu.ifpb.analyzerQuestions.util.data.Questions;

public class TestQuestion {
	
	QuestionsAnalyzer questionsAnalyzer;
	Question question;
	
	@Before
	public void setUp(){
		questionsAnalyzer = new QuestionsAnalyzer();
		question = new Question();
		question.setTitle(Questions.t2);
		question.setBody(Questions.d2);
	
	}
	@Test
	public void coherencyBodyAndTitle(){
		int in = questionsAnalyzer.coherencyBodyAndTitle(question);
	
		Assert.assertEquals(1, in);
	}

}
