package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class AnalyticsCounter {

	final ISymptomReader reader;
	final ISymptomWriter writer;

	/**
	 * Constructeur de la classe AnalyticsCounter
	 *
	 * @param reader instance de l'interface ISymptomReader
	 * @param writer instance de l'interface ISymptomWriter
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer){
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 *Permet la lecture des symptomes.
	 *
	 * @return une liste contenant les symptômes
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	/**
	 *
	 * Compte le nombre de symptômes présents par symptôme identifié.
	 *
	 * @param symptoms la liste des symptômes à compter.
	 * @return une Map avec les symptomes et leurs occurences.
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> countSymptoms = new HashMap<>();
		for (String symptom : symptoms) {
			countSymptoms.put(symptom, countSymptoms.getOrDefault(symptom, 0) + 1);
		}
		return countSymptoms;
	}

	/**
	 * Permet le trie par ordre alphabétique des symptômes.
	 *
 	 * @param symptoms une map avec les symptomes et leurs occurences.
	 * @return une map ordonnées par ordre alphabétique.
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	/**
	 * Permet l'écriture des symptomes
	 *
	 * @param symptoms une map ordonnées par ordre alphabétique.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		try{
			writer.writeSymptoms(symptoms);
		} catch (IOException e) {
			System.out.println("Error writing symptoms" + e.getMessage());
		}
	}

}
