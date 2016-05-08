package br.edu.ifpb.analyzerQuestions.util.similarity;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifpb.analyzerQuestions.util.LuceneUtil;

public class FrequencyWordText {

	private static String[] textTokens;
	private static Map<String, Float> frequencyText;

	static {
		frequencyText = new HashMap<String, Float>();
	}

	/**
	 * Obtém a frequencia de tokens em um texto
	 * 
	 * @param text
	 * @return
	 */
	public static Vector getFrequency(String text) {

		StringBuffer sb = new StringBuffer(text);

		String aux = LuceneUtil.tokenizeString(sb).toString();
		textTokens = aux.split(" ");

		if (textTokens.length != 0) {

			for (int i = 0; i < textTokens.length; i++) {
				
				String token = textTokens[i];
				Float frequency = frequencyText.get(token);

				if (frequency == null) {
					frequencyText.put(token, 1F);
				} else {
					frequencyText.put(token, frequency + 1);
				}
			}
		}
		return new Vector(frequencyText);
	}
}
