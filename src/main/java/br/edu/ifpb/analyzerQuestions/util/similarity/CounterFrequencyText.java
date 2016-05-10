package br.edu.ifpb.analyzerQuestions.util.similarity;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifpb.analyzerQuestions.util.LuceneUtil;
import br.edu.ifpb.analyzerQuestions.util.StringUtil;

public class CounterFrequencyText {

	private static String[] textTokens;
	private static Map<String, Float> frequencyText;
	private static Float flag;

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
		String[] textTokens = aux.split(" ");
		System.out.println(aux);
		Map<String, Float> frequencyText = new HashMap<String, Float>();

		if (textTokens.length != 0) {
			float tam = (float) textTokens.length;
			for (int i = 0; i < textTokens.length; i++) {

				String token = textTokens[i];
				Float frequency = frequencyText.get(token);

				if (frequency == null) {
					frequencyText.put(token, 1f);

				} else {
					frequencyText.put(token, frequency+1);
				}
			}
			
			for (String s : frequencyText.keySet()) {
				frequencyText.put(s, (frequencyText.get(s) / tam));
			}
		}

		VectorSimilarity vector = new VectorSimilarity();
		vector.setVector(frequencyText);
		return vector;
	}
}
