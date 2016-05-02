package br.edu.ifpb.analyzerQuestions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.ifpb.analyzerQuestions.classification.TitleClassification;

public class TestTitle{
	
	private TitleClassification title;
	
	@Before
	public void setUp(){
		title = new TitleClassification();
	}
	
	/**
	 * Testa tamanho medio do titulo
	 */
	@Test
	public void mediumSizeTitle(){
		int i = title.mediumSizeTitle(Questions.t1);
		Assert.assertEquals(i, 1);
	}
	
	/**
	 * Titulo letras apenas em caixa alta
	 */
	public void TitleCapitaLetters(){
		int i = title.TitleCapitaLetters(Questions.t1);
		Assert.assertEquals(i, 1);
	}

}
