package br.edu.ifpb.analyzerQuestions.analyzers;

import br.edu.ifpb.analyzerQuestions.entities.Question;
import br.edu.ifpb.analyzerQuestions.util.StringUtil;

/**
 * 
 * @author franck
 *
 */
public class TitleAnalyzer {

	private QuestionsAnalyzer questionsAnalyzer;
	/**
	 * Understandable title
	 */
	public int understandableTitle(String title, String description) {
		questionsAnalyzer = new QuestionsAnalyzer();
		
		float is = 0;

		if (mediumSizeTitle(title) == 1) {
			is++;
		}
		
		if(questionsAnalyzer.coherencyBodyAndTitle(new Question(title, description)) == 1){
			is++;
		}
		if(titleCapitaLetters(description) == 1){
			is +=0.5f;
		}
		
		if(titleCapitaLettersPartially(description) == 1){
			is+=0.5f;
		}

		if (is >= 1.0)
			return 1;
		return 0;
	}

	/**
	 * Medium size title (2 < words < 6)
	 */
	public int mediumSizeTitle(String title) {

		String str = StringUtil.removeConnective(title);
		String st1 = StringUtil.removeCharacterSpecial(str);
		String[] strPart = st1.split(" ");
		if (strPart.length > 2 && strPart.length <= 6)
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

		String[] partsToUpp = st1.split(" ");
		for (int i = 0; i < partsToUpp.length; i++) {
			partsToUpp[i] = partsToUpp[i].toUpperCase();
		}

		String[] part = st1.split(" ");
		for (int i = 0; i < part.length; i++) {
			if (part[i].equals(partsToUpp[i])) {
				return 1;
			}
		}
		return 0;
	}
}
