package br.edu.ifpb.analyzerQuestions.analyzers;

import br.edu.ifpb.analyzerQuestions.entities.Question;
import br.edu.ifpb.analyzerQuestions.util.StringTokenizerUtils;
import br.edu.ifpb.analyzerQuestions.util.StringUtil;

/**
 * 
 * @author franck
 *
 */
public class TitleAnalyzer {

	/**
	 * Understandable title
	 */
	public int understandableTitle(String title, String description) {
		
		QuestionsAnalyzer questionsAnalyzer = new QuestionsAnalyzer();
		
		float is = 0;

		if (mediumSizeTitle(title) == 1) {
			is++;
		}
		if(questionsAnalyzer.coherencyBodyAndTitle(new Question(title, description)) == 1){
			is++;
		}
		if(titleCapitaLetters(title) == 1){
			is +=0.5f;
		}
		
		if(titleCapitaLettersPartially(title) == 1){
			is+=0.5f;
		}

		if (is >= 1.0)
			return 1;
		return 0;
	}

	/**
	 * Medium size title (2 < words =< 8)
	 */
	public int mediumSizeTitle(String title) {

		String str = StringUtil.removeConnective(title);
		String st1 = StringUtil.removeCharacterSpecial(str);
		String[] strPart = StringTokenizerUtils.parseToken(st1);
		
		if (strPart.length > 2 && strPart.length < 8)
			return 1;
		else
			return 0;
	}

	/**
	 * Title with capital letters only
	 */
	public int titleCapitaLetters(String title) {
		String titleInCapLetter = title.toUpperCase();
		
		if (title.equals(titleInCapLetter)) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * Title with capital letters partially
	 */
	public int titleCapitaLettersPartially(String title) {
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
}
