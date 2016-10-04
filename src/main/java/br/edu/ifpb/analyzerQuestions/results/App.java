package br.edu.ifpb.analyzerQuestions.results;

import java.util.List;

import br.edu.ifpb.analyzerQuestions.entities.QuestionsDataSetPojo;
import br.edu.ifpb.analyzerQuestions.util.data.ReaderQuestions;

/**
 * 
 * @author franck
 *
 */
public class App {
	
	
	public static void main(String[] args) {
		
		ReaderQuestions readerQuestions = new ReaderQuestions("datasetFinalNR2.csv");
		List<QuestionsDataSetPojo> listQuestionsDS = readerQuestions.readCsvFile();

/*		ReaderQuestions readerQuestions2 = new ReaderQuestions("datasetSR.csv");
		List<QuestionsDataSet> q2 = readerQuestions2.readCsvFile();

		for (QuestionsDataSet questionsDataSet : q2) {
			q.add(questionsDataSet);
		}*/

		ResultsDataSetDetail resultsTable = new ResultsDataSetDetail(listQuestionsDS);
		
		
		//resultsTable.detailAnalyzerCoherencyBodyAndTitle();
		resultsTable.detailAnalyzerUnderstandableTitle();
		//resultsTable.detailAnalyzerShowExample();
		//resultsTable.detailAnalyzerUsingProperLanguage();
		//resultsTable.detailAnalyzerBeEducated();
		//resultsTable.detailAnalyzerDetailAboutContext();
		//resultsTable.detailAnalyzerAnalyzerShortDescriptionQuestion();
		//resultsTable.detailAnalyzerObjective();
		//resultsTable.detailAnalyzerClarity();
		//resultsTable.detailAnalyzerUnderstandableDescription();
		//resultsTable.detailAnalyzerAnalyzerDoNotCreateHomeworkQuestions();
		
		//resultsTable.detailAnalyzerAvoidCreateDuplicateQuestion(comment);;


		
	}
}
