package br.edu.ifpb.analyzerQuestions.results;

import java.util.List;

import br.edu.ifpb.analyzerQuestions.analyzers.QuestionAnalyzer;
import br.edu.ifpb.analyzerQuestions.analyzers.impl.QuestionAnalyzerImpl;
import br.edu.ifpb.analyzerQuestions.entities.QuestionsDataSet;

/**
 * 
 * @author franck
 *
 */
public class ResultsTable {
	
	private List<QuestionsDataSet> questionsDataSet;
	private QuestionAnalyzer questionAnalyzer;
	
	/**
	 * 
	 * @param questionsDataSet
	 */
	public ResultsTable(List<QuestionsDataSet> questionsDataSet) {
		this.questionsDataSet = questionsDataSet;
		this.questionAnalyzer = new QuestionAnalyzerImpl();
		
	}
	
	public void executeCoherencyBodyAndTitle(){
		int flag = 1;
		int igual = 0;
		int diferente = 0;
		for (QuestionsDataSet qds : questionsDataSet) {
			System.out.println("Questão "+flag+": "+qds.getTitle());
			if(questionAnalyzer.coherencyBodyAndTitle(qds.getTitle(),qds.getBody()) == Integer.parseInt(qds.getCoerencia())){
				//System.out.println("IGUAL (" + questionAnalyzer.coherencyBodyAndTitle(qds.getTitle(),qds.getBody())+"-"+ qds.getCoerencia()+")");
//				System.out.println("-----------------------------------------------------------//");
//				System.out.println(qds.getBody());
//				System.out.println("-----------------------------------------------------------//");
				igual++;
			}else{
				//System.out.println("Questão "+flag+": "+qds.getTitle());
				System.out.println("DIFERENTE (" + questionAnalyzer.coherencyBodyAndTitle(qds.getTitle(),qds.getBody())+"-"+ qds.getCoerencia()+")");
//				System.out.println("-----------------------------------------------------------//");
//				System.out.println(qds.getBody());
//				System.out.println("-----------------------------------------------------------//");
				diferente ++;
			}
			flag ++;
		}
		System.out.println("________________________________________");
		System.out.println("IGUAIS :" + igual);
		System.out.println("DIFERENTES :" + diferente);

	}
	
	public void executeTitleMedio(){
		int flag = 1;
		int igual = 0;
		int diferente = 0;
		for (QuestionsDataSet qds : questionsDataSet) {
			System.out.println("Questão "+flag+": "+qds.getTitle());
			if(questionAnalyzer.mediumSizeTitle(qds.getTitle()) == Integer.parseInt(qds.getTituloMedio())){
				System.out.println("IGUAL (" + questionAnalyzer.mediumSizeTitle(qds.getTitle())+"-"+ qds.getTituloMedio()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + questionAnalyzer.mediumSizeTitle(qds.getTitle())+"-"+ qds.getTituloMedio()+")");
				diferente ++;
			}
			flag ++;
		}
		System.out.println("________________________________________");
		System.out.println("IGUAIS :" + igual);
		System.out.println("DIFERENTES :" + diferente);

	}
	
	public void executeUnderstandableTitle(){
		int flag = 1;
		int igual = 0;
		int diferente = 0;
		for (QuestionsDataSet qds : questionsDataSet) {
			//System.out.println("Questão "+flag+": "+qds.getTitle());
			if(questionAnalyzer.understandableTitle(qds.getTitle(), qds.getBody()) == Integer.parseInt(qds.getTituloBemDefinido())){
				//System.out.println("IGUAL (" + questionAnalyzer.understandableTitle(qds.getTitle(), qds.getBody())+"-"+ qds.getTituloBemDefinido()+")");
				igual++;
			}else{
				System.out.println("Questão "+flag+": "+qds.getTitle());
				System.out.println("DIFERENTE (" + questionAnalyzer.understandableTitle(qds.getTitle(), qds.getBody())+"-"+ qds.getTituloBemDefinido()+")");
				System.out.println("-----------------------------------------------------------//");
				System.out.println(qds.getBody());
				System.out.println("-----------------------------------------------------------//");
				diferente ++;
			}
			flag ++;
		}
		System.out.println("________________________________________");
		System.out.println("IGUAIS :" + igual);
		System.out.println("DIFERENTES :" + diferente);

	}
	
	public void executeTituloCaixaAlta(){
		int flag = 1;
		int igual = 0;
		int diferente = 0;
		for (QuestionsDataSet qds : questionsDataSet) {
			System.out.println("Questão "+flag+": "+qds.getTitle());
			if(questionAnalyzer.titleCapitaLetters(qds.getTitle()) == Integer.parseInt(qds.getTituloCaixaAlta())){
				System.out.println("IGUAL (" + questionAnalyzer.titleCapitaLetters(qds.getTitle())+"-"+ qds.getTituloCaixaAlta()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + questionAnalyzer.titleCapitaLetters(qds.getTitle())+"-"+ qds.getTituloCaixaAlta()+")");
				diferente ++;
			}
			flag ++;
		}
		System.out.println("________________________________________");
		System.out.println("IGUAIS :" + igual);
		System.out.println("DIFERENTES :" + diferente);
		
		

	}
	
	public void executeTitleCapitaLettersPartially(){
		int flag = 1;
		int igual = 0;
		int diferente = 0;
		for (QuestionsDataSet qds : questionsDataSet) {
			System.out.println("Questão "+flag+": "+qds.getTitle()+" "+ " Titulo Médio: -> ");
			if(questionAnalyzer.titleCapitaLettersPartially(qds.getTitle()) == Integer.parseInt(qds.getTituloParCaixaAlta())){
				System.out.println("IGUAL (" + questionAnalyzer.titleCapitaLettersPartially(qds.getTitle())+"-"+ qds.getTituloParCaixaAlta()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + questionAnalyzer.titleCapitaLettersPartially(qds.getTitle())+"-"+ qds.getTituloParCaixaAlta()+")");
				diferente ++;
			}
			flag ++;
		}
		System.out.println("________________________________________");
		System.out.println("IGUAIS :" + igual);
		System.out.println("DIFERENTES :" + diferente);

	}
	
	public void executeIncludingVocative(){
		int flag = 1;
		int igual = 0;
		int diferente = 0;
		for (QuestionsDataSet qds : questionsDataSet) {
			System.out.println("Questão "+flag+": "+qds.getTitle());
			if(questionAnalyzer.includingVocative(qds.getBody()) == Integer.parseInt(qds.getVocativo())){
				System.out.println("IGUAL (" + questionAnalyzer.includingVocative(qds.getBody())+"-"+ qds.getVocativo()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + questionAnalyzer.includingVocative(qds.getBody())+"-"+ qds.getVocativo()+")");
				diferente ++;
			}
			flag ++;
		}
		System.out.println("________________________________________");
		System.out.println("IGUAIS :" + igual);
		System.out.println("DIFERENTES :" + diferente);

	}
	
	public void executeShortDescription(){
		int flag = 1;
		int igual = 0;
		int diferente = 0;
		for (QuestionsDataSet qds : questionsDataSet) {
			//System.out.println("Questão "+flag+": "+qds.getTitle());
			if(questionAnalyzer.shortDescription(qds.getBody()) == Integer.parseInt(qds.getEvDescricaoCurta())){
				//System.out.println("IGUAL (" + questionAnalyzer.shortDescription(qds.getBody())+"-"+ qds.getEvDescricaoCurta()+")");
				igual++;
			}else{
				System.out.println("Questão "+flag+": "+qds.getTitle());
				System.out.println("DIFERENTE (" + questionAnalyzer.shortDescription(qds.getBody())+"-"+ qds.getEvDescricaoCurta()+")");
				diferente ++;
			}
			flag ++;
		}
		System.out.println("________________________________________");
		System.out.println("IGUAIS :" + igual);
		System.out.println("DIFERENTES :" + diferente);

	}
	
	public void executeLongDescription(){
		int flag = 1;
		int igual = 0;
		int diferente = 0;
		for (QuestionsDataSet qds : questionsDataSet) {
			//System.out.println("Questão "+flag+": "+qds.getTitle());
			if(questionAnalyzer.longDescription(qds.getBody()) == Integer.parseInt(qds.getEvDescricaoLonga())){
				//System.out.println("IGUAL (" + questionAnalyzer.longDescription(qds.getBody())+"-"+ qds.getEvDescricaoLonga()+")");
				igual++;
			}else{
				System.out.println("Questão "+flag+": "+qds.getTitle());
				System.out.println("DIFERENTE (" + questionAnalyzer.longDescription(qds.getBody())+"-"+ qds.getEvDescricaoLonga()+")");
				diferente ++;
			}
			flag ++;
		}
		System.out.println("________________________________________");
		System.out.println("IGUAIS :" + igual);
		System.out.println("DIFERENTES :" + diferente);

	}
	
	public void executeShowingExample(){
		int flag = 1;
		int igual = 0;
		int diferente = 0;
		for (QuestionsDataSet qds : questionsDataSet) {
			//System.out.println("Questão "+flag+": "+qds.getTitle());
			if(questionAnalyzer.showingExample(qds.getBody()) == Integer.parseInt(qds.getPresencaCodigo())){
				//System.out.println("IGUAL (" + questionAnalyzer.showingExample(qds.getBody())+"-"+ qds.getPresencaCodigo()+")");
				igual++;
			}else{
				System.out.println("Questão "+flag+": "+qds.getTitle());
				System.out.println("DIFERENTE (" + questionAnalyzer.showingExample(qds.getBody())+"-"+ qds.getPresencaCodigo()+")");
				diferente ++;
			}
			flag ++;
		}
		System.out.println("________________________________________");
		System.out.println("IGUAIS :" + igual);
		System.out.println("DIFERENTES :" + diferente);
	}
	
	public void executeIncludingGreetings(){
		int flag = 1;
		int igual = 0;
		int diferente = 0;
		for (QuestionsDataSet qds : questionsDataSet) {
			System.out.println("Questão "+flag+": "+qds.getTitle());
			if(questionAnalyzer.includingGreetings(qds.getBody()) == Integer.parseInt(qds.getIncluirAgradecimento())){
				System.out.println("IGUAL (" + questionAnalyzer.includingGreetings(qds.getBody())+"-"+ qds.getIncluirAgradecimento()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + questionAnalyzer.includingGreetings(qds.getBody())+"-"+ qds.getIncluirAgradecimento()+")");
				diferente ++;
			}
			flag ++;
		}
		System.out.println("________________________________________");
		System.out.println("IGUAIS :" + igual);
		System.out.println("DIFERENTES :" + diferente);
	}
	
	public void executeQuestionWithSingleProblem(){
		int flag = 1;
		int igual = 0;
		int diferente = 0;
		for (QuestionsDataSet qds : questionsDataSet) {
			//System.out.println("Questão "+flag+": "+qds.getTitle());
			if(questionAnalyzer.questionWithSingleProblem(qds.getBody()) == Integer.parseInt(qds.getPerguntaUnica())){
			//	System.out.println("IGUAL (" + questionAnalyzer.questionWithSingleProblem(qds.getBody())+"-"+ qds.getPerguntaUnica()+")");
				igual++;
			}else{
				System.out.println("Questão "+flag+": "+qds.getTitle());
				System.out.println("DIFERENTE (" + questionAnalyzer.questionWithSingleProblem(qds.getBody())+"-"+ qds.getPerguntaUnica()+")");
				diferente ++;
			}
			flag ++;
		}
		System.out.println("________________________________________");
		System.out.println("IGUAIS :" + igual);
		System.out.println("DIFERENTES :" + diferente);
	}
	
	/**
	 * Mostra resultados para descrição bem definida
	 */
	public void executeUnderstandableDescription(){
		int flag = 1;
		int igual = 0;
		int diferente = 0;
		for (QuestionsDataSet qds : questionsDataSet) {
			//System.out.println("Questão "+flag+": "+qds.getTitle());
			if(questionAnalyzer.understandableDescription(qds.getBody()) == Integer.parseInt(qds.getPerguntaBemDefinda())){
				//System.out.println("IGUAL (" + questionAnalyzer.understandableDescription(qds.getBody())+"-"+ qds.getPerguntaBemDefinda()+")");
				igual++;
			}else{
				System.out.println("Questão "+flag+": "+qds.getTitle());
				System.out.println("DIFERENTE (" + questionAnalyzer.understandableDescription(qds.getBody())+"-"+ qds.getPerguntaBemDefinda()+")");
				diferente ++;
			}
			flag ++;
		}
		System.out.println("________________________________________");
		System.out.println("IGUAIS :" + igual);
		System.out.println("DIFERENTES :" + diferente);
	}
	
	/**
	 * Mostra resultados para evitar descrição com apenas codigo
	 */
	public void executeAvoidDescriptionWithCodeOnly(){
		int flag = 1;
		int igual = 0;
		int diferente = 0;
		for (QuestionsDataSet qds : questionsDataSet) {
			System.out.println("Questão "+flag+": "+qds.getTitle());
			if(questionAnalyzer.avoidDescriptionWithCodeOnly(qds.getBody()) == Integer.parseInt(qds.getEvPergComApenasCod())){
				System.out.println("IGUAL (" + questionAnalyzer.avoidDescriptionWithCodeOnly(qds.getBody())+"-"+ qds.getEvPergComApenasCod()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + questionAnalyzer.avoidDescriptionWithCodeOnly(qds.getBody())+"-"+ qds.getEvPergComApenasCod()+")");
				diferente ++;
			}
			flag ++;
		}
		System.out.println("________________________________________");
		System.out.println("IGUAIS :" + igual);
		System.out.println("DIFERENTES :" + diferente);
	}
	
	public void executeDoNotCreateHomeworkQuestions(){
		int flag = 1;
		int igual = 0;
		int diferente = 0;
		for (QuestionsDataSet qds : questionsDataSet) {
			System.out.println("Questão "+flag+": "+qds.getTitle());
			if(questionAnalyzer.doNotCreateHomeworkQuestions(qds.getBody()) == Integer.parseInt(qds.getEvPergSobreTrabAcademicos())){
				System.out.println("IGUAL (" + questionAnalyzer.doNotCreateHomeworkQuestions(qds.getBody())+"-"+ qds.getEvPergSobreTrabAcademicos()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + questionAnalyzer.doNotCreateHomeworkQuestions(qds.getBody())+"-"+ qds.getEvPergSobreTrabAcademicos()+")");
				diferente ++;
			}
			flag ++;
		}
		System.out.println("________________________________________");
		System.out.println("IGUAIS :" + igual);
		System.out.println("DIFERENTES :" + diferente);
	}
	
	/**
	 * Mostra o resultado sobre a característica de Ser exigente ou mal educado.
	 */
	public void executeObviatingDemandingLanguage() {
		int flag = 1;
		int igual = 0;
		int diferente = 0;
		for (QuestionsDataSet qds : questionsDataSet) {
			System.out.println("Questão "+flag+": "+qds.getTitle());
			if(questionAnalyzer.obviatingDemandingLanguage(qds.getBody()) == Integer.parseInt(qds.getEvSerExigente())){
				System.out.println("IGUAL (" + questionAnalyzer.obviatingDemandingLanguage(qds.getBody())+"-"+ qds.getEvSerExigente()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + questionAnalyzer.obviatingDemandingLanguage(qds.getBody())+"-"+ qds.getEvSerExigente()+")");
				diferente ++;
			}
			flag ++;
		}
		System.out.println("________________________________________");
		System.out.println("IGUAIS :" + igual);
		System.out.println("DIFERENTES :" + diferente);
	}
	/**
	 * 
	 */
	public void executeAvoidingMuchCode(){
		int flag = 1;
		int igual = 0;
		int diferente = 0;
		for (QuestionsDataSet qds : questionsDataSet) {
			System.out.println("Questão "+flag+": "+qds.getTitle());
			if(questionAnalyzer.avoidingMuchCode(qds.getBody()) == Integer.parseInt(qds.getEvTrechoGrandeCodigo())){
				System.out.println("IGUAL (" + questionAnalyzer.avoidingMuchCode(qds.getBody())+"-"+ qds.getEvTrechoGrandeCodigo()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + questionAnalyzer.avoidingMuchCode(qds.getBody())+"-"+ qds.getEvTrechoGrandeCodigo()+")");
				diferente ++;
			}
			flag ++;
		}
		System.out.println("________________________________________");
		System.out.println("IGUAIS :" + igual);
		System.out.println("DIFERENTES :" + diferente);
	}
	
	/**
	 * 
	 */
	public void executeUsingProperLanguage(){
		int flag = 1;
		int igual = 0;
		int diferente = 0;
		for (QuestionsDataSet qds : questionsDataSet) {
			System.out.println("Questão "+flag+": "+qds.getTitle());
			if(questionAnalyzer.usingProperLanguage(qds.getBody()) == Integer.parseInt(qds.getUsoNormaCultaLing())){
				System.out.println("IGUAL (" + questionAnalyzer.usingProperLanguage(qds.getBody())+"-"+ qds.getUsoNormaCultaLing()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + questionAnalyzer.usingProperLanguage(qds.getBody())+"-"+ qds.getUsoNormaCultaLing()+")");
				diferente ++;
			}
			flag ++;
		}
		System.out.println("________________________________________");
		System.out.println("IGUAIS :" + igual);
		System.out.println("DIFERENTES :" + diferente);
	}
	
	public void executeAvoidingCreatingFactoidQuestions(){
		int flag = 1;
		int igual = 0;
		int diferente = 0;
		for (QuestionsDataSet qds : questionsDataSet) {
			System.out.println("Questão "+flag+": "+qds.getTitle());
			if(questionAnalyzer.avoidingCreatingFactoidQuestions(qds.getBody()) == Integer.parseInt(qds.getEvPergFactoides())){
				System.out.println("IGUAL (" + questionAnalyzer.avoidingCreatingFactoidQuestions(qds.getBody())+"-"+ qds.getEvPergFactoides()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + questionAnalyzer.avoidingCreatingFactoidQuestions(qds.getBody())+"-"+ qds.getEvPergFactoides()+")");
				diferente ++;
			}
			flag ++;
		}
		System.out.println("________________________________________");
		System.out.println("IGUAIS :" + igual);
		System.out.println("DIFERENTES :" + diferente);
	}
	

}
