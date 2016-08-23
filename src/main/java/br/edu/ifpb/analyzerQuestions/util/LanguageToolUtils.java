package br.edu.ifpb.analyzerQuestions.util;

import java.io.IOException;
import java.util.List;

import org.languagetool.JLanguageTool;
import org.languagetool.language.BrazilianPortuguese;
import org.languagetool.rules.RuleMatch;

/**
 * 
 * @author franck
 *
 */
public class LanguageToolUtils {

	private static List<RuleMatch> matches;

	/**
	 * Método verifica se um texto tem a ortografia correta
	 * 
	 * @param text
	 * @return
	 */
	public static boolean textIsValid(String text, Integer freq) {
		JLanguageTool langTool = new JLanguageTool(new BrazilianPortuguese());
		try {
			matches = langTool.check(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return matches.size() <= freq;
	}

}
