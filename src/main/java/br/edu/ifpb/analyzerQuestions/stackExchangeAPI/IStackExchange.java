package br.edu.ifpb.analyzerQuestions.stackExchangeAPI;

import retrofit.http.GET;

/**
 * 
 * @author franck
 *
 */
public interface IStackExchange {

	@GET("/questions/")
	QuestionsList getQuestions();
}
