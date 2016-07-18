package br.edu.ifpb.analyzerQuestions.analyzers;

public interface QuestionAnalyzer {
	
	Integer understandableTitle(String title, String description);
	
	Integer mediumSizeTitle(String title);
	
	Integer titleCapitaLetters(String title);
	
	Integer titleCapitaLettersPartially(String title);
	
	Integer coherencyBodyAndTitle(String title, String descrption);
	
	Integer understandableDescription(String description);
	
	Integer includingVocative(String description);
	
	Integer shortDescription(String description) ;
	
	Integer longDescription(String description);
	
	Integer showingExample(String description);
	
	Integer avoidingMuchCode(String description);
	
	Integer avoidDescriptionWithCodeOnly(String description);
	
	Integer questionWithSingleProblem(String description);
	
	Integer includingGreetings(String description);
	
	Integer obviatingDemandingLanguage(String description);
	
	Integer usingProperLanguage(String description);
	
	Integer avoidingCreatingFactoidQuestions(String description);
	
	Integer doNotCreateHomeworkQuestions(String description);
	
	
	
	
	


}
