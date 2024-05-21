package com.daniel107x.reader;

import java.io.InputStream;

public interface IFileReader {
    InputStream openFile(String fileName);
}
