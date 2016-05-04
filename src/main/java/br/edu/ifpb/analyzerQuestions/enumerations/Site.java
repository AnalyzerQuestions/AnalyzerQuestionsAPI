package br.edu.ifpb.analyzerQuestions.enumerations;

public enum Site {

	STACK_OVERFLOW("pt.stackoverflow");

	private String site;

	private Site(String site) {
		this.site = site;
	}

	public String getSite() {
		return site;
	}

}
