package br.edu.ifpb.analyzerQuestions.stackExchangeAPI;

import retrofit.http.GET;

public interface IStackExchange {

	@GET("/questions")
	QuestionsList getQuestions();
}
