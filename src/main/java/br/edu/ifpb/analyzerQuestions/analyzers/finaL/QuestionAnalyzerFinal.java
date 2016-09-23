package br.edu.ifpb.analyzerQuestions.analyzers.finaL;

import java.util.StringTokenizer;

import br.edu.ifpb.analyzerQuestions.util.LanguageToolUtils;
import br.edu.ifpb.analyzerQuestions.util.StringTokenizerUtils;
import br.edu.ifpb.analyzerQuestions.util.StringUtil;
import br.edu.ifpb.analyzerQuestions.util.data.ReaderFile;
import br.edu.ifpb.analyzerQuestions.util.data.WordsUtils;
import br.edu.ifpb.analyzerQuestions.util.similarity.ScoreSimilarity;


public class QuestionAnalyzerFinal {
	
	private String javaClasses;
	private static final Float VALUE_SIMILARITY = 0.05f;
	
	public QuestionAnalyzerFinal() {
		this.setClassesJava();
	}
	
	/**
	 * <p>
	 * 	Presença de exemplo
	 * </p>
	 * 
	 * Verifica se uma descrição possui exemplo, é verdadeiro caso a mesma
	 * possua uma quantidade minima de código java, ou explicitamente na
	 * descrição tenha algo que remeta a palavra exemplo.
	 */
	public Integer analyzerShowExample(String description){
		description = StringUtil.removeConnective(description);

		if (frenquencyOfCode(description, 1) >= 4) {
			return 1;
		}

		String strSplited[] = StringTokenizerUtils.parseToken(description);
		for (int i = 0; i < strSplited.length; i++) {
			for (int j = 0; j < WordsUtils.WORDS_EXAMPLES.length; j++) {
				String word = WordsUtils.WORDS_EXAMPLES[j].toLowerCase();

				if (strSplited[i].toLowerCase().equals(word)) {
					return 1;
				}
			}
		}
		return 0;
	}
	/**
	 * <p>
	 * verifica se uma pergunta é objetiva
	 * </p> 
	 * 
	 * (Ter uma descricao curta, reduzir pergunta em um único problema, evitar muito codigo)
	 */
	public Integer analyzerObjective(String description){
		Integer cont = 0;
		if(this.analyzerShortDescriptionQuestion(description) == 1)
			cont++;
		if(this.isQuestionUnique(description))
			cont++;
		if(avoidingMuchCode(description) == 1)
			cont++;
		
		if(cont >= 3)
			return 1;
		return 0;
	}
	
	/**
	 * <p>
	 *verifica se uma pergunta é Clara 
	 *</p>
	 * i.e.,
	 *		Objetividade, titulo coerênte com a descrição;
	 *			Deixar problema bem evidente (expressões, 1 sentença iterrogativa );
	 *				 mostrar exemplo
	 */
	public Integer analyzerClarity(String title, String description){
		
		return 0;
		
	}
	
	/**
	 * Descrição bem definida (Objetividade e clareza)
	 */
	public Integer  analyzerUnderstandableDescription(String title, String description){
		
		return 0;
	}
	
	/**
	 *Detalhes sobre contexto (palavras chaves)
	 * 
	 */
	public Integer analyzerDetailAboutContext(String description){
		String s1 = StringUtil.removeCharacterSpecial(description).toLowerCase();
		
		for (int i = 0 ; i < WordsUtils.WORDS_DETAILS.length; i++){
			if(s1.contains(WordsUtils.WORDS_DETAILS[i])){
				return 1;
			}
		}
		
		return 0;
	}
	
	/**
	 * Ser educado (Usar língua apropriada, incluir agradecimento)
	 */
	public Integer analyzerBeEducated(String description){
		
		return 0;
	}
	
	/**
	 * Coerência do titulo com a descrição
	 * 
	 * Verifica se o título é coerente com a descrição, isso é feito usando
	 * calculo de similaridade entre o título e a descrição.
	 */
	public Integer analyzerCoherencyBodyAndTitle(String title, String description){
		ScoreSimilarity scoreSimilarity = new ScoreSimilarity();

		Double similarity = scoreSimilarity.getSimilarity(title, description);
		if (similarity > VALUE_SIMILARITY) {
			return 1;
		}
		return 0;
	}
	
	/**
	 * <p>
	 * Analisa o uso da língua adequando na descrição
	 * </p>
	 * 
	 * Verifica se a descrição está gramaticamente e ortograficamente correta
	 * 
	 * @param description
	 *            descrição da pergunta a ser análisada
	 * @return 1/0
	 */
	public Integer analyzerUsingProperLanguage(String description){
		String s0 = StringUtil
				.removeCharacterSpecial(description.toLowerCase());
		s0 = StringUtil.removerTagsHtml(s0);
		String s2 = StringUtil.trim(s0);

		/*
		 * if (!CoGrooUtils.isCorrectText(s2)){ //conflito de uma biblioteca que
		 * ambas as apis utilizam (mofologik) return 0; }
		 */

		if (frenquencyOfCode(description, 2) == 0) {
			if (!LanguageToolUtils.textIsValid(s2, 0)) {
				return 0;
			} else {
				return 1;
			}
		}
		if (frenquencyOfCode(description, 2) > 10
				&& frenquencyOfCode(description, 2) < 60) {
			if (!LanguageToolUtils.textIsValid(s2, 80)) {
				return 0;
			} else {
				return 1;
			}
		} else if (frenquencyOfCode(description, 2) >= 5) {
			if (!LanguageToolUtils.textIsValid(s2, 12)) {
				return 0;
			} else {
				return 1;
			}
		} else if (frenquencyOfCode(description, 2) < 5) {
			if (!LanguageToolUtils.textIsValid(s2, 5)) {
				return 0;
			} else {
				return 1;
			}
		} else {
			if (!LanguageToolUtils.textIsValid(s2, 400)) {
				return 0;
			} else {
				return 1;
			}
		}
	}
	
	/**
	 * Título bem definido
	 */
	public Integer understandableTitle(String title, String description){
		
		return 0;
	}
	
	/**
	 * Evitar perguntas duplicadas
	 */
	public Integer avoidCreateDuplicateQuestion(String comment){
		String[] duplicates = WordsUtils.WORDS_DUPLICATE_CODE;
		
		for (int i = 0; i < duplicates.length; i++) {
			if(comment.contains(duplicates[i])){
				return 1;
			}
		}
		
		
		return 0;
	}
	
	/**
	 * Descrição curta
	 * 
	 */
	public Integer analyzerShortDescriptionQuestion(String description){
		String str = StringUtil.removeCharacterSpecial(description.toLowerCase());
		str = StringUtil.removeConnective(str);
		
		StringTokenizer st = new StringTokenizer(str);
		
		if(st.countTokens() > 200)
			return 0;
		return 1;
	}
	
	/**
	 * <p>
	 * Analisa se a descrição é de um exercicio ou tarefa de escola, faculdade,
	 * trabalho
	 * </p>
	 * 
	 * Verifica se a descrição possui algumas palavras (pré defindas) que
	 * remetem a caracteristica
	 */
	public Integer doNotCreateHomeworkQuestions(String description) {
		String s0 = StringUtil.removerAcentos(description);
		String s1 = StringUtil.removeCharacterSpecial(s0);
		String s2 = StringUtil.removeConnective(s1).toLowerCase();

		String[] aStr = StringTokenizerUtils.parseToken(s2);
		int flag = 0;

		for (int i = 0; i < WordsUtils.HOMEWORK_WORDS.length; i++) {
			for (int j = 0; j < aStr.length; j++) {
				if (aStr[j].equals(WordsUtils.HOMEWORK_WORDS[i])) {
					flag++;
				}
			}
		}
		if (flag > 2)
			return 0;
		return 1;
	}
	
	

	
	/**
	 * Evitar pergunta com muito código
	 * 
	 */
	public Integer avoidingMuchCode(String description) {

		description = description.toLowerCase();

		int flag = frenquencyOfCode(description, 2);
		if (flag > 160)
			return 0;
		return 1;
	}
	 
	/**
	 * Verifica se a descrição está relacionada a um único problema.
	 */
	private boolean isQuestionUnique(String description){
		int flag = 0;
		
		String[] strSplited = StringTokenizerUtils.parseToken(description);
		
		for (int i = 0; i < strSplited.length; i++) {
			if (strSplited[i].contains("?")) {
				flag++;
			}
		}
		if (flag > 1) {
			return false;
		}
		return true;
	}
	/**
	 * <p>
	 * Verifica a frequência de código em um texto
	 * </p>
	 * 
	 * @param description
	 *            texto
	 * @return a frequẽncia do texto passado
	 */
	private int frenquencyOfCode(String description, Integer type) {

		int flag = 0;

		String[] tJavaClasses = StringTokenizerUtils.parseToken(javaClasses);
		String strSplited[] = StringTokenizerUtils.parseToken(description);

		if (type == 1) {
			for (int j = 0; j < strSplited.length; j++) {
				for (int i = 0; i < tJavaClasses.length; i++) {
					
					if (strSplited[j].toLowerCase().equals(tJavaClasses[i].toLowerCase())) {
						flag++;
					}
				}
			}
		} else {
			for (int j = 0; j < strSplited.length; j++) {
				for (int i = 0; i < tJavaClasses.length; i++) {
					
					if (strSplited[j].toLowerCase().contains(tJavaClasses[i].toLowerCase())) {
						flag++;
					}
				}
			}

		}
		return flag;
	}
	
	/**
	 * método auxiliar para carregar os nomes das classes do java. Deve ser
	 * executado antes para não ter que fazer conexão com a pagina toda vez.
	 */
	private void setClassesJava() {
		javaClasses = ReaderFile.readerTxt("classJava.txt");
	}
	
}
