package com.daniel107x;

import com.daniel107x.compression.Compressor;
import com.daniel107x.compression.ICompressor;
import com.daniel107x.reader.FileReader;
import com.daniel107x.reader.IFileReader;
import com.daniel107x.utils.FrequencyCounter;
import com.daniel107x.utils.IFrequencyCounter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if(args.length != 1) throw new IllegalArgumentException("Please provide a file name as the first argument.");
        IFrequencyCounter frequencyCounter = new FrequencyCounter();
        IFileReader fileReader = new FileReader();
        ICompressor compressor = new Compressor(fileReader, frequencyCounter);
        compressor.compress(args[0]);
    }
}
