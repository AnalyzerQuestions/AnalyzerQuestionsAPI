package br.edu.ifpb.analyzerQuestions.classification;

import br.edu.ifpb.analyzerQuestions.util.StringFormatUtil;

public class DescriptionClassification {

	/**
	 * Understandable description
	 */
	public int understandableBody(String description) {

		return 0;
	}

	/**
	 * Including a vocative
	 */
	public int includingVocative(String description) {
		String str1 = StringFormatUtil.trimPosition(description);
		String str2 = StringFormatUtil.removeConnective(str1);
		String[] str = str2.split(" ");
		String p1 = str[0];
		if (p1.charAt(p1.length() - 1) == ',') {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * Avoid too short description
	 */
	public int shortDescription(String description) {
		return 0;
	}

	/**
	 * Avoid too long description
	 */
	public int longDescription(String description) {
		return 0;
	}

	/**
	 * Showing an example
	 */
	public int showingExample(String description) {
		return 0;
	}

	/**
	 * Avoiding too much code
	 */
	public int avoidingMuchCode(String description) {
		return 0;
	}

	/**
	 * Avoid description with code only
	 */
	public int avoidDescriptionWithCodeOnly(String description) {
		return 0;
	}

}
