package br.edu.ifpb.analyzerQuestions.analyzers.impl;

import org.cogroo.text.Document;
import org.cogroo.text.Sentence;
import org.cogroo.text.Token;

import br.edu.ifpb.analyzerQuestions.util.CoGrooUtils;
import br.edu.ifpb.analyzerQuestions.util.LanguageToolUtils;
import br.edu.ifpb.analyzerQuestions.util.StringTokenizerUtils;
import br.edu.ifpb.analyzerQuestions.util.StringUtil;
import br.edu.ifpb.analyzerQuestions.util.data.ReaderFile;
import br.edu.ifpb.analyzerQuestions.util.data.WordsUtils;

/**
 * 
 * @author franck
 *
 */
public class DescriptionAnalyzer {

	private String javaClasses;

	public DescriptionAnalyzer() {
		this.setClassesJava();
	}

	/**
	 * Understandable description
	 */
	/**
	 * Considera-se pesos para cada caracteristca que a descrição atende, sendo
	 * que umas tem pesos maiores que outras. Considera-se que a descrição tenha
	 * 70% dos pesos das caracteristicas cobradas
	 * 
	 */
	public int understandableDescription(String description) {
		float is = 0;

		if (shortDescription(description) == 1) {
			is++;
		}
		if (longDescription(description) == 1) {
			is++;
		}
		if(avoidDescriptionWithCodeOnly(description) == 1){
			is++;
		}
		if (showingExample(description) == 1) {
			is += 0.5f;
		}
		if(avoidingCreatingFactoidQuestions(description) == 1){
			is +=0.5f;
		}
		if(usingProperLanguage(description) == 1){
			is += 0.5f;
		}
		if (includingGreetings(description) == 1) {
			is += 0.2f;
		}
		if (includingVocative(description) == 1) {
			is += 0.1f;
		}
		
		if (is >= (3.3)) {
			return 1;
		}
		return 0;
	}

	/**
	 * presença de vocativo
	 */
	public int includingVocative(String description) {
		
		String str1 = StringUtil.trimPosition(description.toLowerCase());
		String str2 = StringUtil.removeConnective(str1);
		String[] tStr = StringTokenizerUtils.parseToken(str2);

		if (tStr.length >= 3) {
			for (int i = 0; i < 2; i++) {
				String sn = tStr[i];
				if (sn.charAt(sn.length() - 1) == ',') {
					return 1;
				}
			}
			String s0 = tStr[0];
			for (int i = 0; i < WordsUtils.WORDS_VACATIVES.length; i++) {
				if (s0.equalsIgnoreCase(WordsUtils.WORDS_VACATIVES[i])) {
					return 1;
				}
			}
		}
		return 0;
	}

	/**
	 * Evitar desecrição curta da pergunta
	 */
	public int shortDescription(String description) {
		
		String str = StringUtil.removeCharacterSpecial(description.toLowerCase());
		str = StringUtil.removeConnective(str);
		String tStr[] = StringTokenizerUtils.parseToken(str);
		
		if (tStr.length > 10)
			return 1;
		return 0;
	}

	/**
	 * 
	 * Evitar descrição longa demais na pergunta
	 */
	public int longDescription(String description) {
		
		String str = StringUtil.removeCharacterSpecial(description.toLowerCase());
		str = StringUtil.removerTagsHtml(str);
		str = StringUtil.removeConnective(str);
		str = StringUtil.trim(str);
		String strSplited[] = StringTokenizerUtils.parseToken(str);
		
		if (strSplited.length < 800)
			return 1;
		return 0;
	}

	/**
	 * 
	 * Presença de exemplo
	 */
	public int showingExample(String description) {
		description = StringUtil.removeConnective(description);

		if (frenquencyOfCode(description) >= 4) {
			return 1;
		}

		for (int i = 0; i < WordsUtils.getWords().length; i++) {
			String word = WordsUtils.getWords()[i];

			if (description.contains(word)) {
				return 1;
			}
		}
		return 0;
	}

	/**
	 * 
	 * @param description
	 * @return
	 */
	private int frenquencyOfCode(String description) {

		int flag = 0;
		for (int i = 0; i < WordsUtils.getWordsCode().length; i++) {
			String word = WordsUtils.getWordsCode()[i];

			if (description.contains(word)) {
				flag++;
			}
		}

		String[] tJavaClasses = StringTokenizerUtils.parseToken(javaClasses);

		for (int i = 0; i < tJavaClasses.length; i++) {
			if (description.contains(tJavaClasses[i])) {
				flag++;
			}
		}
		return flag;
	}

	/**
	 * Evitar muito codigo
	 */
	public int avoidingMuchCode(String description) {

		description = description.toLowerCase();

		int flag = frenquencyOfCode(description);

		if (flag > 200)
			return 0;
		return 1;
	}

	/**
	 * método auxiliar para carregar os nomes das classes do java. Deve ser
	 * executado antes para não ter que fazer conexão com a pagina toda vez.
	 */
	private void setClassesJava() {
		javaClasses = ReaderFile.readerTxt();
	}

	/**
	 * evitar descricao com apenas código
	 */
	public int avoidDescriptionWithCodeOnly(String description) {

		boolean isInit = false;
		boolean isEnd = false;
		String[] s = {};

		for (int i = 0; i < WordsUtils.WORDS_INIT_COD.length; i++) {
			s = StringTokenizerUtils.parseToken(description.toLowerCase());
			if (s[0].equals(WordsUtils.WORDS_INIT_COD[i])) {
				isInit = true;
			}
		}
		s = StringTokenizerUtils.parseToken(description.toLowerCase());
		String f = s[s.length - 1];
		String f2 = Character.toString(f.charAt(f.length() - 1));

		for (int i = 0; i < WordsUtils.WORDS_END_COD.length; i++) {
			if (s[s.length - 1].equals(WordsUtils.WORDS_END_COD[i])
					|| f2.equals(WordsUtils.WORDS_END_COD[i])) {
				isEnd = true;
			}
		}

		if (isInit && isEnd)
			return 0;
		return 1;
	}

	/**
	 * Restringir a pergunta a um unico problema
	 */
	public int questionWithSingleProblem(String description) {

		int flag = 0;
		for (int i = 0; i < description.length(); i++) {
			if (description.charAt(i) == '?') {
				flag++;
			}
		}

		if (flag > 1) {
			return 0;
		}
		return 1;
	}

	/**
	 * <p>
	 * Analisa se na descrição possui algum tipo de agradecimento
	 * <p>
	 */
	public int includingGreetings(String description) {
		String s0 = StringUtil.removeCharacterSpecial(description.toLowerCase());
		String s1 = StringUtil.removeConnective(s0);

		for (int i = 0; i < WordsUtils.WORDS_GREETINGS.length; i++) {
			if (s1.contains(WordsUtils.WORDS_GREETINGS[i])) {
				return 1;
			}
		}
		return 0;
	}

	/**
	 * Obviating demanding language
	 */
	public int obviatingDemandingLanguage(String description) {
		String str = StringUtil.removerAcentos(description.toLowerCase());
		String[] demandingWords = WordsUtils.WORDS_DEMANDING;
		for (int i = 0; i < demandingWords.length; i++) {
			if (str.contains(demandingWords[i])) {
				return 0;
			}
		}

		return 1;
	}

	/**
	 * <p>
	 * Analisa o uso da língua adequando na descrição
	 * <p>
	 * 
	 * Verifica se a descrição está gramaticamente e ortograficamente correta 
	 * 
	 * @param description descrição da paergunta a ser análisada
	 * @return 1/0
	 */
	public int usingProperLanguage(String description) {

		String s0 = StringUtil.removeCharacterSpecial(description);
		String s1 = StringUtil.removerTagsHtml(s0);
		String s2 = StringUtil.trim(s1);

		if (!CoGrooUtils.isCorrectText(s2)){
			return 0;
		}
		
		if(!LanguageToolUtils.textIsValid(s2)){
			return 0;
		}
		return 1;
	}


	/**
	 * <p>
	 * Análisa se uma pergunta é factual
	 * <p>
	 * 
	 * Considera uma pergunta factual tendo: 
	 * 
	 * Um pronome interrogativo/advebio[relatives, interrogatives]
	 * (qual,como,onde, quantos) no inicio da pergunta.
	 * 
	 * Pergunta curta.
	 * 
	 * Objetiva e envolva um único objectivo
	 * 
	 * @param description
	 * @return
	 */
	public int avoidingCreatingFactoidQuestions(String description) {
		
		String s0 = StringUtil.removeConnective(description);
		String s1 = StringUtil.removerAcentos(s0);
		String s2 = StringUtil.removerTagsHtml(s1);
		String s3 = StringUtil.trim(s2);

		String[] tStr = StringTokenizerUtils.parseToken(s3);
		
		if (tStr.length <= 8) {
			
			Document doc = CoGrooUtils.getDocument(s3);
			Sentence sentence = doc.getSentences().get(0);
			Token token = sentence.getTokens().get(0);
			String classe = token.getPOSTag();
			
			if(classe.equals(CoGrooUtils.PRON) || classe.equals(CoGrooUtils.ADV)){
				if(this.isObjective(doc)){
					return 0;
				}
			}
		}
		return 1;
	}
	
	/**
	 * Verifica se um texto é objetivo (i.e., se é focado em apenas uma coisa).
	 * 
	 * Verifica a quantidade de verbos e substantivos no texto.
	 * Considerando a aplicabilidade para perguntas factuais, tendo que uma pergunta 
	 * factual é curta, verifica-se se o texto tem no máximo três substantivos e três verbos
	 * 
	 * @param doc - documento do tipo CoGroo
	 * @return true or false
	 */
	private boolean isObjective(Document doc){
		int countVerb = 0;
		int countSub = 0;
		for (Sentence s : doc.getSentences()) {
			for (Token t : s.getTokens()) {
				for (int i = 0; i < CoGrooUtils.VERB_CLASSES.length; i++) {
					if(t.getPOSTag().equals(CoGrooUtils.VERB_CLASSES[i]))
						countVerb++;
				}
				if(t.getPOSTag().equals("n")){
					countSub++;
				}
			}
		}
		
		if(countSub <= 3 && countVerb <= 3 ){
			return true;
		}
		return false;
	}

	/**
	 * <p>
	 * Analisa se a descrição é de um exercicio ou tarefa de escola, faculdade, trabalho
	 * <p>
	 * 
	 * Verifica se a descrição possui algumas palavras (pré defindas)
	 * que remetem a caracteristica
	 */
	public int doNotCreateHomeworkQuestions(String description) {

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
	 * 
	 * @param description
	 * @return
	 */
	public int includingLink(String description){
		return 0;
	}
}
