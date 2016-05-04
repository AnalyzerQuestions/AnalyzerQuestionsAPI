package br.edu.ifpb.analyzerQuestions.stackExchangeAPI;

import retrofit.http.GET;

public interface StackExchangeSite {

	public static final String STACK_OVERFLOW = "pt.stackoverflow";

	@GET("/questions")
	QuestionsList getQuestions();
}
