package br.edu.ifpb.analyzerQuestions.analyzers;

import br.edu.ifpb.analyzerQuestions.util.StringUtil;

public class TitleAnalyzer {

	/**
	 * Understandable title
	 */
	public int understandableTitle(String title) {
		return 0;

	}

	/**
	 * Medium size title (2 < words < 6)
	 */
	public int mediumSizeTitle(String title) {
		
		String str = StringUtil.removeConnective(title);
		String[] strPart = str.split(" ");
		if(strPart.length > 2 && strPart.length < 6)
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
		String[] partsToUpp = str.split(" ");

		for (int i = 0; i < partsToUpp.length; i++) {
			partsToUpp[i] = partsToUpp[i].toUpperCase();
		}

		String[] part = str.split(" ");
		for (int i = 0; i < part.length; i++) {
			if (part[i].equals(partsToUpp[i])) {
				return 1;
			}
		}
		return 0;
	}
}
