package br.edu.ifpb.analyzerQuestions.util.data;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import br.edu.ifpb.analyzerQuestions.entities.QuestionsDataSet;

/**
 * 
 * @author franck
 *
 */
public class ReaderQuestions {

	/**
	 * 
	 */
	
	@SuppressWarnings("static-access")
	public ReaderQuestions(String file) {
		this.FILE_NAME = file;
	}
	private static final String[] FILE_HEADER_MAPPING = { "title", "body","tituloBemDefinido", "tituloMedio",
		"tituloCaixaAlta", "tituloParCaixaAlta", "coerencia", "perguntaBemDefinida", "vocativo", "evDescricaoCurta"
		, "evDescricaoLonga", "presencaCodigo", "evTrechoGrandeCodigo", "evPergComApenasCod", "perguntaUnica",
		"incluirAgradecimento", "evSerExigente", "usoNormaCultaLing", "evCriarPergDuplicada", "evPergFactoides",
		"evPergSobreTrabAcademicos"};
	
	private static final String TITLE = "title";
	private static final String BODY = "body";
	private static final String TITULO_BEM_DEFINDO = "tituloBemDefinido";
	private static final String TITULO_MEDIO = "tituloMedio";
	private static final String TITULO_CAIXA_ALTA = "tituloCaixaAlta";
	private static final String TITULO_PAR_CAIXA_ALTA = "tituloParCaixaAlta";
	private static final String COERENCIA = "coerencia";
	private static final String PERG_BEM_DEFINIDA = "perguntaBemDefinida";
	private static final String VOCATIVO = "vocativo";
	private static final String EV_DESCRICAO_CURTA = "evDescricaoCurta";
	private static final String EV_DESCRICAO_LONGA = "evDescricaoLonga";
	private static final String PRESENCA_CODIGO = "presencaCodigo";
	private static final String EV_TRECHO_GRANDE_CODIGO = "evTrechoGrandeCodigo";
	private static final String EV_PERG_COM_APENAS_COD = "evPergComApenasCod";
	private static final String PERGUNTA_UNICA = "perguntaUnica";
	private static final String INCLUIR_AGRADECIMENTO = "incluirAgradecimento";
	private static final String EV_SER_EXIGENTE = "evSerExigente";
	private static final String USO_NORMA_CULTA_LING = "usoNormaCultaLing";
	private static final String EV_CRIAR_PERG_DUPLICADA = "evCriarPergDuplicada";
	private static final String EV_PERG_FACTOIDES = "evPergFactoides";
	private static final String EV_PERG_SOBRE_TRAB_ACADEMICOS = "evPergSobreTrabAcademicos";


	private static String FILE_NAME;
	private List<QuestionsDataSet> questions;

	/**
	 * 
	 * @return
	 */
	public List<QuestionsDataSet> readCsvFile() {
		FileReader fileReader = null;
		CSVParser csvFileParser = null;
		CSVFormat csvFileFormat = CSVFormat.DEFAULT
				.withHeader(FILE_HEADER_MAPPING);

		try {
			questions = new ArrayList<QuestionsDataSet>();
			fileReader = new FileReader(FILE_NAME);
			csvFileParser = new CSVParser(fileReader, csvFileFormat);
			List<CSVRecord> csvRecords = csvFileParser.getRecords();
			for (int i = 1; i < csvRecords.size(); i++) {
				CSVRecord record = csvRecords.get(i);

				QuestionsDataSet question = new QuestionsDataSet(record.get(TITLE), record.get(BODY), record.get(TITULO_BEM_DEFINDO), record.get(TITULO_MEDIO),
						record.get(TITULO_CAIXA_ALTA), record.get(TITULO_PAR_CAIXA_ALTA),record.get(COERENCIA), record.get(PERG_BEM_DEFINIDA),
						record.get(VOCATIVO), record.get(EV_DESCRICAO_CURTA), record.get(EV_DESCRICAO_LONGA), record.get(PRESENCA_CODIGO),
						record.get(EV_TRECHO_GRANDE_CODIGO), record.get(EV_PERG_COM_APENAS_COD),record.get(PERGUNTA_UNICA),record.get(INCLUIR_AGRADECIMENTO),
						record.get(EV_SER_EXIGENTE), record.get(USO_NORMA_CULTA_LING), record.get(EV_CRIAR_PERG_DUPLICADA), record.get(EV_PERG_FACTOIDES),
						record.get(EV_PERG_SOBRE_TRAB_ACADEMICOS));
				
				questions.add(question);
			}
			return questions;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
				csvFileParser.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		throw new RuntimeException("Erro o tratar o dataset");
	}

	public List<QuestionsDataSet> getQuestions() {
		return questions;
	}

}
