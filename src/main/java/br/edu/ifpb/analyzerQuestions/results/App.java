package br.edu.ifpb.analyzerQuestions.results;

import java.util.List;

import br.edu.ifpb.analyzerQuestions.entities.QuestionsDataSet;
import br.edu.ifpb.analyzerQuestions.util.data.ReaderQuestions;
import br.edu.ifpb.analyzerQuestions.util.similarity.ScoreSimilarity;

/**
 * 
 * @author franck
 *
 */
public class App {
	
	public static void coherencyBodyAndTitle(String title, String descrption) {
		ScoreSimilarity scoreSimilarity = new ScoreSimilarity();

		Double similarity = scoreSimilarity.getSimilarity(title, descrption);
		//System.out.println(similarity);
		if (similarity > 0.05f) {
			System.out.println("SIM");
		}else{
			System.out.println("NÃO");

		}
	}

	public static void main(String[] args) {
		
		/**
		 * API StackExchange
		 */
/*		 StackExchangeAPI api = new
		 StackExchangeAPI("Od0ApalxujcmxgiTJ566gA((",
		 "CEWWD9gissG5heqD0UCc1w))");
		
		 IStackExchange siteService =
		 api.getSiteService(Site.STACK_OVERFLOW.getSite());
		
		 QuestionsList questions = siteService.getQuestions();*/

/*		 String s = new Gson().toJson(siteService.getQuestions());
		
		 Type collectionType = new
		 TypeToken<Collection<QuestionsList>>(){}.getType();
		 QuestionsList q = new Gson().fromJson(s, collectionType);*/

		/**
		 * RESULTS TABELAS DE QUESTÕES
		 */
		ReaderQuestions readerQuestions = new ReaderQuestions("datasetFN.csv");
		List<QuestionsDataSet> q = readerQuestions.readCsvFile();

/*		ReaderQuestions readerQuestions2 = new ReaderQuestions("datasetSR.csv");
		List<QuestionsDataSet> q2 = readerQuestions2.readCsvFile();

		for (QuestionsDataSet questionsDataSet : q2) {
			q.add(questionsDataSet);
		}*/

		ResultsTable resultsTable = new ResultsTable(q);
		
		
/*		for (QuestionsDataSet questionsDataSet : q) {
			App.coherencyBodyAndTitle(questionsDataSet.getTitle(), questionsDataSet.getBody());
		}*/

		
		
		
	//	resultsTable.executeCoherencyBodyAndTitle();

		//resultsTable.executeUnderstandableTitle();
		//resultsTable.executeTitleMedio();
		//resultsTable.executeTituloCaixaAlta();
		//resultsTable.executeTitleCapita///LettersPartially();

		//resultsTable.executeUnderstandableDescription();
		//resultsTable.executeIncludingVocative();
		//resultsTable.executeShortDescription();
		resultsTable.executeLongDescription();
//	resultsTable.executeShowingExample();
		 //resultsTable.executeIncludingGreetings();

	//resultsTable.executeQuestionWithSingleProblem();
		//resultsTable.executeAvoidDescriptionWithCodeOnly();
	//	resultsTable.executeDoNotCreateHomeworkQuestions();

		//resultsTable.executeObviatingDemandingLanguage();
		// resultsTable.executeAvoidingMuchCode();
		//resultsTable.executeUsingProperLanguage();
		//resultsTable.executeAvoidingCreatingFactoidQuestions();
		
/*		DescriptionAnalyzer descriptionAnalyzer = new DescriptionAnalyzer();
		int i =descriptionAnalyzer.avoidingCreatingFactoidQuestions("Onde fica a configuração do jpa no projeto maven?");
		System.out.println(i);*/
		
		
	}
}
