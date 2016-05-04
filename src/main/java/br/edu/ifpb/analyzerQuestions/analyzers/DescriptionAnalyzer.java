package br.edu.ifpb.analyzerQuestions.analyzers;

import br.edu.ifpb.analyzerQuestions.util.StringFormatUtil;
import br.edu.ifpb.analyzerQuestions.util.WordExamples;

public class DescriptionAnalyzer {

	/**
	 * Understandable description
	 */
	public int understandableDescription(String description) {

		return 0;
	}

	/**
	 * presença de  vocativo
	 */
	public int includingVocative(String description) {
		String str1 = StringFormatUtil.trimPosition(description);
		String str2 = StringFormatUtil.removeConnective(str1);
		String[] str = str2.split(" ");
		String p1 = str[0];
		if (p1.charAt(p1.length() - 1) == ',') {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * Evitar desecrição curta da pergunta
	 */
	public int shortDescription(String description) {
		String str = StringFormatUtil.removeCharacterSpecial(description);
		str = StringFormatUtil.removeConnective(str);
		String strSplited[] = str.split(" ");
		if (strSplited.length > 10)
			return 1;
		return 0;
	}

	/**
	 * Evitar descrição longa demais na pergunta
	 */
	public int longDescription(String description) {
		String str = StringFormatUtil.removeCharacterSpecial(description);
		str = StringFormatUtil.removeConnective(str);
		String strSplited[] = str.split(" ");
		if (strSplited.length < 700)
			return 1;
		return 0;
	}

	/**
	 * Presença de exemplo
	 */
	public int showingExample(String description) {
		String str = StringFormatUtil.removeCharacterSpecial(description);
		str = StringFormatUtil.removeConnective(str);

		if (frenquencyOfCode(str) > 4) {
			return 1;
		}

		for (int i = 0; i < WordExamples.getWords().length; i++) {
			String word = WordExamples.getWords()[i];

			if (description.contains(word)) {
				return 1;
			}
		}
		return 0;

	}

	private int frenquencyOfCode(String description) {
		int flag = 0;
		for (int i = 0; i < WordExamples.getWordsCode().length; i++) {
			String word = WordExamples.getWordsCode()[i];

			if (description.contains(word)) {
				flag += 1;
			}
		}
		return flag;
	}

	/**
	 * Avoiding too much code
	 */
	public int avoidingMuchCode(String description) {
		return 0;
	}

	/**
	 * Avoid description with code only
	 */
	public int avoidDescriptionWithCodeOnly(String description) {
		return 0;
	}

}
