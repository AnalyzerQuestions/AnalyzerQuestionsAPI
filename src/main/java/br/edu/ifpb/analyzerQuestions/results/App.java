package br.edu.ifpb.analyzerQuestions.results;

import java.util.List;

import br.edu.ifpb.analyzerQuestions.entities.QuestionsDataSet;
import br.edu.ifpb.analyzerQuestions.enumerations.Site;
import br.edu.ifpb.analyzerQuestions.stackExchangeAPI.IStackExchange;
import br.edu.ifpb.analyzerQuestions.stackExchangeAPI.QuestionsList;
import br.edu.ifpb.analyzerQuestions.stackExchangeAPI.StackExchangeAPI;
import br.edu.ifpb.analyzerQuestions.util.data.ReaderQuestions;

/**
 * 
 * @author franck
 *
 */
public class App {

	public static void main(String[] args) {

		/**
		 * API StackExchange
		 */
//		StackExchangeAPI api = new StackExchangeAPI("Od0ApalxujcmxgiTJ566gA((", "CEWWD9gissG5heqD0UCc1w))");
////
//		IStackExchange siteService = api.getSiteService(Site.STACK_OVERFLOW.getSite());
////		
//		QuestionsList questions = siteService.getQuestions();
		
//		String s = new Gson().toJson(siteService.getQuestions());
//		
//		Type collectionType = new TypeToken<Collection<QuestionsList>>(){}.getType();
//		QuestionsList q = new Gson().fromJson(s, collectionType);
		
		/**
		 * RESULTS TABELAS DE QUESTÕES
		 */
		ReaderQuestions readerQuestions = new ReaderQuestions("datasetR.csv");
		List<QuestionsDataSet> q = readerQuestions.readCsvFile();
		ResultsTable resultsTable = new ResultsTable(q);
		
		resultsTable.executeCoherencyBodyAndTitle();
		
		//resultsTable.executeTitleMedio();
		//resultsTable.executeTituloCaixaAlta();
		//resultsTable.executeTitleCapitaLettersPartially();
		
		//resultsTable.executeIncludingVocative();
		//resultsTable.executeShortDescription();
		//resultsTable.executeLongDescription();
		//resultsTable.executeShowingExample();
		//resultsTable.executeIncludingGreetings();
		
		//resultsTable.executeQuestionWithSingleProblem();
		
		
	}
}
