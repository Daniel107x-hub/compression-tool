package com.daniel107x;

import com.daniel107x.utils.FrequencyCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class FrequencyCounterTests {
    private final FrequencyCounter frequencyCounter = new FrequencyCounter();

    @Test
    public void returnsEmptyMapIfEmptyInput() throws IOException {
        String testString = "";
        InputStream testInputStream = new ByteArrayInputStream(testString.getBytes());
        Map<Character, Integer> frequencyMap = frequencyCounter.countFrequency(testInputStream);
        Assertions.assertNotNull(frequencyMap);
        Assertions.assertEquals(0, frequencyMap.size());
    }

    @Test
    public void returnsNullIfNullInput() throws IOException {
        Map<Character, Integer> frequencyMap = frequencyCounter.countFrequency(null);
        Assertions.assertNull(frequencyMap);
    }

    @Test
    public void testUniqueCharacters() throws IOException {
        String testString = "abc";
        InputStream testInputStream = new ByteArrayInputStream(testString.getBytes());
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('b', 1);
        expected.put('c', 1);
        Assertions.assertEquals(expected, frequencyCounter.countFrequency(testInputStream));
    }

    @Test
    public void testRepeatedCharacters() throws IOException {
        String testString = "aabbcc";
        InputStream testInputStream = new ByteArrayInputStream(testString.getBytes());
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 2);
        expected.put('b', 2);
        expected.put('c', 2);
        Assertions.assertEquals(expected, frequencyCounter.countFrequency(testInputStream));
    }

    @Test
    public void testSpecialCharacters() throws IOException {
        String testString = "a b c ! ";
        InputStream testInputStream = new ByteArrayInputStream(testString.getBytes());
        Map<Character, Integer> expected = new HashMap<>();
        expected.put(' ', 4);
        expected.put('!', 1);
        expected.put('a', 1);
        expected.put('b', 1);
        expected.put('c', 1);
        Assertions.assertEquals(expected, frequencyCounter.countFrequency(testInputStream));
    }

    @Test
    public void testMixedCaseCharacters() throws IOException {
        String testString = "aAbBcC";
        InputStream testInputStream = new ByteArrayInputStream(testString.getBytes());
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('A', 1);
        expected.put('b', 1);
        expected.put('B', 1);
        expected.put('c', 1);
        expected.put('C', 1);
        Assertions.assertEquals(expected, frequencyCounter.countFrequency(testInputStream));
    }

    @Test
    public void testLongString() throws IOException {
        String testString = "a".repeat(1000) + "b".repeat(1000);
        InputStream testInputStream = new ByteArrayInputStream(testString.getBytes());
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1000);
        expected.put('b', 1000);
        Assertions.assertEquals(expected, frequencyCounter.countFrequency(testInputStream));
    }
}
