package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    final String filepath;

    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Ecrit les symptômes dans un fichier spécifique vers un chemin donnée.
     *
     * @param symptoms une map où la clé est le nom des symptômes et avec comme valeur le nombre d'occurence par symptôme.
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        try (FileWriter writer = new FileWriter(filepath)) {


            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();

                writer.write(key + ": " + value + "\n");
            }


        } catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de l'écriture du fichier : " + e.getMessage());
        }
    }
}