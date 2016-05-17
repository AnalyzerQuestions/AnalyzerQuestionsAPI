package br.edu.ifpb.analyzerQuestions.analyzers;

import br.edu.ifpb.analyzerQuestions.util.StringUtil;
import br.edu.ifpb.analyzerQuestions.util.data.WordsUtils;

public class DescriptionAnalyzer {

	/**
	 * Understandable
	 */

	/**
	 * Considera-se pesos para cada caracteristca que a descrição atende, sendo
	 * que umas tem pesos maiores que outras. Considera-se que a descrição tenha
	 * 70% dos pesos das caracteristicas cobradas
	 * 
	 * p1 + p2  + p3 + p(n)/1.40(=~70%)
	 */
	public int understandableDescription(String description) {
		float is = 0;
		float bestResult = 1f + 1f + 0.5f + 0.2f + 0.1f;

		if (shortDescription(description) == 1) {
			is++;
		}
		if (longDescription(description) == 1) {
			is++;
		}
		if (showingExample(description) == 1) {
			is += 0.5f;
		}
		if (includingGreetings(description) == 1) {
			is += 0.2f;
		}
		if (includingVocative(description) == 1) {
			is = is + 0.1f;
		}
		if (is >= (bestResult/1.40)) {
			return 1;
		}
		return 0;
	}

	/**
	 * presença de vocativo
	 */
	public int includingVocative(String description) {
		String str1 = StringUtil.trimPosition(description);
		String str2 = StringUtil.removeConnective(str1);
		String[] str = str2.split(" ");

		if (str.length >= 3) {
			for (int i = 0; i < 3; i++) {
				String sn = str[i];
				if (sn.charAt(sn.length() - 1) == ',') {
					return 1;
				}
			}
			String s0 = str[0];
			for (int i = 0; i < WordsUtils.WORDS_VACATIVES.length; i++) {
				if (s0.equals(WordsUtils.WORDS_VACATIVES[i])) {
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
		if (strSplited.length < 800)
			return 1;
		return 0;
	}

	/**
	 * Presença de exemplo
	 */
	public int showingExample(String description) {
		String str = StringUtil.removeCharacterSpecial(description);
		str = StringUtil.removeConnective(str);

		if (frenquencyOfCode(str) > 3) {
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
	 * Evitar muito codigo
	 */
	public int avoidingMuchCode(String description) {
		return 0;
	}

	/**
	 * evitar descricao com apenas código
	 */
	public int avoidDescriptionWithCodeOnly(String description) {
		return 0;
	}

	/**
	 * Restringir a pergunta a um unico problema
	 */
	public int questionWithSingleProblem(String description) {
		int flag = 0;
		for (int i = 0; i < description.length(); i++) {
			if (description.charAt(i) == '?') {
				flag++;
			}
		}
		if (flag > 1) {
			return 1;
		}
		return 0;
	}

	/**
	 * Including greetings
	 */
	public int includingGreetings(String description) {
		String s0 = StringUtil.removeCharacterSpecial(description);
		String s1 = StringUtil.removeConnective(s0);

		for (int i = 0; i < WordsUtils.WORDS_GREETINGS.length; i++) {
			if (s1.contains(WordsUtils.WORDS_GREETINGS[i])) {
				return 1;
			}
		}
		return 0;
	}

	/**
	 * Obviating demanding language
	 */
	public int obviatingDemandingLanguage(String description) {

		return 0;
	}

	/**
	 * Using proper language
	 */
	public int usingProperLanguage(String description) {
		return 0;
	}

	/**
	 * Avoiding creating factoid questions
	 */
	public int avoidingCreatingFactoidQuestions(String description) {
		return 0;
	}

	/**
	 * Do not create homework questions
	 */
	public int doNotCreateHomeworkQuestions(String description) {
		return 0;
	}
}
