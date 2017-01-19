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

	public void detailAnalyzerClarity(){
		
		int questionNumber = 1;
		int equal = 0;
		int different = 0;
		int truePos = 0;
		int trueNeg = 0;
		
		for (QuestionsDataSetPojo qds : questionsDataSet) {
			System.out.println("Pergunta "+questionNumber+": "+qds.getTitle());

			int resultMethod = questionAnalyzer.analyzerClarity(qds.getTitle(), qds.getBody());
			int resultDataset = Integer.parseInt(qds.getClareza());
			
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

	public void detailAnalyzerUnderstandableDescription(){
		
		int questionNumber = 1;
		int equal = 0;
		int different = 0;
		int truePos = 0;
		int trueNeg = 0;
		
		for (QuestionsDataSetPojo qds : questionsDataSet) {
			System.out.println("Pergunta "+questionNumber+": "+qds.getTitle());

			int resultMethod = questionAnalyzer.analyzerUnderstandableDescription(qds.getTitle(), qds.getBody());
			int resultDataset = Integer.parseInt(qds.getPergBemDefinida());
			
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
	
	public void detailAnalyzerDetailAboutContext(){
		
		int questionNumber = 1;
		int equal = 0;
		int different = 0;
		int truePos = 0;
		int trueNeg = 0;
		
		for (QuestionsDataSetPojo qds : questionsDataSet) {
			System.out.println("Pergunta "+questionNumber+": "+qds.getTitle());

			int resultMethod = questionAnalyzer.analyzerDetailAboutContext(qds.getBody());
			int resultDataset = Integer.parseInt(qds.getDetailContexto());
			
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

	public void detailAnalyzerBeEducated(){
		
		int questionNumber = 1;
		int equal = 0;
		int different = 0;
		int truePos = 0;
		int trueNeg = 0;
		
		for (QuestionsDataSetPojo qds : questionsDataSet) {
			System.out.println("Pergunta "+questionNumber+": "+qds.getTitle());

			int resultMethod = questionAnalyzer.analyzerBeEducated(qds.getBody());
			int resultDataset = Integer.parseInt(qds.getEducacao());
			
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

	public void detailAnalyzerCoherencyBodyAndTitle(){
		
		int questionNumber = 1;
		int equal = 0;
		int different = 0;
		int truePos = 0;
		int trueNeg = 0;
		
		for (QuestionsDataSetPojo qds : questionsDataSet) {
			System.out.println("Pergunta "+questionNumber+": "+qds.getTitle());

			int resultMethod = questionAnalyzer.analyzerCoherencyBodyAndTitle(qds.getTitle(), qds.getBody());
			int resultDataset = Integer.parseInt(qds.getCoerenciaTeD());
			
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
	
	public void detailAnalyzerUsingProperLanguage(){
			
			int questionNumber = 1;
			int equal = 0;
			int different = 0;
			int truePos = 0;
			int trueNeg = 0;
			
			for (QuestionsDataSetPojo qds : questionsDataSet) {
				System.out.println("Pergunta "+questionNumber+": "+qds.getTitle());
	
				int resultMethod = questionAnalyzer.analyzerUsingProperLanguage(qds.getBody());
				int resultDataset = Integer.parseInt(qds.getUsoNormaCultaLingua());
				
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
	
	public void detailAnalyzerUnderstandableTitle(){
		
		int questionNumber = 1;
		int equal = 0;
		int different = 0;
		int truePos = 0;
		int trueNeg = 0;
		
		for (QuestionsDataSetPojo qds : questionsDataSet) {
			System.out.println("Pergunta "+questionNumber+": "+qds.getTitle());

			int resultMethod = questionAnalyzer.analyzerUnderstandableTitle(qds.getTitle(), qds.getBody());
			int resultDataset = Integer.parseInt(qds.getTituloBemDefinido());
			
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

	public void detailAnalyzerAnalyzerShortDescriptionQuestion(){
			
			int questionNumber = 1;
			int equal = 0;
			int different = 0;
			int truePos = 0;
			int trueNeg = 0;
			
			for (QuestionsDataSetPojo qds : questionsDataSet) {
				System.out.println("Pergunta "+questionNumber+": "+qds.getTitle());
	
				int resultMethod = questionAnalyzer.analyzerShortDescriptionQuestion(qds.getBody());
				int resultDataset = Integer.parseInt(qds.getDescricaoCurta());
				
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

	public void detailAnalyzerAnalyzerDoNotCreateHomeworkQuestions(){
			
			int questionNumber = 1;
			int equal = 0;
			int different = 0;
			int truePos = 0;
			int trueNeg = 0;
			
			for (QuestionsDataSetPojo qds : questionsDataSet) {
				System.out.println("Pergunta "+questionNumber+": "+qds.getTitle());
	
				int resultMethod = questionAnalyzer.analyzerDoNotCreateHomeworkQuestions(qds.getBody());
				int resultDataset = Integer.parseInt(qds.getEvPergSobreTrabAcademicos());
				
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
