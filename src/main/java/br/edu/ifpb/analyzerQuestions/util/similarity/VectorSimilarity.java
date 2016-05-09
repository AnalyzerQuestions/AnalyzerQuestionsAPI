package br.edu.ifpb.analyzerQuestions.util.similarity;

import java.util.HashMap;
import java.util.Map;

public class VectorSimilarity {
	
	private Map<String, Float> vector;

	public VectorSimilarity() {
		vector = new HashMap<String, Float>();
	}

	public VectorSimilarity(Map<String, Float> vector) {
		vector = new HashMap<String, Float>();
		this.vector = vector;
	}

	public Map<String, Float> getVector() {
		
		return vector;
	}

	public void setVector(Map<String, Float> vector) {
		this.vector = vector;
	}

	public String toString() {
		return vector.toString();
	}
}
