package com.daniel107x.compression;

import java.io.IOException;

public interface ICompressor {
    void compress(String fileName) throws IOException;
}
