package br.edu.ifpb.analyzerQuestions.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class StringUtils {
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

	public static String removerNaoLetras(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);
			if (Character.isLetter(ch) || Character.isWhitespace(ch)) {
				sb.append(ch);
			}
		}
		return sb.toString();
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

	public static Map<String, Double> montarMapaOcorrencias(
			StringBuffer buffer, boolean removerTokensUnicos) {
		Map<String, Double> mapa = new HashMap<String, Double>();

		// Cria StringTokenizer para a entrada
		StringTokenizer quebraFrase = new StringTokenizer(buffer.toString(),
				StringUtils.SEPARATOR);

		int q = quebraFrase.countTokens();
		// Processamento de texto de entrada
		while (quebraFrase.hasMoreTokens())// Enquanto houver mais entradas
		{
			String palavra = quebraFrase.nextToken(); // Obtem palavra

			// Se o mapa tiver a palavra
			if (mapa.containsKey(palavra)) // Palavras esta no mapa
			{
				double contador = mapa.get(palavra); // Obtem contagem atual
				mapa.put(palavra, contador + 1); // Incrementa a contagem
			} else
				mapa.put(palavra, 1d); // Adiciona uma nova palavra com contagem
										// de 1 ao mapa
		}

		if (removerTokensUnicos) {
			HashMap<String, Double> aux = new HashMap<String, Double>();
			for (String s : mapa.keySet()) {
				if (mapa.get(s) != 1) {
					aux.put(s, mapa.get(s));
				} else
					q--;
			}
			mapa = aux;
		}
		for (String s : mapa.keySet()) {
			mapa.put(s, (mapa.get(s) / q));
		}
		return mapa;
	}

	public static String getStringInstant() {
		return new SimpleDateFormat("dd-MM-yyyy HH-mm").format(new Date(System
				.currentTimeMillis()));
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
