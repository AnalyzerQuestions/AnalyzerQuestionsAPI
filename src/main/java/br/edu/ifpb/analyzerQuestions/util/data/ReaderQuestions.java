package br.edu.ifpb.analyzerQuestions.util.data;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import br.edu.ifpb.analyzerQuestions.entities.QuestionsDataSetPojo;

/**
 * 
 * @author franck
 *
 */
public class ReaderQuestions {

	
	private static final String[] FILE_HEADER_MAPPING = { 
					"title",
					"body",
					"coerenciaTeD",
					"tituloBemDefinido",
					"exemplo",
					"usoNormaCultaLing",
					"educacao",
					"detailContexto",
					"descricaoCurta",
					"objetividade",
					"clareza", 
					"pergBemDefinida", 
					"evCriarPergDuplicada", 
					"evPergSobreTrabAcademicos",
					"terLink",
					"combLinkConteudo",
					"Link"
	};
		
	private static final String TITLE = "title";
	private static final String BODY = "body";
	private static final String COERENCIA_T_e_D = "coerenciaTeD";
	private static final String TITULO_BEM_DEFINIDO = "tituloBemDefinido";
	private static final String EXEMPLO = "exemplo";
	private static final String USO_NORMA_CULTA_LINGUA = "usoNormaCultaLing";
	private static final String EDUCACAO = "educacao";
	private static final String DETAIL_CONTEXTO = "detailContexto";
	private static final String DESCRICAO_CURTA = "descricaoCurta";
	private static final String OBJETIVIDADE = "objetividade";
	private static final String CLAREZA = "clareza";
	private static final String PERGUNTA_BEM_DEFINIDA = "pergBemDefinida";
	private static final String EV_CRIAR_PERGUNTAS_DUPLICADAS = "evCriarPergDuplicada";
	private static final String EV_PERG_SOBRE_TRAB_ACADEMICOS = "evPergSobreTrabAcademicos";
	private static final String TER_LINK = "terLink";
	private static final String COMB_LINK_CONTEUDO = "combLinkConteudo";

	private static String FILE_NAME;
	private List<QuestionsDataSetPojo> questions;
	
	
	@SuppressWarnings("static-access")
	public ReaderQuestions(String file) {
		
		this.FILE_NAME = file;
	}

	public List<QuestionsDataSetPojo> readCsvFile() {
		
		FileReader fileReader = null;
		CSVParser csvFileParser = null;
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);

		try {
			questions = new ArrayList<QuestionsDataSetPojo>();
			fileReader = new FileReader(FILE_NAME);
			csvFileParser = new CSVParser(fileReader, csvFileFormat);
			List<CSVRecord> csvRecords = csvFileParser.getRecords();
			
			for (int i = 1; i < csvRecords.size(); i++) {
				CSVRecord record = csvRecords.get(i);

				QuestionsDataSetPojo question = new QuestionsDataSetPojo(
						record.get(TITLE), 
						record.get(BODY), 
						record.get(COERENCIA_T_e_D), 
						record.get(TITULO_BEM_DEFINIDO),
						record.get(EXEMPLO), 
						record.get(USO_NORMA_CULTA_LINGUA),
						record.get(EDUCACAO), 
						record.get(DETAIL_CONTEXTO),
						record.get(DESCRICAO_CURTA), 
						record.get(OBJETIVIDADE), 
						record.get(CLAREZA), 
						record.get(PERGUNTA_BEM_DEFINIDA),
						record.get(EV_CRIAR_PERGUNTAS_DUPLICADAS),
						record.get(EV_PERG_SOBRE_TRAB_ACADEMICOS),
						record.get(TER_LINK),
						record.get(COMB_LINK_CONTEUDO));
				
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
		
		throw new RuntimeException("Erro ao tratar o dataset");
	}

	public List<QuestionsDataSetPojo> getQuestions() {
		return questions;
	}
}
