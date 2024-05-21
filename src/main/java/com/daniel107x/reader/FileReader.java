package com.daniel107x.reader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader implements IFileReader{
    public InputStream openFile(String fileName){
        try (InputStream file = Files.newInputStream(Paths.get(fileName))){
            return file;
        }catch(IOException exception){
            System.out.println("Unable to open file");
            return null;
        }
    }
}
