package br.edu.ifpb.analyzerQuestions.util;

public class WordExamples {
	
	/**
	 * Lista de palavras que podem identificar um exemplo numa pergunta
	 */
	public static String wordsCod = "abstract,assert,boolean,break,byte,case,catch,char,class,const,default"
			+ "else,enum,extends,false,final,finally,float,for,goto"
			+ "if,implements,import,instanceof,int,interface,long,native,new,null,package"
			+ "private,protected,public,return,short,static,strictfp,super,switch,synchronized"
			+ "this,throw,throws,transient,true,try,void,volatile,while,continue";
	
	public static String words = "exemplo,por exemplo,codigo,segue o codigo,vejam o codigo," + wordsCod;
	
	
	
	public static String[] getWords(){
		String[] splited = words.split(",");
		return splited;
	}
}
