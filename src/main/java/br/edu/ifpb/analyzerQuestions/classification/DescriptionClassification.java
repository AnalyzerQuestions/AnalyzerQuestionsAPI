package br.edu.ifpb.analyzerQuestions.classification;

import br.edu.ifpb.analyzerQuestions.util.StringUtil;

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
		String str1 = StringUtil.trimPosition(description);
		String str2 = StringUtil.removeConnective(str1);
		System.out.println(str2);
		String[] str = str2.split(" ");
		String position = str[0];
		if (position.charAt(position.length()-1) == ',') {
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
