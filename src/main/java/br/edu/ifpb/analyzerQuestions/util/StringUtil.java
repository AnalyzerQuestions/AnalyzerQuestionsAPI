package br.edu.ifpb.analyzerQuestions.util;


public class StringUtil {
	static String acentuado = "çÇáéíóúýÁÉÍÓÚÝàèìòùÀÈÌÒÙãõñäëïöüÿÄËÏÖÜÃÕÑâêîôûÂÊÎÔÛ";
	static String semAcento = "cCaeiouyAEIOUYaeiouAEIOUaonaeiouyAEIOUAONaeiouAEIOU";
	static char[] tabela;
	public static final String SEPARATOR = ".";

	static {
		tabela = new char[256];
		for (int i = 0; i < tabela.length; ++i) {
			tabela[i] = (char) i;
		}
		for (int i = 0; i < acentuado.length(); ++i) {
			tabela[acentuado.charAt(i)] = semAcento.charAt(i);
		}
	}

	public static String removerAcentos(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);
			if (ch < 256) {
				sb.append(tabela[ch]);
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	public static String toConstantForm(String var) {
		String constante = removerAcentos(var.replace(" ", "_").toUpperCase());
		return constante;
	}

	public static String removerTagsHtml(String html) {
		return html.replaceAll("<.*?>", "");
	}
	
	public static String removeConnective(String str) {
		String[] strInPart = str.split(" ");
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < strInPart.length; i++) {
			if (strInPart[i].length() > 2) {
				sBuffer.append(strInPart[i]).append(" ");
			}
		}
		return sBuffer.toString().toLowerCase();
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
	
	public static String removeCharacterSpecial(String str){
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(Character.isLetter(c) || Character.isWhitespace(c)){
				sb.append(c);
			}
		}
		return sb.toString().toLowerCase();
	}

	/* remove leading whitespace */
	public static String ltrim(String source) {
		return source.replaceAll("^\\s+", "");
	}

	/* remove trailing whitespace */
	public static String rtrim(String source) {
		return source.replaceAll("\\s+$", "");
	}

	/* replace multiple whitespaces between words with single blank */
	public static String itrim(String source) {
		return source.replaceAll("\\b\\s{2,}\\b", " ");
	}

	/* remove all superfluous whitespaces in source string */
	public static String trim(String source) {
		return itrim(ltrim(rtrim(source)));
	}

	public static String lrtrim(String source) {
		return ltrim(rtrim(source));
	}

}
