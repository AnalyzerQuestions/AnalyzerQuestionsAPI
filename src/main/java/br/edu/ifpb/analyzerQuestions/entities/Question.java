package br.edu.ifpb.analyzerQuestions.entities;


public class Question {

	private Long id;
	private String title;
	private String body;
	private String link;
	
	public Question() {
		// TODO Auto-generated constructor stub
	}

	public Question(String title, String body) {
		this.title = title;
		this.body = body;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", body=" + body
				+ ", link=" + link + "]";
	}

}
