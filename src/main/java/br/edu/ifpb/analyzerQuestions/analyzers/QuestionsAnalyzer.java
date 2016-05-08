package br.edu.ifpb.analyzerQuestions.analyzers;

import br.edu.ifpb.analyzerQuestions.entities.Question;
import br.edu.ifpb.analyzerQuestions.util.similarity.ScoreSimilarity;

public class QuestionsAnalyzer {

	/**
	 * Coerência do titulo com a descrição da pergunta
	 */
	public int coherencyBodyAndTitle(Question question) {

		ScoreSimilarity scoreSimilarity= new ScoreSimilarity();
		
		Double similarity = scoreSimilarity.getSimilarity(question.getTitle(), question.getBody());
		if(similarity > 0.0){
			return 1;
		}
		return 0;

	}

}
