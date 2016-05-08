package br.edu.ifpb.analyzerQuestions.util.similarity;

import java.util.HashMap;
import java.util.Map;

public class Vector {
	
	private Map<String, Float> vector;

	public Vector() {
		vector = new HashMap<String, Float>();
	}

	public Vector(Map<String, Float> vector) {
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
