package br.edu.ifpb.analyzerQuestions.util.similarity;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifpb.analyzerQuestions.util.LuceneUtil;
import br.edu.ifpb.analyzerQuestions.util.StringUtil;

public class CounterFrequencyText {

	private static String[] textTokens;
	private static Map<String, Float> frequencyText;
	private static Float flag;

	static {
		frequencyText = new HashMap<String, Float>();
	}

	/**
	 * Obtém a frequencia de tokens em um texto
	 * 
	 * @param text
	 * @return
	 */
	public static VectorSimilarity getFrequency(String text) {

		String s0 = StringUtil.removeCharacterSpecial(text);
		String s1 = StringUtil.removerAcentos(s0);
		String s2 = StringUtil.removeConnective(s1);
		StringBuffer sb = new StringBuffer(s2);

		String aux = LuceneUtil.tokenizeString(sb).toString();
		textTokens = aux.split(" ");

		flag = (float) 1 / textTokens.length;

		if (textTokens.length != 0) {
			for (int i = 0; i < textTokens.length; i++) {

				String token = textTokens[i];
				Float frequency = frequencyText.get(token);

				if (frequency == null) {
					frequencyText.put(token, flag);

				} else {
					frequencyText.put(token, frequency + flag);
				}
			}

			frequencyText = removeSingleTokens(frequencyText);
		}
		VectorSimilarity vector = new VectorSimilarity();
		vector.setVector(frequencyText);
		return vector;
	}

	public static Map<String, Float> removeSingleTokens(Map<String, Float> map) {
		HashMap<String, Float> mapAux = new HashMap<String, Float>();
		for (String str : map.keySet()) {
			if (map.get(str) != flag) {
				mapAux.put(str, map.get(str));
			} else
				flag--;
		}
		return mapAux;
	}
}
