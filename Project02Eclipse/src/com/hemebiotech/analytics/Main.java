package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    /**
     * Permet le lancement du programme
     *
     * @param args pas utlisé
     */
    public static void main(String[] args) {

        //initialise writer pour l'écriture des resultats a la fin de ce programme.
        ISymptomWriter writer = new WriteSymptomDataToFile("Project02Eclipse//src//result.out");
        //Initialise reader pour la lecture ds symptômes
        ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse//src//symptoms.txt");
        // Initialise counter pour le traitement du programme
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        //Récupère les symptômes
        List<String> symptoms = counter.getSymptoms();
        //Compte les occurences par symptôme
        Map<String, Integer> countedSymptoms = counter.countSymptoms(symptoms);
        //Trie les symptômes par ordre alphabétique
        Map<String, Integer> sortSymptoms = counter.sortSymptoms(countedSymptoms);
        //Ecrit les symptomes dans un fichier
        counter.writeSymptoms(sortSymptoms);
    }
}
