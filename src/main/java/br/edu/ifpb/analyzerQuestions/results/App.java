package br.edu.ifpb.analyzerQuestions.results;

import java.util.List;

import br.edu.ifpb.analyzerQuestions.analyzers.QuestionAnalyzer;
import br.edu.ifpb.analyzerQuestions.analyzers.impl.QuestionAnalyzerImpl;
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
		ReaderQuestions readerQuestions = new ReaderQuestions("datasetR.csv");
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

		
		
		
	//resultsTable.executeCoherencyBodyAndTitle();

		//resultsTable.executeUnderstandableTitle();
		//resultsTable.executeTitleMedio();
		//resultsTable.executeTituloCaixaAlta();
		//resultsTable.executeTitleCapita///LettersPartially();

	//resultsTable.executeUnderstandableDescription();
		//resultsTable.executeIncludingVocative();
		//resultsTable.executeShortDescription();
		//resultsTable.executeLongDescription();
	//resultsTable.executeShowingExample();
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
		
		String log = "FATAL: /pages/instituicao.xhtml @30,84 actionListener=#{instituicaoBean.verPDF}: net.sf.jasperreports.engine.JRException: Error retrieving field value from bean: nome.javax.faces.FacesException: /pages/instituicao.xhtml @30,84 actionListener=#{instituicaoBean.verPDF}: net.sf.jasperreports.engine.JRException: Error retrieving field value from bean: nome. at com.sun.faces.lifecycle.InvokeApplicationPhase.execute(InvokeApplicationPhase.java:89)  at com.sun.faces.lifecycle.Phase.doPhase(Phase.java:101)"
   +"at com.sun.faces.lifecycle.LifecycleImpl.execute(LifecycleImpl.java:198)"
    +"at javax.faces.webapp.FacesServlet.service(FacesServlet.java:658)"
   +"at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:292)"
   +"at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207)"
    +"at org.primefaces.webapp.filter.FileUploadFilter.doFilter(FileUploadFilter.java:78)"
    +"at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240)"
  + " at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207)"
   + "at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)"
   + "at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240)"
  + "at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207)"
   + "at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:212)"
   +" at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:106)"
 +  " at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:502)"
 +  " at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:141)"
 +  " at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:79)"
   +" at org.apache.catalina.valves.AbstractAccessLogValve.invoke(AbstractAccessLogValve.java:616)"
   +" at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:88)"
    
   +" at java.lang.Thread.run(Unknown Source)"
+"Caused by: javax.el.ELException: /pages/instituicao.xhtml @30,84 actionListener=#{instituicaoBean.verPDF}: "
+ "net.sf.jasperreports.engine.JRException: Error retrieving field value from bean: nome.";
   
		
		QuestionAnalyzer analyzer = new QuestionAnalyzerImpl();
		System.out.println(analyzer.containsLog(log));
		
		
	}
}
