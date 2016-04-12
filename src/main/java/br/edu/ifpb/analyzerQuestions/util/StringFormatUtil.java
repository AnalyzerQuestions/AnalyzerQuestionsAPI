package br.edu.ifpb.analyzerQuestions.util;

public class StringFormatUtil {

	public static String removeConnective(String str) {
		String[] strInPart = str.split(" ");
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < strInPart.length; i++) {
			if (strInPart[i].length() > 2) {
				sBuffer.append(strInPart[i]).append(" ");
			}
		}
		return sBuffer.toString();
	}

	public static String trimPosition(String str) {

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == ',') {
				if (str.charAt(i - 1) == ' ') {
					String s = str;
					s = replaceCharAt(str, i-1, "");
					return s;
				}
			}
		}
		return str;
	}

	public static String replaceCharAt(String s, int pos, String c) {
		return s.substring(0, pos) + c + s.substring(pos + 1);
	}
}
