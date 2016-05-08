package br.edu.ifpb.analyzerQuestions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.ifpb.analyzerQuestions.analyzers.DescriptionAnalyzer;
import br.edu.ifpb.analyzerQuestions.util.data.Questions;

public class TestDescription {
	
	private DescriptionAnalyzer description;
	
	@Before
	public void setUp(){
		description = new DescriptionAnalyzer();
	}
	
	/**
	 * testa presença de vocativo
	 */
	@Test
	public void includingVocativeTest(){
		int i = description.includingVocative(Questions.d1);
		Assert.assertEquals(1, i);
	}
	
	/**
	 * Testa, evitar descrição muito curta
	 */
	@Test
	public void shortDescriptionTest(){
		int i = description.shortDescription(Questions.d1);
		Assert.assertEquals(1, i);
	}
	
	/**
	 * Evitar descrição muito longa
	 */
	@Test
	public void longDescriptionTest(){
		int i = description.longDescription(Questions.d1);
		Assert.assertEquals(1, i);
	}
	
	/**
	 * Presença de exemplo na pergunta
	 */
	@Test
	public void showingExampleTest(){
		int i = description.showingExample(Questions.d1);
		Assert.assertEquals(1, i);
	}
	
	@Test
	public void includingGreetingsTest(){
		int i = description.includingGreetings(Questions.d1);
		Assert.assertEquals(1, i);
	}
}
