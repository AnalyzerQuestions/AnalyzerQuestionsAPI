package br.edu.ifpb.analyzerQuestions;

import br.edu.ifpb.analyzerQuestions.classification.DescriptionClassification;
import br.edu.ifpb.analyzerQuestions.classification.TitleClassification;
import br.edu.ifpb.analyzerQuestions.util.StringFormatUtil;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		
		TitleClassification titleClassification = new TitleClassification();
		DescriptionClassification descriptionClassification = new DescriptionClassification();
		
		String a = "EM CAIXA ALTA";
		String b = "iai";
		

	
		System.out.println(descriptionClassification.includingVocative(b));
//		System.out.println(StringUtil.trimPosition(b));
		//System.out.println(b.charAt(6));
		
		
	}
}
