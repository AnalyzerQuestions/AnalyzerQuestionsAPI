package br.edu.ifpb.analyzerQuestions;

import br.edu.ifpb.analyzerQuestions.classification.TitleClassification;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		
		TitleClassification titleClassification = new TitleClassification();

		String a = "EM CAIXA ALTA";
		String b = "Não em a alta";
		

		
		System.out.println(titleClassification.TitleCapitaLettersPartially(b));
		
		
	}
}
