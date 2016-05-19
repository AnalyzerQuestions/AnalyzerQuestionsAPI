package br.edu.ifpb.analyzerQuestions.analyzers;

import br.edu.ifpb.analyzerQuestions.util.StringUtil;
import br.edu.ifpb.analyzerQuestions.util.data.WordsUtils;

public class Aux {
	
	/**
	 * Obviating demanding language
	 */
	public int obviatingDemandingLanguage(String description) {
		String str= StringUtil.removerAcentos(description.toLowerCase());
		String[] demandingWords = WordsUtils.WORDS_DEMANDING;
		for(int i = 0 ;i< demandingWords.length ; i++){
			if(str.contains(demandingWords[i])){
				return 0;
			}
		}
		
		return 1;
	}
	

}
