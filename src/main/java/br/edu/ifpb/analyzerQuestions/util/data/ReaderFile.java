package br.edu.ifpb.analyzerQuestions.util.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFile {

	public static String readerTxt() {

		BufferedReader br;
		StringBuilder sb = null;
		try {
			br = new BufferedReader(new FileReader("classJava.txt"));
			sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
