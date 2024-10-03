package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadSymptomDataFromFile implements ISymptomReader {

    final String filepath;

    public ReadSymptomDataFromFile(String filepath) {
        this.filepath = filepath;
    }


    /**
     * Lit les symptômes en provenance d'un fichier vers un chemin donnée.
     *
     * @return une liste avec ligne pqr ligne le nom des symptomes.
     */
    @Override
    public List<String> GetSymptoms() {
        ArrayList<String> result = new ArrayList<>();

        if (filepath != null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filepath));
                String line = reader.readLine();

                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                System.out.println("Une erreur s'est produite lors de la lecture du fichier : " + e.getMessage());

            }
        }

        return result;
    }

}
