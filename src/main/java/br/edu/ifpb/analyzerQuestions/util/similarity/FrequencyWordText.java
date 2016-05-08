package br.edu.ifpb.analyzerQuestions.util.similarity;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifpb.analyzerQuestions.util.LuceneUtil;
import br.edu.ifpb.analyzerQuestions.util.StringFormatUtil;
import br.edu.ifpb.analyzerQuestions.util.StringUtils;

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

		String s0 = StringUtils.removerNaoLetras(text);
		String s1 = StringUtils.removerAcentos(s0);
		String s2 = StringFormatUtil.removeConnective(s1);
		
		StringBuffer sb = new StringBuffer(s2);

		String aux = LuceneUtil.tokenizeString(sb).toString();
		textTokens = aux.split(" ");

		float flag = (float) textTokens.length;
		System.out.println(flag);
		if (textTokens.length != 0) {
			for (int i = 0; i < textTokens.length; i++) {
				
				String token = textTokens[i];
				Float frequency = frequencyText.get(token);

				if (frequency == null) {
					frequencyText.put(token, 1F);
					
				} else {
					frequencyText.put(token, frequency + 1F);
				}
			}
			HashMap<String, Float> mapAux = new HashMap<String, Float>();
			for (String s: frequencyText.keySet()){
				if (frequencyText.get(s)!=1){
					mapAux.put(s, frequencyText.get(s));
				}else
					flag--;
			}
			frequencyText = mapAux;
		}
		for (String s: frequencyText.keySet()){
			frequencyText.put(s, (frequencyText.get(s)/flag));
		}
		
		Vector vector = new Vector();
		vector.setVector(frequencyText);
		return vector;
	}
	
	
	

}
