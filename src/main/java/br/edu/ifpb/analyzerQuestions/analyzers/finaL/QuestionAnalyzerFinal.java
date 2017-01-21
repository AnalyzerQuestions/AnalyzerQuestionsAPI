package br.edu.ifpb.analyzerQuestions.analyzers.finaL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;
import java.util.StringTokenizer;

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
 */
public class QuestionAnalyzerFinal {

	private String javaClasses;
	private String javaClassesException;
	private static final Float VALUE_SIMILARITY = 0.05f;

	public QuestionAnalyzerFinal() {
		this.setClassesJava();
		this.setClassesJavaExceptions();
	}

	/**
	 * <p>
	 * Presença de exemplo
	 * </p>
	 * 
	 * Verifica se uma descrição possui exemplo, é verdadeiro caso a mesma
	 * possua uma quantidade minima de código java, ou explicitamente na
	 * descrição tenha algo que remeta a palavra exemplo.
	 */
	public Integer analyzerShowExample(String description) {
		
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
		
		return containsLog(description);
	}

	/**
	 * <p>
	 * verifica se uma pergunta é objetiva
	 * </p>
	 * 
	 * (Ter uma descricao curta, reduzir pergunta em um único problema, evitar
	 * muito codigo)
	 */
	public Integer analyzerObjective(String description) {
		Integer cont = 0;
		if (this.analyzerShortDescriptionQuestion(description) == 1)
			cont++;
		if (this.isQuestionUnique(description))
			cont++;
		if (avoidingMuchCode(description) == 1)
			cont++;

		if (cont >= 3)
			return 1;
		return 0;
	}

	/**
	 * <p>
	 * verifica se uma pergunta é Clara
	 * </p>
	 * i.e., Objetividade, titulo coerênte com a descrição; Deixar problema bem
	 * evidente (expressões, 1 sentença iterrogativa ); mostrar exemplo
	 */
	public Integer analyzerClarity(String title, String description) {
		Integer count = 0;
		if (this.analyzerObjective(description) == 1)
			count++;
		if (analyzerCoherencyBodyAndTitle(title, description) == 1)
			count++;
		if (analyzerShowExample(description) == 1)
			count++;

		if (isQuestionUnique(description)) {
			count++;
		} else {
			if (isEvidentProbleam(description)) {
				count++;
			}
		}

		if (count >= 4)
			return 1;
		return 0;

	}

	/**
	 * Descrição bem definida (Objetividade e clareza)
	 */
	public Integer analyzerUnderstandableDescription(String title,
			String description) {

		if (this.analyzerObjective(description) == 1) {

			if (this.analyzerClarity(title, description) == 1) {
				return 1;
			}
		}
		return 0;
	}

	/**
	 * Detalhes sobre contexto (palavras chaves)
	 * 
	 */
	public Integer analyzerDetailAboutContext(String description) {
		String s1 = StringUtil.removeCharacterSpecial(description)
				.toLowerCase();

		for (int i = 0; i < WordsUtils.WORDS_DETAILS.length; i++) {
			if (s1.contains(WordsUtils.WORDS_DETAILS[i])) {
				return 1;
			}
		}

		return 0;
	}

	/**
	 * Ser educado (Usar língua apropriada, incluir agradecimento)
	 */
	public Integer analyzerBeEducated(String description) {

		if (this.analyzerUsingProperLanguage(description) == 1) {

			if (this.includingGreetings(description) == 1) {
				return 1;
			}
		}
		return 0;
	}

	/**
	 * Coerência do titulo com a descrição
	 * 
	 * Verifica se o título é coerente com a descrição, isso é feito usando
	 * calculo de similaridade entre o título e a descrição.
	 */
	public Integer analyzerCoherencyBodyAndTitle(String title,
			String description) {
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
	public Integer analyzerUsingProperLanguage(String description) {
		String s0 = StringUtil.removerTagsHtml(description.toLowerCase());
		s0 = this.removeAllCode(s0);
		s0 = StringUtil.removeCharacterSpecial(s0);
		String s2 = StringUtil.trim(s0);

		if (!CoGrooUtils.isCorrectText(s2)) {
			return 0;
		}

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
	public Integer analyzerUnderstandableTitle(String title, String description) {

		if (isMediumSizeTitle(title)) {

			if (analyzerCoherencyBodyAndTitle(title, description) == 1) {
				return 1;
			}
		}
		return 0;
	}

	/**
	 * Evitar perguntas duplicadas
	 */
	public Integer analyzerAvoidCreateDuplicateQuestion(List<String> comments) {
		String[] duplicates = WordsUtils.WORDS_DUPLICATE_CODE;
		
		for (int i = 0; i < duplicates.length; i++) {
			for (String comment : comments) {
				if(comment.contains(duplicates[i])){
					return 1;
				}
			}
		}
		
		return 0;
	}

	/**
	 * Descrição curta
	 * 
	 */
	public Integer analyzerShortDescriptionQuestion(String description) {

		if (this.avoidingMuchCode(description) == 1) {
			String str = this.removeAllCode(description);
			str = StringUtil.removeCharacterSpecial(str);
			str = StringUtil.removeConnective(str);

			StringTokenizer st = new StringTokenizer(str);

			if (st.countTokens() > 200)
				return 0;
			return 1;
		} else {
			return 0;
		}
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
	public Integer analyzerDoNotCreateHomeworkQuestions(String description) {
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
		if (flag >= 2)
			return 0;
		return 1;
	}

	/**
	 * <p>
	 * Analisa se na descrição possui algum tipo de agradecimento
	 * </p>
	 */
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
	 * Evitar pergunta com muito código
	 * 
	 */
	public Integer avoidingMuchCode(String description) {

		String str = description.toLowerCase();

		int flag = frenquencyOfCode(str, 2);
		if (flag > 180)
			return 0;
		return 1;
	}

	private boolean isEvidentProbleam(String description) {
		String str = StringUtil.removerAcentos(description);
		String[] duplicates = WordsUtils.WORDS_EVIDENT_EXPRESSIONS;

		for (int i = 0; i < duplicates.length; i++) {
			if (str.contains(duplicates[i])) {
				return true;
			}
		}
		return false;
	}

	private boolean isMediumSizeTitle(String title) {
		String str = StringUtil.removeConnective(title);
		str = StringUtil.removeCharacterSpecial(str);
		String[] strPart = StringTokenizerUtils.parseToken(str);

		if (strPart.length > 2 && strPart.length <= 8)
			return true;
		else
			return false;
	}

	private String removeAllCode(String description) {
		String result = "";
		String tStr[] = StringTokenizerUtils.parseToken(description
				.toLowerCase());
		String[] tJavaClasses = StringTokenizerUtils.parseToken(javaClasses
				.toLowerCase());

		for (int i = 0; i < tStr.length; i++) {

			for (int j = 0; j < tJavaClasses.length; j++) {
				if (tStr[i].contains(tJavaClasses[j])) {
					tStr[i] = "";
				}
			}
		}

		for (String string : tStr) {
			result += string + " ";
		}

		return StringUtil.trim(result);
	}

	/**
	 * Verifica se a descrição está relacionada a um único problema.
	 */
	private boolean isQuestionUnique(String description) {
		int flag = 0;

		String str = this.removeAllCode(description);
		String[] strSplited = StringTokenizerUtils.parseToken(str);

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

		String[] tJavaClasses = StringTokenizerUtils.parseToken(javaClasses
				.toLowerCase());
		String[] strSplited = StringTokenizerUtils.parseToken(description
				.toLowerCase());

		if (type == 1) {
			for (int j = 0; j < strSplited.length; j++) {
				for (int i = 0; i < tJavaClasses.length; i++) {

					if (strSplited[j].equals(tJavaClasses[i])) {
						flag++;
					}
				}
			}
		} else {
			for (int j = 0; j < strSplited.length; j++) {
				for (int i = 0; i < tJavaClasses.length; i++) {

					if (strSplited[j].contains(tJavaClasses[i])) {
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
		javaClasses = ReaderFile.readerTxt("classJava.txt").toLowerCase();
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
	 * Verifica se a descrição contém uma exception java e se contém algum palavra restrita a logs
	 * </p>
	 * 
	 */
	private Integer containsLog(String description) {

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
	 * @param description
	 * @return
	 */
	public int containsURL(String description) {
		if(this.getURL(description) != null) return 1;
		
		return 0;
	}
	
	/**
	 * 
	 * @param description
	 * @return
	 */
	public int combinateURLWithContent(String description) {
		if(this.getURL(description) == null) return 0;
		
		String url = this.getURL(description);
		String contentPage = this.getContentOfPage(url);
		contentPage = StringUtil.removerTagsHtml(contentPage);
		
		String descriptionReferenceUrl = this.getDescriptionReferentURL(description);
		int coherency = this.analyzerCoherencyBodyAndTitle(description,descriptionReferenceUrl);
			
		return coherency;
		
	}
	
	private String getURL(String description) {
		String[] tDescription = StringTokenizerUtils.parseToken(description);
		for (int i = 0; i < tDescription.length; i++) {
			if (isURI(tDescription[i])) return tDescription[i];
		}
		return null;
	}
	
	private String getDescriptionReferentURL(String description) {
		String afterParagraph = "";
		String beforeParagraph = "";
		
		String[] tDescription = StringTokenizerUtils.parseToken(description);
		for (int i = 0; i < tDescription.length; i++) {
			if (isURI(tDescription[i])) {
				for (int j = i+1; j < tDescription.length; j++) {
					afterParagraph += tDescription[j] +" ";
				}

				for (int j = i-1; j >= 0; j--) {
					char t = tDescription[j].charAt(tDescription[j].length()-1);
					if(t == '.'){
						char in = tDescription[j+1].charAt(0);
						if(Character.isUpperCase(in)) {
							for (int k = j+1; k < i; k++) {
								afterParagraph+= tDescription[k] + " ";
							}
						}
					}
				}
			}
		}
		return beforeParagraph +" "+ afterParagraph;
	}

	/**
	 * 
	 * @param uri
	 * @return
	 */
	private boolean isURI(String uri) {
		
		try {
			URL url = new URL(uri);
			return true;
		} catch (MalformedURLException e) {
			return false;
		}
	}
	
	/**
	 * <pre>
	 * Adicinar método em classe util
	 * <pre>
	 * @param pageURL
	 * @return
	 */
	private String getContentOfPage(String pageURL) {

		StringBuilder sb = new StringBuilder();
		try {
			URLConnection connection = new URL(pageURL).openConnection();
			connection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			connection.connect();

		    BufferedReader r = new BufferedReader(new InputStreamReader(connection.getInputStream(),
		            Charset.forName("UTF-8")));
	
		    String line;
		    while ((line = r.readLine()) != null) {
		        sb.append(line);
		    }
		} catch (IOException e) {
			return null;
		}
		
		String content = sb.toString(); 
		return content.equals("")? null:content;
	}
}
