package br.edu.ifpb.analyzerQuestions;

import br.edu.ifpb.analyzerQuestions.enumerations.Site;
import br.edu.ifpb.analyzerQuestions.stackExchangeAPI.IStackExchange;
import br.edu.ifpb.analyzerQuestions.stackExchangeAPI.QuestionsList;
import br.edu.ifpb.analyzerQuestions.stackExchangeAPI.StackExchangeAPI;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		StackExchangeAPI api = new StackExchangeAPI("Od0ApalxujcmxgiTJ566gA((", "CEWWD9gissG5heqD0UCc1w))");

		IStackExchange siteService = api.getSiteService(Site.STACK_OVERFLOW.getSite());
		
		QuestionsList questions = siteService.getQuestions();
		
		
//		String s = new Gson().toJson(siteService.getQuestions());
//		
//		Type collectionType = new TypeToken<Collection<QuestionsList>>(){}.getType();
//		QuestionsList q = new Gson().fromJson(s, collectionType);
		
		
	}
}
