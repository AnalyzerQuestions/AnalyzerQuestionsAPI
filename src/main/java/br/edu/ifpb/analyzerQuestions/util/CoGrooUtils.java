package br.edu.ifpb.analyzerQuestions.util;

import java.util.Locale;

import org.cogroo.analyzer.Analyzer;
import org.cogroo.analyzer.ComponentFactory;
import org.cogroo.text.Document;
import org.cogroo.text.impl.DocumentImpl;

/**
 * Classe utilitaria para extração de informações gramaticais utilizando CoGroo
 * API
 * 
 * @author franck
 *
 */
public class CoGrooUtils {

	/**
	 * etiquetas do coGroo seguem as definições da <a
	 * href="http://beta.visl.sdu.dk/visl/pt/symbolset-floresta.html">Floresta
	 * Sintáctica</a> estes atributos são referidos a duas classes utilizadas na
	 * utilização desta classe
	 */
	/**
	 * utilizada para identificar um pronome deterministo
	 */
	public static final String PRON = "pron-det";

	/**
	 * utilizada para identificar um adverbio
	 */
	public static final String ADV = "adv";

	/**
	 * utilizada para idetificar um verbo[finito, infinito]
	 */
	public static final String[] VERB_CLASSES = { "v-fin", "v-inf" };

	/**
	 * Método avalia se um texto está gramaticalmente correto
	 * 
	 * @param txt
	 *            - texto
	 * @return sim ou não
	 */
	public static boolean isCorrectText(String txt) {
		ComponentFactory factory = ComponentFactory.create(new Locale("pt","BR"));
		Analyzer cogroo = factory.createPipe();

		Document document = new DocumentImpl();
		document.setText(txt);

		cogroo.analyze(document);
		
		return true;

	}

	/**
	 * 
	 * Realiza a analise do texto e retorna o documento da análise
	 * 
	 * @param txt
	 *            texto correspondente a analise
	 */
	public static Document getDocument(String txt) {

		ComponentFactory factory = ComponentFactory.create(new Locale("pt",
				"BR"));
		Analyzer cogroo = factory.createPipe();

		Document document = new DocumentImpl();
		document.setText(txt);

		cogroo.analyze(document);

		return document;
	}

	public static void main(String[] args) {
		isCorrectText("algo");
	}
}
