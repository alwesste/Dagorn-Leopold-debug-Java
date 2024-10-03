package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

/**
 * Interface qui va permettre l'écriture des symptômes,
 * en défnissant un nom et un emplacement.
 */
public interface ISymptomWriter {
    void writeSymptoms(Map<String, Integer> symptoms) throws IOException;
}
