package br.edu.ifpb.analyzerQuestions.analyzers.flag;

import br.edu.ifpb.analyzerQuestions.util.similarity.ScoreSimilarity;

/**
 * 
 * @author franck
 *
 */
public class QuestionsAnalyzer {

	private static final Float VALUE_SIMILARITY = 0.05f;
	
	/**
	 * 
	 */
	public QuestionsAnalyzer() {
	}
	
	/**
	 * Coerência do titulo com a descrição da pergunta
	 */
	public int coherencyBodyAndTitle(String title, String descrption) {
		
		ScoreSimilarity scoreSimilarity= new ScoreSimilarity();
		
		Double similarity = scoreSimilarity.getSimilarity(title, descrption);
		if(similarity > VALUE_SIMILARITY){
			return 1;
		}
		return 0;
	}
}
