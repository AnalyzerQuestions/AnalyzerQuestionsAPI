package br.edu.ifpb.analyzerQuestions.results;

import java.util.List;

import br.edu.ifpb.analyzerQuestions.analyzers.DescriptionAnalyzer;
import br.edu.ifpb.analyzerQuestions.analyzers.QuestionsAnalyzer;
import br.edu.ifpb.analyzerQuestions.analyzers.TitleAnalyzer;
import br.edu.ifpb.analyzerQuestions.entities.Question;
import br.edu.ifpb.analyzerQuestions.entities.QuestionsDataSet;

/**
 * 
 * @author franck
 *
 */
public class ResultsTable {
	
	private DescriptionAnalyzer descriptionAnalyzer;
	private TitleAnalyzer titleAnalyzer;
	private QuestionsAnalyzer questionAnalyzer;
	private List<QuestionsDataSet> questionsDataSet;
	
	/**
	 * 
	 * @param questionsDataSet
	 */
	public ResultsTable(List<QuestionsDataSet> questionsDataSet) {
		this.questionsDataSet = questionsDataSet;
		this.descriptionAnalyzer = new DescriptionAnalyzer();
		this.titleAnalyzer = new TitleAnalyzer();
		this.questionAnalyzer = new QuestionsAnalyzer();
		
	}
	
	public void executeCoherencyBodyAndTitle(){
		int flag = 1;
		int igual = 0;
		int diferente = 0;
		for (QuestionsDataSet qds : questionsDataSet) {
			System.out.println("Questão "+flag+": "+qds.getTitle());
			Question q = new Question(qds.getTitle(), qds.getBody());
			if(questionAnalyzer.coherencyBodyAndTitle(q) == Integer.parseInt(qds.getCoerencia())){
				System.out.println("IGUAL (" + questionAnalyzer.coherencyBodyAndTitle(q)+"-"+ qds.getCoerencia()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + questionAnalyzer.coherencyBodyAndTitle(q)+"-"+ qds.getCoerencia()+")");
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
			System.out.print("Questão "+flag+": "+qds.getTitle());
			if(titleAnalyzer.mediumSizeTitle(qds.getTitle()) == Integer.parseInt(qds.getTituloMedio())){
				System.out.println("IGUAL (" + titleAnalyzer.mediumSizeTitle(qds.getTitle())+"-"+ qds.getTituloMedio()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + titleAnalyzer.mediumSizeTitle(qds.getTitle())+"-"+ qds.getTituloMedio()+")");
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
			System.out.print("Questão "+flag+": "+qds.getTitle());
			if(titleAnalyzer.understandableTitle(qds.getTitle()) == Integer.parseInt(qds.getTituloBemDefinido())){
				System.out.println("IGUAL (" + titleAnalyzer.understandableTitle(qds.getTitle())+"-"+ qds.getTituloBemDefinido()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + titleAnalyzer.understandableTitle(qds.getTitle())+"-"+ qds.getTituloBemDefinido()+")");
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
			System.out.print("Questão "+flag+": "+qds.getTitle());
			if(titleAnalyzer.titleCapitaLetters(qds.getTitle()) == Integer.parseInt(qds.getTituloCaixaAlta())){
				System.out.println("IGUAL (" + titleAnalyzer.titleCapitaLetters(qds.getTitle())+"-"+ qds.getTituloCaixaAlta()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + titleAnalyzer.titleCapitaLetters(qds.getTitle())+"-"+ qds.getTituloCaixaAlta()+")");
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
			System.out.print("Questão "+flag+": "+qds.getTitle()+" "+ " Titulo Médio: -> ");
			if(titleAnalyzer.titleCapitaLettersPartially(qds.getTitle()) == Integer.parseInt(qds.getTituloParCaixaAlta())){
				System.out.println("IGUAL (" + titleAnalyzer.titleCapitaLettersPartially(qds.getTitle())+"-"+ qds.getTituloParCaixaAlta()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + titleAnalyzer.titleCapitaLettersPartially(qds.getTitle())+"-"+ qds.getTituloParCaixaAlta()+")");
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
			if(descriptionAnalyzer.includingVocative(qds.getBody()) == Integer.parseInt(qds.getVocativo())){
				System.out.println("IGUAL (" + descriptionAnalyzer.includingVocative(qds.getBody())+"-"+ qds.getVocativo()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + descriptionAnalyzer.includingVocative(qds.getBody())+"-"+ qds.getVocativo()+")");
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
			System.out.println("Questão "+flag+": "+qds.getTitle());
			if(descriptionAnalyzer.shortDescription(qds.getBody()) == Integer.parseInt(qds.getEvDescricaoCurta())){
				System.out.println("IGUAL (" + descriptionAnalyzer.shortDescription(qds.getBody())+"-"+ qds.getEvDescricaoCurta()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + descriptionAnalyzer.shortDescription(qds.getBody())+"-"+ qds.getEvDescricaoCurta()+")");
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
			System.out.println("Questão "+flag+": "+qds.getTitle());
			if(descriptionAnalyzer.longDescription(qds.getBody()) == Integer.parseInt(qds.getEvDescricaoLonga())){
				System.out.println("IGUAL (" + descriptionAnalyzer.longDescription(qds.getBody())+"-"+ qds.getEvDescricaoLonga()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + descriptionAnalyzer.longDescription(qds.getBody())+"-"+ qds.getEvDescricaoLonga()+")");
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
			System.out.println("Questão "+flag+": "+qds.getTitle());
			if(descriptionAnalyzer.showingExample(qds.getBody()) == Integer.parseInt(qds.getPresencaCodigo())){
				System.out.println("IGUAL (" + descriptionAnalyzer.showingExample(qds.getBody())+"-"+ qds.getPresencaCodigo()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + descriptionAnalyzer.showingExample(qds.getBody())+"-"+ qds.getPresencaCodigo()+")");
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
			if(descriptionAnalyzer.includingGreetings(qds.getBody()) == Integer.parseInt(qds.getIncluirAgradecimento())){
				System.out.println("IGUAL (" + descriptionAnalyzer.includingGreetings(qds.getBody())+"-"+ qds.getIncluirAgradecimento()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + descriptionAnalyzer.includingGreetings(qds.getBody())+"-"+ qds.getIncluirAgradecimento()+")");
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
			System.out.println("Questão "+flag+": "+qds.getTitle());
			if(descriptionAnalyzer.questionWithSingleProblem(qds.getBody()) == Integer.parseInt(qds.getPerguntaUnica())){
				System.out.println("IGUAL (" + descriptionAnalyzer.questionWithSingleProblem(qds.getBody())+"-"+ qds.getPerguntaUnica()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + descriptionAnalyzer.questionWithSingleProblem(qds.getBody())+"-"+ qds.getPerguntaUnica()+")");
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
			System.out.println("Questão "+flag+": "+qds.getTitle());
			if(descriptionAnalyzer.understandableDescription(qds.getBody()) == Integer.parseInt(qds.getPerguntaBemDefinda())){
				System.out.println("IGUAL (" + descriptionAnalyzer.understandableDescription(qds.getBody())+"-"+ qds.getPerguntaBemDefinda()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + descriptionAnalyzer.understandableDescription(qds.getBody())+"-"+ qds.getPerguntaBemDefinda()+")");
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
			if(descriptionAnalyzer.avoidDescriptionWithCodeOnly(qds.getBody()) == Integer.parseInt(qds.getEvPergComApenasCod())){
				System.out.println("IGUAL (" + descriptionAnalyzer.avoidDescriptionWithCodeOnly(qds.getBody())+"-"+ qds.getEvPergComApenasCod()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + descriptionAnalyzer.avoidDescriptionWithCodeOnly(qds.getBody())+"-"+ qds.getEvPergComApenasCod()+")");
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
			if(descriptionAnalyzer.doNotCreateHomeworkQuestions(qds.getBody()) == Integer.parseInt(qds.getEvPergSobreTrabAcademicos())){
				System.out.println("IGUAL (" + descriptionAnalyzer.doNotCreateHomeworkQuestions(qds.getBody())+"-"+ qds.getEvPergSobreTrabAcademicos()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + descriptionAnalyzer.doNotCreateHomeworkQuestions(qds.getBody())+"-"+ qds.getEvPergSobreTrabAcademicos()+")");
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
			if(descriptionAnalyzer.obviatingDemandingLanguage(qds.getBody()) == Integer.parseInt(qds.getEvSerExigente())){
				System.out.println("IGUAL (" + descriptionAnalyzer.obviatingDemandingLanguage(qds.getBody())+"-"+ qds.getEvSerExigente()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + descriptionAnalyzer.obviatingDemandingLanguage(qds.getBody())+"-"+ qds.getEvSerExigente()+")");
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
			if(descriptionAnalyzer.avoidingMuchCode(qds.getBody()) == Integer.parseInt(qds.getEvTrechoGrandeCodigo())){
				System.out.println("IGUAL (" + descriptionAnalyzer.avoidingMuchCode(qds.getBody())+"-"+ qds.getEvTrechoGrandeCodigo()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + descriptionAnalyzer.avoidingMuchCode(qds.getBody())+"-"+ qds.getEvTrechoGrandeCodigo()+")");
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
			if(descriptionAnalyzer.usingProperLanguage(qds.getBody()) == Integer.parseInt(qds.getUsoNormaCultaLing())){
				System.out.println("IGUAL (" + descriptionAnalyzer.usingProperLanguage(qds.getBody())+"-"+ qds.getUsoNormaCultaLing()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + descriptionAnalyzer.usingProperLanguage(qds.getBody())+"-"+ qds.getUsoNormaCultaLing()+")");
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
			if(descriptionAnalyzer.avoidingCreatingFactoidQuestions(qds.getBody()) == Integer.parseInt(qds.getEvPergFactoides())){
				System.out.println("IGUAL (" + descriptionAnalyzer.avoidingCreatingFactoidQuestions(qds.getBody())+"-"+ qds.getEvPergFactoides()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + descriptionAnalyzer.avoidingCreatingFactoidQuestions(qds.getBody())+"-"+ qds.getEvPergFactoides()+")");
				diferente ++;
			}
			flag ++;
		}
		System.out.println("________________________________________");
		System.out.println("IGUAIS :" + igual);
		System.out.println("DIFERENTES :" + diferente);
	}
	

}
