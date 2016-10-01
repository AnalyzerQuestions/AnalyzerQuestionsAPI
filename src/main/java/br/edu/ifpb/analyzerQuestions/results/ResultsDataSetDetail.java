package br.edu.ifpb.analyzerQuestions.results;

import java.util.List;

import br.edu.ifpb.analyzerQuestions.analyzers.finaL.QuestionAnalyzerFinal;
import br.edu.ifpb.analyzerQuestions.entities.QuestionsDataSetPojo;

/**
 * 
 * @author franck
 *
 */
public class ResultsDataSetDetail {
	
	private List<QuestionsDataSetPojo> questionsDataSet;
	private QuestionAnalyzerFinal questionAnalyzer;
	
	public ResultsDataSetDetail(List<QuestionsDataSetPojo> questionsDataSet) {
		this.questionsDataSet = questionsDataSet;
		this.questionAnalyzer = new QuestionAnalyzerFinal();
		
	}
	
	public void detailAnalyzerShowExample(){
		
		int questionNumber = 1;
		int equal = 0;
		int different = 0;
		int truePos = 0;
		int trueNeg = 0;
		
		for (QuestionsDataSetPojo qds : questionsDataSet) {
			System.out.println("Pergunta "+questionNumber+": "+qds.getTitle());

			int resultMethod = questionAnalyzer.analyzerShowExample(qds.getBody());
			int resultDataset = Integer.parseInt(qds.getExemplo());
			
			if(resultMethod == resultDataset){
				System.out.println("IGUAL (" + resultMethod +"-"+resultDataset+")");
				equal++;
				
				if(resultMethod == 1){
					truePos++;
				}else{
					trueNeg++;
				}
				
			}else{
				System.out.println("DIFERENTE (" + resultMethod +"-"+resultDataset + ")");
				different ++;
			}
			questionNumber ++;
		}
		this.output(equal, different, truePos, trueNeg);
	}

	public void detailAnalyzerObjective(){
		
		int questionNumber = 1;
		int equal = 0;
		int different = 0;
		int truePos = 0;
		int trueNeg = 0;
		
		for (QuestionsDataSetPojo qds : questionsDataSet) {
			System.out.println("Pergunta "+questionNumber+": "+qds.getTitle());

			int resultMethod = questionAnalyzer.analyzerObjective(qds.getBody());
			int resultDataset = Integer.parseInt(qds.getObjetividade());
			
			if(resultMethod == resultDataset){
				System.out.println("IGUAL (" + resultMethod +"-"+resultDataset+")");
				equal++;
				
				if(resultMethod == 1){
					truePos++;
				}else{
					trueNeg++;
				}
				
			}else{
				System.out.println("DIFERENTE (" + resultMethod +"-"+resultDataset + ")");
				different ++;
			}
			questionNumber ++;
		}
		this.output(equal, different, truePos, trueNeg);
	}
	
	private void output(int equal, int different, int truePos, int trueNeg){
		System.out.println("____________________________");
		System.out.println("IGUAIS: " + equal);
		System.out.println("DIFERENTES: " + different);
		System.out.println("VERDADEIROS POSITIVOS: " + truePos);
		System.out.println("VERDADEIROS NEGATIVOS: "+ trueNeg);
	}

}
