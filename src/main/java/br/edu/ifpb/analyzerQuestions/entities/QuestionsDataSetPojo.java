package br.edu.ifpb.analyzerQuestions.entities;

/**
 * 
 * @author franck
 *
 */
public class QuestionsDataSetPojo {
	
	private String title;
	private String body;
	private String coerenciaTeD;
	private String tituloBemDefinido;
	private String exemplo;
	private String usoNormaCultaLingua;
	private String educacao;
	private String detailContexto;
	private String descricaoCurta;
	private String objetividade;
	private String clareza;
	private String pergBemDefinida;
	private String evPerguntaDuplicada;
	private String evPergSobreTrabAcademicos;
	
	public QuestionsDataSetPojo(
			String title,
			String body,
			String coerenciaTeD, 
			String tituloBemDefinido,
			String exemplo,
			String usoNormaCultaLingua,
			String educacao,
			String detailContexto, 
			String descricaoCurta,
			String objetividade, 
			String clareza,
			String pergBemDefinida, 
			String evPerguntaDuplicada,
			String evPergSobreTrabAcademicos 
	) {
		this.title = title;
		this.body = body;
		this.coerenciaTeD = coerenciaTeD;
		this.tituloBemDefinido = tituloBemDefinido;
		this.exemplo = exemplo;
		this.usoNormaCultaLingua = usoNormaCultaLingua;
		this.educacao = educacao;
		this.detailContexto = detailContexto;
		this.descricaoCurta = descricaoCurta;
		this.objetividade = objetividade;
		this.clareza = clareza;
		this.pergBemDefinida = pergBemDefinida;
		this.evPerguntaDuplicada = evPerguntaDuplicada;
		this.evPergSobreTrabAcademicos = evPergSobreTrabAcademicos;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	public String getCoerenciaTeD() {
		return coerenciaTeD;
	}

	public String getTituloBemDefinido() {
		return tituloBemDefinido;
	}

	public String getExemplo() {
		return exemplo;
	}

	public String getUsoNormaCultaLingua() {
		return usoNormaCultaLingua;
	}

	public String getEducacao() {
		return educacao;
	}

	public String getDetailContexto() {
		return detailContexto;
	}

	public String getDescricaoCurta() {
		return descricaoCurta;
	}

	public String getObjetividade() {
		return objetividade;
	}

	public String getClareza() {
		return clareza;
	}

	public String getPergBemDefinida() {
		return pergBemDefinida;
	}

	public String getEvPerguntaDuplicada() {
		return evPerguntaDuplicada;
	}

	public String getEvPergSobreTrabAcademicos() {
		return evPergSobreTrabAcademicos;
	}
}
