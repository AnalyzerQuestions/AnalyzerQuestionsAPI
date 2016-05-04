package br.edu.ifpb.analyzerQuestions.stackExchangeAPI;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;

public class StackExchangeError implements ErrorHandler {
    
    public Throwable handleError(RetrofitError error) {
        return error;
    }

}
