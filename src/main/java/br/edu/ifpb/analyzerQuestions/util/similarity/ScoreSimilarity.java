package br.edu.ifpb.analyzerQuestions.util.similarity;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/***
 * SCORE USANDO CALCULO DO ANGULO DO COSSENO, CONSIDERANDO [1.0 ~= score >= 0.0]
 * SENDO SCORE =~ 1.0 MELHOR SIMILARIDADE
 *
 */

public class ScoreSimilarity {

	private Map<String, Float> vector1;
	private Map<String, Float> vector2;

	/**
	 * CALCULA SIMILARIDADE DE COSSENO COM SEGUINTE EQUACAO v1*v2 / |v1²| * |v2²|
	 * 
	 * Disconsidera-se vetores que não possuam frequencia de tokens <= 1
	 */
	
	public Double getScoreSimilarity(VectorSimilarity v1, VectorSimilarity v2) {

		this.vector1 = v1.getVector();
		this.vector2 = v2.getVector();
		double Wn = 0.0, w1 = 0.0, w2 = 0.0, result = 0.0;

		Set<String> both = new HashSet(vector1.keySet());
		both.retainAll(vector2.keySet());

		for (String token : both) {
			Wn += vector1.get(token) * vector2.get(token);
		}
		
		for (String token : vector1.keySet()) {
			w1 += Math.pow(vector1.get(token), 2);
		}

		for (String token : vector2.keySet()) {
			w2 += Math.pow(vector2.get(token), 2);
		}

		double Wd = Math.sqrt(w1) * Math.sqrt(w2);

		if (Wn == result || Wd == result) {
			return result;
		}
		
		result = Wn / Wd;
		return 1.0 - result;
	}

	/**
	 * Obtém a similaridade de uma questão
	 * 
	 * @param title
	 *            - titulo da questão
	 * @param description
	 *            - descrição da questão
	 * @return - indice de similaridade
	 */
	public Double getSimilarity(String title, String description) {

		VectorSimilarity vectorTitle = CounterFrequencyText.getFrequency(title);
		VectorSimilarity vectorDescription = CounterFrequencyText.getFrequency(description);

		return this.getScoreSimilarity(vectorTitle, vectorDescription);
	}
}
