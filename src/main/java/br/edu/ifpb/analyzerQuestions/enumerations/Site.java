package br.edu.ifpb.analyzerQuestions.enumerations;

/**
 * 
 */
/**
 * 
 * @author franck
 *
 */
public enum Site {

	/**
	 * Site starkoverflow em português
	 */
	STACK_OVERFLOW("pt.stackoverflow"),
	
	/**
	 * Pagina contendo lista de todos as classes pertencentes ao java jdk 8
	 */
	JAVA_CLASSES("https://docs.oracle.com/javase/8/docs/api/allclasses-noframe.html");

	private String site;

	/**
	 * 
	 * @param site
	 */
	private Site(String site) {
		this.site = site;
	}

	/**
	 * 
	 * @return
	 */
	public String getSite() {
		return site;
	}

}
