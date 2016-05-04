package br.edu.ifpb.analyzerQuestions.entities;

public class Question {

	private String title;
	private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String body) {
		this.description = body;
	}

	@Override
	public String toString() {
		return "Question [title=" + title + ", description=" + description + "]";
	}

}
