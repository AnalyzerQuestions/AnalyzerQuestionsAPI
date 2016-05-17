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
	
	

}
