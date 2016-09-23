package br.edu.ifpb.analyzerQuestions.analyzers.initial.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.BackingStoreException;

import org.cogroo.text.Document;
import org.cogroo.text.Sentence;
import org.cogroo.text.Token;

import br.edu.ifpb.analyzerQuestions.analyzers.initial.QuestionAnalyzer;
import br.edu.ifpb.analyzerQuestions.util.CoGrooUtils;
import br.edu.ifpb.analyzerQuestions.util.LanguageToolUtils;
import br.edu.ifpb.analyzerQuestions.util.StringTokenizerUtils;
import br.edu.ifpb.analyzerQuestions.util.StringUtil;
import br.edu.ifpb.analyzerQuestions.util.data.ReaderFile;
import br.edu.ifpb.analyzerQuestions.util.data.WordsUtils;
import br.edu.ifpb.analyzerQuestions.util.similarity.ScoreSimilarity;

/**
 * 
 * @author franck
 * 
 * Rafael.
 *
 */
public class QuestionAnalyzerImpl implements QuestionAnalyzer {

	private String javaClasses;
	private String javaClassesException;
	private static final Float VALUE_SIMILARITY = 0.05f;
	
	BackingStoreException s = null;

	public QuestionAnalyzerImpl() {
		this.setClassesJava();
		this.setClassesJavaExceptions();
	}

	/**
	 * <p>
	 * Análise se o título é bem definido
	 * </p>
	 */
	/**
	 * verifica com base em outras características da análise do título, se o
	 * mesmo é "bem definido"
	 * 
	 * Considera-se pesos para determinadas caracteristicas
	 */
	@Override
	public Integer understandableTitle(String title, String description) {

		float is = 0;

		if (mediumSizeTitle(title) == 1) {
			is++;
		}
		if (coherencyBodyAndTitle(title, description) == 1) {
			is++;
		}


		if (is >= 2.0)
			return 1;
		return 0;
	}

	/**
	 * <p>
	 * Verifica se um título tem tamanho médio.
	 * </p>
	 */
	/**
	 * Verifica se um título de uma pergunta é de tamanho médio. Considera como
	 * um título médio se o mesmo tiver tamanho maior que dois caracteres e
	 * menos de 9 caracteres
	 */
	@Override
	public Integer mediumSizeTitle(String title) {
		String str = StringUtil.removeConnective(title);
		String st1 = StringUtil.removeCharacterSpecial(str);
		String[] strPart = StringTokenizerUtils.parseToken(st1);

		if (strPart.length > 2 && strPart.length <= 8)
			return 1;
		else
			return 0;
	}

	/**
	 * <p>
	 * Verifica se um título tem sua formatação em caixa alta
	 * </p
	 */
	@Override
	public Integer titleCapitaLetters(String title) {
		String titleInCapLetter = title.toUpperCase();

		if (title.equals(titleInCapLetter)) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * <p>
	 * Verifica se um título tem parte de seu texto em caixa alta
	 * </p>
	 */
	@Override
	public Integer titleCapitaLettersPartially(String title) {
		String str = StringUtil.removeConnective(title);
		String st1 = StringUtil.removeCharacterSpecial(str);

		String[] partsToUpp = StringTokenizerUtils.parseToken(st1);
		for (int i = 0; i < partsToUpp.length; i++) {
			partsToUpp[i] = partsToUpp[i].toUpperCase();
		}

		String[] part = StringTokenizerUtils.parseToken(st1);
		for (int i = 0; i < part.length; i++) {
			if (part[i].equals(partsToUpp[i])) {
				return 1;
			}
		}
		return 0;
	}

	/**
	 * <p>
	 * Verifica coerência de uma pergunta
	 * </p>
	 * 
	 * Verifica se o título é coerente com a descrição, isso é feito usando
	 * calculo de similaridade entre o título e a descrição.
	 */
	@Override
	public Integer coherencyBodyAndTitle(String title, String descrption) {
		ScoreSimilarity scoreSimilarity = new ScoreSimilarity();

		Double similarity = scoreSimilarity.getSimilarity(title, descrption);
		if (similarity > VALUE_SIMILARITY) {
			return 1;
		}
		return 0;
	}

	/**
	 * <p>
	 * Verifica se a descrição é bem definida
	 * </p>
	 */
	/**
	 * 
	 */
	@Override
	public Integer understandableDescription(String description) {
		float is = 0;

		if (shortDescription(description) == 1) {
			is++;
		}
		if (showingExample(description) == 1) {
			is++;
		}
		if (avoidingMuchCode(description) == 1) {
			is++;
		}
		if (avoidDescriptionWithCodeOnly(description) == 1) {
			is += 0.5f;
		}
		if (questionWithSingleProblem(description) == 1) {
			is += 0.5f;
		}
		if (is >= 3.5) {
			return 1;
		}
		return 0;
	}


	/**
	 * <p>
	 * presença de vocativo
	 * </p>
	 */
	/**
	 * Verifica se uma descrição possuí vocativo
	 */
	@Override
	public Integer includingVocative(String description) {
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
	 * <p>
	 * Evitar descrição curta da pergunta
	 * </p>
	 */
	/**
	 * Verifica se uma descrição é curta. Para se considerada como uma descrição
	 * curta a mesma deve ter a quantidade de palavras menor ou igual a 1,
	 * desconsiderando conectivos (ou, se, de e, o, a, etc), caracteres
	 * especiais e palavras e classes do java
	 */
	@Override
	public Integer shortDescription(String description) {
		String str = StringUtil.removeCharacterSpecial(description.toLowerCase());
		str = StringUtil.removeConnective(str);
		String tStr[] = StringTokenizerUtils.parseToken(str);

		String[] tJavaClasses = StringTokenizerUtils.parseToken(javaClasses);
		List<String> aux = new ArrayList<String>();

		for (int i = 0; i < tStr.length; i++) {
			for (int j = 0; j < tJavaClasses.length; j++) {
				if (!tStr[i].equals(tJavaClasses[j])) {
					aux.add(tStr[i]);
				}
			}
		}
		if (aux.size() > 10)
			return 1;
		return 0;
	}

	/**
	 * <p>
	 * Evitar descrição longa demais na pergunta.
	 * </p>
	 */
	/**
	 * Verifica se uma descrição de uma descrição é longa demais. Considera-se
	 * como uma descrição longa caso a mesma tenha a quantidade de palavras
	 * maior que 700, desconsiderando caracteres especiais e palavras e classes
	 * doo java.
	 */
	@Override
	public Integer longDescription(String description) {
		String str = StringUtil.removeCharacterSpecial(description
				.toLowerCase());
		str = StringUtil.removerTagsHtml(str);
		str = StringUtil.removeConnective(str);
		str = StringUtil.trim(str);
		String strSplited[] = StringTokenizerUtils.parseToken(str);

		String[] tJavaClasses = StringTokenizerUtils.parseToken(javaClasses);
		List<String> aux = new ArrayList<String>();

		for (int i = 0; i < strSplited.length; i++) {
			for (int j = 0; j < tJavaClasses.length; j++) {
				if (strSplited[i].equals(tJavaClasses[j])) {
					aux.add(strSplited[i]);
				}
			}
		}

		if (aux.size() < 200)
			return 1;
		return 0;
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
	 * <p>
	 * Presença de exemplo
	 * </p>
	 */
	/**
	 * Verifica se uma descrição possui exemplo, é verdadeiro caso a mesma
	 * possua uma quantidade minima de código java, ou explicitamente na
	 * descrição tenha algo que remeta a palavra exemplo.
	 */
	@Override
	public Integer showingExample(String description) {
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
	 * Evitar muito codigo
	 * </p>
	 */
	@Override
	public Integer avoidingMuchCode(String description) {

		description = description.toLowerCase();

		int flag = frenquencyOfCode(description, 2);
		if (flag > 160)
			return 0;
		return 1;
	}

	/**
	 * método auxiliar para carregar os nomes das classes do java. Deve ser
	 * executado antes para não ter que fazer conexão com a pagina toda vez.
	 */
	private void setClassesJava() {
		javaClasses = ReaderFile.readerTxt("classJava.txt");
	}
	
	/**
	 * método auxiliar para carregar os nomes das classes exception do java. Deve ser
	 * executado antes para não ter que fazer conexão com a pagina toda vez.
	 */
	private void setClassesJavaExceptions(){
		javaClassesException = ReaderFile.readerTxt("classOnlyExceptionJava.txt");
	}

	/**
	 * <p>
	 * evitar descricao com apenas código
	 * </p>
	 */
	@Override
	public Integer avoidDescriptionWithCodeOnly(String description) {
		boolean isInit = false;
		boolean isEnd = false;
		String[] s = {};

		for (int i = 0; i < WordsUtils.WORDS_INIT_COD.length; i++) {
			s = StringTokenizerUtils.parseToken(description.toLowerCase());
			if (s[0].trim().contains(WordsUtils.WORDS_INIT_COD[i])) {
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

		if (isInit && isEnd) {
			return 0;
		}
		return 1;
	}

	/**
	 * Restringir a pergunta a um unico problema
	 */
	@Override
	public Integer questionWithSingleProblem(String description) {
		int flag = 0;
		
		String[] strSplited = StringTokenizerUtils.parseToken(description);
		
		for (int i = 0; i < strSplited.length; i++) {
			if (strSplited[i].contains("?")) {
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
	 * </p>
	 */
	@Override
	public Integer includingGreetings(String description) {
		String s0 = StringUtil
				.removeCharacterSpecial(description.toLowerCase());
		String s1 = StringUtil.removeConnective(s0);

		for (int i = 0; i < WordsUtils.WORDS_GREETINGS.length; i++) {
			if (s1.contains(WordsUtils.WORDS_GREETINGS[i])) {
				return 1;
			}
		}
		return 0;
	}
	
	/**
	 *	<p>
	 * Verifica se a descrição possui algum tipo sequência de palavra ou palavra que remeta a exigências 
	 * </p>
	 */

	@Override
	public Integer obviatingDemandingLanguage(String description) {
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
	 * </p>
	 * 
	 * Verifica se a descrição está gramaticamente e ortograficamente correta
	 * 
	 * @param description
	 *            descrição da pergunta a ser análisada
	 * @return 1/0
	 */
	@Override
	public Integer usingProperLanguage(String description) {
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
	 * <p>
	 * Análisa se uma pergunta é factual
	 * </p>
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
	 * @return 1/0
	 */
	@Override
	public Integer avoidingCreatingFactoidQuestions(String description) {

		String s0 = StringUtil.removeConnective(description);
		String s1 = StringUtil.removerAcentos(s0);
		String s2 = StringUtil.removerTagsHtml(s1);
		String s3 = StringUtil.trim(s2);

		String[] tStr = StringTokenizerUtils.parseToken(s3);

		if (tStr.length <= 10) {

			for (int i = 0; i < WordsUtils.WORDS_FACTOID.length; i++) {
				if (tStr[0].toLowerCase().equals(
						WordsUtils.WORDS_FACTOID[i].toLowerCase())) {
					return 0;
				}
			}
		}
		return 1;
	}

	/**
	 * Verifica se um texto é objetivo (i.e., se é focado em apenas uma coisa).
	 * 
	 * Verifica a quantidade de verbos e substantivos no texto. Considerando a
	 * aplicabilidade para perguntas factuais, tendo que uma pergunta factual é
	 * curta, verifica-se se o texto tem no máximo três substantivos e três
	 * verbos
	 * 
	 * @param doc
	 *            - documento do tipo CoGroo
	 * @return true or false
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private boolean isObjective(Document doc) {
		int countVerb = 0;
		int countSub = 0;
		for (Sentence s : doc.getSentences()) {
			for (Token t : s.getTokens()) {
				for (int i = 0; i < CoGrooUtils.VERB_CLASSES.length; i++) {
					if (t.getPOSTag().equals(CoGrooUtils.VERB_CLASSES[i]))
						countVerb++;
				}
				if (t.getPOSTag().equals("n")) {
					countSub++;
				}
			}
		}

		if (countSub <= 3 && countVerb <= 3) {
			return true;
		}
		return false;
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
	@Override
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
	 * <p>
	 * Verifica se a descrição contém alguma palavra ou sequência de palavras 
	 * que remetam ao autor da pergunta tenha demostrado interesse em resolver o seu problema
	 * </p>
	 * 
	 */
	@Override
	public Integer demonstrateInterest(String description) {
		String s0 = StringUtil.removerAcentos(description);
		String s1 = StringUtil.removeCharacterSpecial(s0).toLowerCase();
		
		for (int i = 0 ; i < WordsUtils.WORDS_INTEREST.length; i++){
			if(s1.contains(WordsUtils.WORDS_INTEREST[i])){
				return 1;
			}
		}
		
		return 0;
	}

	/**
	 * <p>
	 * Verifica se a descrição contém uma exception java e se contém algum palavra restrita a logs
	 * </p>
	 * 
	 */
	
	@Override
	public Integer containsLog(String description) {

		String s1 = StringUtil.replaceByDot(description).toLowerCase();
		
		String[] tJavaExceptionClasses = StringTokenizerUtils.parseToken(javaClassesException);
		
		int countFreq = 0;
		
		for (int i = 0 ; i < tJavaExceptionClasses.length; i++){
			if(s1.contains(tJavaExceptionClasses[i].toLowerCase())){
				countFreq = 1;
			}
		}
		
		for(int i = 0 ; i < WordsUtils.WORDS_LOG.length ; i++){
			if(s1.contains(WordsUtils.WORDS_LOG[i])){
				countFreq ++;
			}
		}
		
		if (countFreq > 1) {
			return 1;
		}
		
		return 0;
	}

	/**
	 * 
	 */
	@Override
	public Integer completeCode(String description) {
		
		return null;
	}

	/**
	 * <p>
	 *Verifiva se existe palavras ou sequências de palavras que rementem ao presença de detalhes sobre ferramentas utilizadas e etc.
	 * </p>
	 */
	@Override
	public Integer detailsPresence(String description) {
		String s1 = StringUtil.removeCharacterSpecial(description).toLowerCase();
		
		for (int i = 0 ; i < WordsUtils.WORDS_DETAILS.length; i++){
			if(s1.contains(WordsUtils.WORDS_DETAILS[i])){
				return 1;
			}
		}
		
		return 0;
	}
	
	
	
	
}
