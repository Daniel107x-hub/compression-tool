package com.daniel107x.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter implements IFrequencyCounter{
    /**
     * Counts the frequency of characters in an input stream
     * @param stream
     * @return Map containing the frequency of each character
     */
    public Map<Character, Integer> countFrequency(InputStream stream) throws IOException {
        if(stream == null) return null;
        Map<Character, Integer> frequency = new HashMap<>();
        while(stream.available() > 0){
            char character = (char) stream.read();
            int value = frequency.getOrDefault(character, 0);
            frequency.put(character, value + 1);
        }
        return frequency;
    }

    public void printFrequencyMap(Map<Character, Integer> frequencyMap){
        if(frequencyMap.isEmpty()) return;
        for(Map.Entry<Character, Integer> entry : frequencyMap.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
