package com.daniel107x.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public interface IFrequencyCounter {
    Map<Character, Integer> countFrequency(InputStream stream) throws IOException;
    void printFrequencyMap(Map<Character, Integer> frequencyMap);
}
