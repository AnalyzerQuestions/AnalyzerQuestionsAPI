package br.edu.ifpb.analyzerQuestions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import org.languagetool.AnalyzedSentence;
import org.languagetool.JLanguageTool;
import org.languagetool.Language;
import org.languagetool.Languages;
import org.languagetool.language.BrazilianPortuguese;
import org.languagetool.language.LanguageIdentifier;
import org.languagetool.rules.RuleMatch;


public class LanguageToolUtils {
	
	public static void main(String[] args) throws IOException {
	    
	    Language language = Languages.getLanguageForLocale(new Locale("pt","BR"));
	    JLanguageTool jlanguage = new JLanguageTool(language);
	    
	    List<RuleMatch> result = jlanguage.check("Algo incrivel");
	    
	      for (RuleMatch ruleMatch : result) {
		        System.out.println("    " + ruleMatch);
		        List<String> str = ruleMatch.getSuggestedReplacements();
		        for (String string : str) {
					System.out.println(string);
				}
		      }
	    
	    
		/*
	    
	    List<Language> realLanguages = Languages.get();
	    for (Language language : realLanguages) {
			System.out.println(language.toString());
		}
	    
	    System.out.println("Supported languages: " + realLanguages.size());
	    for (Language language : realLanguages) {
	      JLanguageTool langTool = new JLanguageTool(language);
	      String input = "And the the";
	      List<RuleMatch> result = langTool.check(input);
	      System.out.println("Checking '" + input + "' with " + language + ":");
	      for (RuleMatch ruleMatch : result) {
	        System.out.println("    " + ruleMatch);
	      }
	    }*/
	  }

}
