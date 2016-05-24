package br.edu.ifpb.analyzerQuestions.analyzers;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.cogroo.analyzer.ComponentFactory;
import org.cogroo.checker.CheckDocument;
import org.cogroo.checker.GrammarChecker;

import br.edu.ifpb.analyzerQuestions.enumerations.Site;
import br.edu.ifpb.analyzerQuestions.util.HttpUtils;
import br.edu.ifpb.analyzerQuestions.util.StringTokenizerUtils;
import br.edu.ifpb.analyzerQuestions.util.StringUtil;
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
	 * p1 + p2 + p3 + p(n)/1.40(~=70%)
	 */
	public int understandableDescription(String description) {
		float is = 0;
		float bestResult = 1f + 1f + 0.5f + 0.2f + 0.1f;

		if (shortDescription(description) == 1) {
			is++;
		}
		if (longDescription(description) == 1) {
			is++;
		}
		if (showingExample(description) == 1) {
			is += 0.5f;
		}
		if (includingGreetings(description) == 1) {
			is += 0.2f;
		}
		if (includingVocative(description) == 1) {
			is = is + 0.1f;
		}
		if (is >= (bestResult / 1.40)) {
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
		String[] str = str2.split(" ");

		if (str.length >= 3) {
			for (int i = 0; i < 3; i++) {
				String sn = str[i];
				if (sn.charAt(sn.length() - 1) == ',') {
					return 1;
				}
			}
			String s0 = str[0];
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
		String str = StringUtil.removeCharacterSpecial(description
				.toLowerCase());
		str = StringUtil.removeConnective(str);
		String strSplited[] = str.split(" ");
		if (strSplited.length > 10)
			return 1;
		return 0;
	}

	/**
	 * 
	 * Evitar descrição longa demais na pergunta
	 */
	public int longDescription(String description) {
		String str = StringUtil.removeCharacterSpecial(description
				.toLowerCase());
		str = StringUtil.removeConnective(str);
		String strSplited[] = str.split(" ");
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
	public void setClassesJava() {
		javaClasses = HttpUtils.getPageContent(Site.JAVA_CLASSES.getSite());
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

		/*
		 * for (int i = 0; i < WordsUtils.WORDS_ONLY_ONE.length; i++) {
		 * if(s1.contains(WordsUtils.WORDS_ONLY_ONE[i])){ flag++; } }
		 */

		if (flag > 1) {
			return 0;
		}
		return 1;
	}

	/**
	 * Including greetings
	 */
	public int includingGreetings(String description) {
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
	 * Using proper language
	 */
	public int usingProperLanguage(String description) {
		
		String s0 = StringUtil.removeCharacterSpecial(description);
		String s1 = StringUtil.removerTagsHtml(s0);
		String s2 = StringUtil.trim(s1);
		
		ComponentFactory factory = ComponentFactory.create(new Locale("pt", "BR"));
		CheckDocument document = null;
		try {
			GrammarChecker gc = new GrammarChecker(factory.createPipe());
			document = new CheckDocument(s2);
			gc.analyze(document);
		
		} catch (IllegalArgumentException | IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(document.getMistakesAsString());
		if(document.getMistakes().size() > 0)
			return 0;
		return 1;
	}

	/**
	 * Avoiding creating factoid questions
	 */
	public int avoidingCreatingFactoidQuestions(String description) {
		return 0;
	}

	/**
	 * Do not create homework questions
	 */
	public int doNotCreateHomeworkQuestions(String description) {

		String s0 = StringUtil.removerAcentos(description);
		String s1 = StringUtil.removeCharacterSpecial(s0);
		String s2 = StringUtil.removeConnective(s1).toLowerCase();

		String[] aStr = StringTokenizerUtils.parseToken(s2);
		List<String> list = Arrays.asList(aStr);
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
}
