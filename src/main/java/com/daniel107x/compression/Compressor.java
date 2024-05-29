package com.daniel107x.compression;

import com.daniel107x.reader.IFileReader;
import com.daniel107x.utils.FrequencyCounter;
import com.daniel107x.utils.IFrequencyCounter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class Compressor implements ICompressor{
    private final IFileReader reader;
    private final IFrequencyCounter frequencyCounter;

    public Compressor(IFileReader reader, IFrequencyCounter frequencyCounter){
        this.reader = reader;
        this.frequencyCounter = frequencyCounter;
    }

    public void compress(String fileName) throws IOException {
        try (InputStream file = reader.openFile(fileName)) {
            Map<Character, Integer> frequency = frequencyCounter.countFrequency(file);
            frequencyCounter.printFrequencyMap(frequency);
        }
    }
}
