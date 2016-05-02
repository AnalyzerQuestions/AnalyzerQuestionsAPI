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
	public void mediumSizeTitleTest(){
		int i = title.mediumSizeTitle(Questions.t1);
		Assert.assertEquals(1, i);
	}
	
	/**
	 * Titulo letras apenas em caixa alta
	 */
	@Test
	public void TitleCapitaLettersTest(){
		int i = title.titleCapitaLetters(Questions.t1);
		Assert.assertEquals(0, i);
	}
	
	/**
	 * Testa titulo com parte em caixa alta
	 */
	@Test
	public void titleCapitaLettersPartially(){
		int i = title.titleCapitaLettersPartially(Questions.t1);
		Assert.assertEquals(0, i);
	}

}
