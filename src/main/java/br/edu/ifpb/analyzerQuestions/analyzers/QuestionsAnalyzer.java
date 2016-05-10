package br.edu.ifpb.analyzerQuestions.analyzers;

import br.edu.ifpb.analyzerQuestions.entities.Question;
import br.edu.ifpb.analyzerQuestions.util.similarity.ScoreSimilarity;

/**
 * 
 * @author franck
 *
 */
public class QuestionsAnalyzer {

	private static final Float VALUE_SIMILARITY = 0.0f;
	
	/**
	 * 
	 */
	public QuestionsAnalyzer() {
	}
	
	/**
	 * Coerência do titulo com a descrição da pergunta
	 */
	public int coherencyBodyAndTitle(Question question) {
		
		ScoreSimilarity scoreSimilarity= new ScoreSimilarity();
		
		Double similarity = scoreSimilarity.getSimilarity(question.getTitle(), question.getBody());
		System.out.println(similarity);
		if(similarity > VALUE_SIMILARITY){
			return 1;
		}
		return 0;
	}
}
