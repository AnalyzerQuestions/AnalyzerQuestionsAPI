package br.edu.ifpb.analyzerQuestions.analyzers;

import br.edu.ifpb.analyzerQuestions.util.StringUtil;
import br.edu.ifpb.analyzerQuestions.util.data.WordsUtils;

public class DescriptionAnalyzer {
	
	/**
	 * NÃO ESTA COBRINDO:
	 * 
	 *  Obviating demanding language
	 *	Using proper language
	 *	Avoiding creating duplicate questions
	 *	Avoiding creating factoid questions
	 *	Do not create homework questions
	 */

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
		String str1 = StringUtil.trimPosition(description);
		String str2 = StringUtil.removeConnective(str1);
		String[] str = str2.split(" ");
				
		if(str.length >= 3){
			for (int i = 0; i < 3; i++) {
				String sn = str[i];
				if (sn.charAt(sn.length() - 1) == ',') {
					return 1;
				}
			}
			String s0 = str[0];
			for (int i = 0; i < WordsUtils.WORDS_VACATIVES.length; i++) {
				if(s0.equals(WordsUtils.WORDS_VACATIVES[i])){
					return 1;
				}
			}
		}
		
		return 0;
	}

	/**
	 * Evitar desecrição curta da pergunta
	 */
	public int shortDescription(String description) {
		String str = StringUtil.removeCharacterSpecial(description);
		str = StringUtil.removeConnective(str);
		String strSplited[] = str.split(" ");
		if (strSplited.length > 10)
			return 1;
		return 0;
	}

	/**
	 * Evitar descrição longa demais na pergunta
	 */
	public int longDescription(String description) {
		String str = StringUtil.removeCharacterSpecial(description);
		str = StringUtil.removeConnective(str);
		String strSplited[] = str.split(" ");
		if (strSplited.length < 700)
			return 1;
		return 0;
	}

	/**
	 * Presença de exemplo
	 */
	public int showingExample(String description) {
		String str = StringUtil.removeCharacterSpecial(description);
		str = StringUtil.removeConnective(str);

		if (frenquencyOfCode(str) > 4) {
			return 1;
		}

		for (int i = 0; i < WordsUtils.getWords().length; i++) {
			String word = WordsUtils.getWords()[i];

			if (description.contains(word)) {
				return 1;
			}
		}
		return 0;

	}

	private int frenquencyOfCode(String description) {
		int flag = 0;
		for (int i = 0; i < WordsUtils.getWordsCode().length; i++) {
			String word = WordsUtils.getWordsCode()[i];

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
	
	/**
	 * Restricting each question to a single problem
	 */
	public int questionWithSingleProblem(String description) {
		return 0;
	}
	
	/**
	 * Including greetings
	 */
	public int includingGreetings(String description){
		String s0 = StringUtil.removeConnective(description);
		String s1 = StringUtil.removeCharacterSpecial(s0);
		
		for (int i = 0; i < WordsUtils.WORDS_GREETINGS.length; i++) {
			if(s1.contains(WordsUtils.WORDS_GREETINGS[i])){
				return 1;
			}
		}
		return 0;
	}
}
