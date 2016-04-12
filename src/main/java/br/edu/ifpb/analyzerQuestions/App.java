package br.edu.ifpb.analyzerQuestions;

import br.edu.ifpb.analyzerQuestions.classification.DescriptionClassification;
import br.edu.ifpb.analyzerQuestions.classification.TitleClassification;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		
		TitleClassification titleClassification = new TitleClassification();
		DescriptionClassification descriptionClassification = new DescriptionClassification();
		
		String a = "EM CAIXA ALTA do";
		String b = " Alguem poderia me dar uma melhor definição do** laço for each**, algum exemplo ? Desde já agradeço";
		

	
		System.out.println(descriptionClassification.showingExample(a));
//		System.out.println(descriptionClassification.shortDescription(b));
//		System.out.println(descriptionClassification.shortDescription(b));
		//System.out.println(descriptionClassification.includingVocative(b));
//		System.out.println(StringUtil.trimPosition(b));
		//System.out.println(b.charAt(6));

		
	}
}
