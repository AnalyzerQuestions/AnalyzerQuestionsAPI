package br.edu.ifpb.analyzerQuestions.util;

import java.io.IOException;
import java.util.Arrays;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.br.BrazilianAnalyzer;
import org.apache.lucene.analysis.br.BrazilianStemFilter;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.util.CharArraySet;

import br.edu.ifpb.analyzerQuestions.util.data.WordsUtils;

public class LuceneUtil {

	private static CharArraySet stopWords;
	private static StringBuffer tokensResult;

	
	/**
	 * Adiciona lista de stopwords brasileiros na tabela do lucene
	 */
	static {
		stopWords = new CharArraySet(Arrays.asList(WordsUtils.BRAZILIAN_STOP_WORDS), true);
	}
	
	
	/**
	 * Realiza tokenização de stopwords passados do brasil
	 * 
	 * @param text - texto a ser tokenizado
	 * @return - tokens
	 * @throws IOException
	 */
	private static TokenStream tokenizer(String text) throws IOException{
		
		Analyzer analyzer = new BrazilianAnalyzer(stopWords);
		TokenStream stream = analyzer.tokenStream(null, text);
		
		return stream;
	}
	

	/**
	 * Faz stemming da String passada filtrando stopwords do brasil e 
	 * fazendo merge dos tokens em um stringBuffer
	 * 
	 * @param text - texto a ser tokenizado
	 * @return - String em ordem
	 */
	public static StringBuffer tokenizeString(StringBuffer text) {
		
		tokensResult = new StringBuffer();

		try {
			TokenStream tokenStream = tokenizer(text.toString());
			tokenStream.reset();
			BrazilianStemFilter filter = new BrazilianStemFilter(tokenStream);

			while (filter.incrementToken()) {
				tokensResult.append(filter.getAttribute(CharTermAttribute.class).toString());
				tokensResult.append(" ");
			}

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return tokensResult;
	}
}
