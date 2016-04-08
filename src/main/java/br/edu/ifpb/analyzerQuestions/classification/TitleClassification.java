package br.edu.ifpb.analyzerQuestions.classification;

public class TitleClassification {

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

		return 0;
	}

	/**
	 * Title with capital letters only
	 */
	public int TitleCapitaLetters(String title) {
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
	public int TitleCapitaLettersPartially(String title) {
		String[] partsToUpp = title.split(" ");

		for (int i = 0; i < partsToUpp.length; i++) {
			partsToUpp[i] = partsToUpp[i].toUpperCase();
		}

		String[] part = title.split(" ");
		for (int i = 0; i < part.length; i++) {
			if (part[i].equals(partsToUpp[i])) {
				return 1;
			}
		}
		return 0;
	}
}
