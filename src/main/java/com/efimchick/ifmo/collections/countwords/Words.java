package com.efimchick.ifmo.collections.countwords;


import java.util.*;

public class Words {

        public String countWords(List<String> lines) {

        Map<String, Integer> words = new HashMap<>();

        for (int i = 0; i < lines.size(); ++i) {
            lines.set(i, lines.get(i).replaceAll("[^a-zA-Zа-яА-Я]+", " "));
        }

        for (int i = 0; i < lines.size(); ++i) {
            lines.set(i, lines.get(i).toLowerCase(Locale.ROOT));
        }

        for (String line : lines) {
            String[] ws = line.split("\\s+");

            for (String word : ws) {
                if (word.length() >= 4) {
                    Integer count = words.getOrDefault(word, 0);
                    words.put(word, count + 1);
                }
            }
        }
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(words.entrySet());
        entries.sort(Map.Entry.<String, Integer>comparingByValue().reversed()
                .thenComparing(Map.Entry.comparingByKey()));

        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() >= 10) {
                result.append(String.format("%s - %d\n", entry.getKey(), entry.getValue()));
            }
        }

        return result.toString().trim();
    }
}
