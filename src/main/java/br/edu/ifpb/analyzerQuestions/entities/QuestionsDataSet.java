package br.edu.ifpb.analyzerQuestions.entities;

public class QuestionsDataSet {

	private String title;
	private String body;

	private String tituloBemDefinido;
	private String tituloMedio;
	private String tituloCaixaAlta;
	private String tituloParCaixaAlta;
	private String coerencia;
	private String perguntaBemDefinda;
	private String vocativo;
	private String evDescricaoCurta;
	private String evDescricaoLonga;
	private String presencaCodigo;
	private String evTrechoGrandeCodigo;
	private String evPergComApenasCod;
	private String perguntaUnica;
	private String incluirAgradecimento;
	private String evSerExigente;
	private String usoNormaCultaLing;
	private String evCriarPergDuplicada;
	private String evPergFactoides;
	private String evPergSobreTrabAcademicos;
	
	@SuppressWarnings("unused")
	private String incluirLinkPergunta;  // add no construtor

	public QuestionsDataSet(String title, String body,
			String tituloBemDefinido, String tituloMedio,
			String tituloCaixaAlta, String tituloParCaixaAlta,
			String coerencia, String perguntaBemDefinda, String vocativo,
			String evDescricaoCurta, String evDescricaoLonga,
			String presencaCodigo, String evTrechoGrandeCodigo,
			String evPergComApenasCod, String perguntaUnica,
			String incluirAgradecimento, String evSerExigente,
			String usoNormaCultaLing, String evCriarPergDuplicada,
			String evPergFactoides, String evPergSobreTrabAcademicos) {
		this.title = title;
		this.body = body;
		this.tituloBemDefinido = tituloBemDefinido;
		this.tituloMedio = tituloMedio;
		this.tituloCaixaAlta = tituloCaixaAlta;
		this.tituloParCaixaAlta = tituloParCaixaAlta;
		this.coerencia = coerencia;
		this.perguntaBemDefinda = perguntaBemDefinda;
		this.vocativo = vocativo;
		this.evDescricaoCurta = evDescricaoCurta;
		this.evDescricaoLonga = evDescricaoLonga;
		this.presencaCodigo = presencaCodigo;
		this.evTrechoGrandeCodigo = evTrechoGrandeCodigo;
		this.evPergComApenasCod = evPergComApenasCod;
		this.perguntaUnica = perguntaUnica;
		this.incluirAgradecimento = incluirAgradecimento;
		this.evSerExigente = evSerExigente;
		this.usoNormaCultaLing = usoNormaCultaLing;
		this.evCriarPergDuplicada = evCriarPergDuplicada;
		this.evPergFactoides = evPergFactoides;
		this.evPergSobreTrabAcademicos = evPergSobreTrabAcademicos;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTituloBemDefinido() {
		return tituloBemDefinido;
	}

	public void setTituloBemDefinido(String tituloBemDefinido) {
		this.tituloBemDefinido = tituloBemDefinido;
	}

	public String getTituloMedio() {
		return tituloMedio;
	}

	public void setTituloMedio(String tituloMedio) {
		this.tituloMedio = tituloMedio;
	}

	public String getTituloCaixaAlta() {
		return tituloCaixaAlta;
	}

	public void setTituloCaixaAlta(String tituloCaixaAlta) {
		this.tituloCaixaAlta = tituloCaixaAlta;
	}

	public String getTituloParCaixaAlta() {
		return tituloParCaixaAlta;
	}

	public void setTituloParCaixaAlta(String tituloParCaixaAlta) {
		this.tituloParCaixaAlta = tituloParCaixaAlta;
	}

	public String getCoerencia() {
		return coerencia;
	}

	public void setCoerencia(String coerencia) {
		this.coerencia = coerencia;
	}

	public String getPerguntaBemDefinda() {
		return perguntaBemDefinda;
	}

	public void setPerguntaBemDefinda(String perguntaBemDefinda) {
		this.perguntaBemDefinda = perguntaBemDefinda;
	}

	public String getVocativo() {
		return vocativo;
	}

	public void setVocativo(String vocativo) {
		this.vocativo = vocativo;
	}

	public String getEvDescricaoCurta() {
		return evDescricaoCurta;
	}

	public void setEvDescricaoCurta(String evDescricaoCurta) {
		this.evDescricaoCurta = evDescricaoCurta;
	}

	public String getEvDescricaoLonga() {
		return evDescricaoLonga;
	}

	public void setEvDescricaoLonga(String evDescricaoLonga) {
		this.evDescricaoLonga = evDescricaoLonga;
	}

	public String getPresencaCodigo() {
		return presencaCodigo;
	}

	public void setPresencaCodigo(String presencaCodigo) {
		this.presencaCodigo = presencaCodigo;
	}

	public String getEvTrechoGrandeCodigo() {
		return evTrechoGrandeCodigo;
	}

	public void setEvTrechoGrandeCodigo(String evTrechoGrandeCodigo) {
		this.evTrechoGrandeCodigo = evTrechoGrandeCodigo;
	}

	public String getEvPergComApenasCod() {
		return evPergComApenasCod;
	}

	public void setEvPergComApenasCod(String evPergComApenasCod) {
		this.evPergComApenasCod = evPergComApenasCod;
	}

	public String getPerguntaUnica() {
		return perguntaUnica;
	}

	public void setPerguntaUnica(String perguntaUnica) {
		this.perguntaUnica = perguntaUnica;
	}

	public String getIncluirAgradecimento() {
		return incluirAgradecimento;
	}

	public void setIncluirAgradecimento(String incluirAgradecimento) {
		this.incluirAgradecimento = incluirAgradecimento;
	}

	public String getEvSerExigente() {
		return evSerExigente;
	}

	public void setEvSerExigente(String evSerExigente) {
		this.evSerExigente = evSerExigente;
	}

	public String getUsoNormaCultaLing() {
		return usoNormaCultaLing;
	}

	public void setUsoNormaCultaLing(String usoNormaCultaLing) {
		this.usoNormaCultaLing = usoNormaCultaLing;
	}

	public String getEvCriarPergDuplicada() {
		return evCriarPergDuplicada;
	}

	public void setEvCriarPergDuplicada(String evCriarPergDuplicada) {
		this.evCriarPergDuplicada = evCriarPergDuplicada;
	}

	public String getEvPergFactoides() {
		return evPergFactoides;
	}

	public void setEvPergFactoides(String evPergFactoides) {
		this.evPergFactoides = evPergFactoides;
	}

	public String getEvPergSobreTrabAcademicos() {
		return evPergSobreTrabAcademicos;
	}

	public void setEvPergSobreTrabAcademicos(String evPergSobreTrabAcademicos) {
		this.evPergSobreTrabAcademicos = evPergSobreTrabAcademicos;
	}

	@Override
	public String toString() {
		return "QuestionsDataSet [title=" + title + ", body=" + body
				+ ", tituloBemDefinido=" + tituloBemDefinido + ", tituloMedio="
				+ tituloMedio + ", tituloCaixaAlta=" + tituloCaixaAlta
				+ ", tituloParCaixaAlta=" + tituloParCaixaAlta + ", coerencia="
				+ coerencia + ", perguntaBemDefinda=" + perguntaBemDefinda
				+ ", vocativo=" + vocativo + ", evDescricaoCurta="
				+ evDescricaoCurta + ", evDescricaoLonga=" + evDescricaoLonga
				+ ", presencaCodigo=" + presencaCodigo
				+ ", evTrechoGrandeCodigo=" + evTrechoGrandeCodigo
				+ ", evPergComApenasCod=" + evPergComApenasCod
				+ ", perguntaUnica=" + perguntaUnica
				+ ", incluirAgradecimento=" + incluirAgradecimento
				+ ", evSerExigente=" + evSerExigente + ", usoNormaCultaLing="
				+ usoNormaCultaLing + ", evCriarPergDuplicada="
				+ evCriarPergDuplicada + ", evPergFactoides=" + evPergFactoides
				+ ", evPergSobreTrabAcademicos=" + evPergSobreTrabAcademicos
				+ "]";
	}

}
