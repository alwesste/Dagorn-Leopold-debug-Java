package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    final String filepath;

    public WriteSymptomDataToFile (String filepath) {
        this.filepath = filepath;
    }
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {

        try (FileWriter writer = new FileWriter(filepath)) {


            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();

                writer.write(key + ": " + value + "\n");
            }


        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}