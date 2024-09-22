package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.*;

public class AnalyticsCounter {

	final ISymptomReader reader;
	final ISymptomWriter writer;


	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer){
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return reader.GetSymptoms();
	}

	public Map<String, Integer>	 countSymptoms(List<String> symptoms) {
		Map<String, Integer> countSymptoms = new HashMap<>();
		for (String symptom : symptoms) {
			countSymptoms.put(symptom, countSymptoms.getOrDefault(symptom, 0) + 1);
		}
		return countSymptoms;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		try{
			writer.writeSymptoms(symptoms);
		} catch (IOException e) {
			System.out.println("Error writing symptoms" + e.getMessage());
		}
	}

//	public Map<String, Integer>	 filteredSymptoms(Map<String, Integer> symptoms, List<String> filteredList) {
//		Map<String, Integer> filteredSymptoms = new HashMap<>();
//		for (String symptom : filteredList) {
//			if (symptoms.containsKey(symptom)) {
//				filteredSymptoms.put(symptom, symptoms.get(symptom));
//			}
//		}
//		return filteredSymptoms;
//	}



}
