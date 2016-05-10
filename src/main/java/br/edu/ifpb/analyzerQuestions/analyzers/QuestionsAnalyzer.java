package br.edu.ifpb.analyzerQuestions.analyzers;

import java.util.List;

import br.edu.ifpb.analyzerQuestions.entities.Question;
import br.edu.ifpb.analyzerQuestions.entities.QuestionsDataSet;
import br.edu.ifpb.analyzerQuestions.util.data.ReadQuestions;
import br.edu.ifpb.analyzerQuestions.util.similarity.ScoreSimilarity;

public class QuestionsAnalyzer {

	private static Float VALUE_SIMILARITY = 0.0f;
	
	private DescriptionAnalyzer descriptionAnalyzer;
	private TitleAnalyzer titleAnalyzer;
	private List<QuestionsDataSet> questionsDataSet;
	
	public QuestionsAnalyzer() {
	}
	
	public QuestionsAnalyzer(List<QuestionsDataSet> questionsDataSet) {
		this.questionsDataSet = questionsDataSet;
		descriptionAnalyzer = new DescriptionAnalyzer();
		titleAnalyzer = new TitleAnalyzer();
		
	}
	/**
	 * Coerência do titulo com a descrição da pergunta
	 */
	public int coherencyBodyAndTitle(Question question) {
		

		ScoreSimilarity scoreSimilarity= new ScoreSimilarity();
		
		Double similarity = scoreSimilarity.getSimilarity(question.getTitle(), question.getBody());
		System.out.println(similarity);
		if(similarity > VALUE_SIMILARITY){
			return 1;
		}
		return 0;

	}
	
	public void executeCoherencyBodyAndTitle(){
		int flag = 1;
		int igual = 0;
		int diferente = 0;
		for (QuestionsDataSet qds : questionsDataSet) {
			System.out.println("Questão "+flag+": "+qds.getTitle());
			Question q = new Question(qds.getTitle(), qds.getBody());
			if(coherencyBodyAndTitle(q) == Integer.parseInt(qds.getCoerencia())){
				System.out.println("IGUAL (" + coherencyBodyAndTitle(q)+"-"+ qds.getCoerencia()+")");
				igual++;
			}else{
				System.out.println("DIFERENTE (" + coherencyBodyAndTitle(q)+"-"+ qds.getCoerencia()+")");
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
			System.out.print("Questão "+flag+": "+qds.getTitle()+" "+ " Titulo Médio: -> ");
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
			System.out.print("Questão "+flag+": "+qds.getTitle()+" "+ " Titulo Médio: -> ");
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
	
	public static void main(String[] args) {
		ReadQuestions readQuestions = new ReadQuestions();
		List<QuestionsDataSet> q = readQuestions.readCsvFile();
		QuestionsAnalyzer questionsAnalyzer = new QuestionsAnalyzer(q);
		
		questionsAnalyzer.executeCoherencyBodyAndTitle();
		//questionsAnalyzer.executeTitleMedio();
		//questionsAnalyzer.executeTituloCaixaAlta();
		//questionsAnalyzer.executeTitleCapitaLettersPartially();
		//questionsAnalyzer.executeIncludingVocative();
	}

}
