package com.hemebiotech.analytics;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args){

        ISymptomWriter writer = new WriteSymptomDataToFile("Project02Eclipse//src//result.out");
        ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse//src//symptoms.txt");
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        List<String> symptoms = counter.getSymptoms();
        Map<String, Integer> countedSymptoms = counter.countSymptoms(symptoms);
        Map<String, Integer> sortSymptoms = counter.sortSymptoms(countedSymptoms);
       /* List<String> filterList = Arrays.asList("headache", "dialated pupils", "rash");
        Map<String, Integer> filteredSymptoms = counter.filteredSymptoms(sortSymptoms, filterList);*/
        counter.writeSymptoms(sortSymptoms);
    }
}
