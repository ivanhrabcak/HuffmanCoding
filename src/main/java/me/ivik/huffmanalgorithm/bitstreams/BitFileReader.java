package me.ivik.huffmanalgorithm.bitstreams;

import java.io.*;

public class BitFileReader {
    private BitInputStream stream;

    public BitFileReader(File file) {
        try {
            this.stream = new BitInputStream(new BufferedInputStream(new FileInputStream(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean readBit() throws IOException {
        return stream.read();
    }

    public boolean readByte() {
        // TODO: Finish
    }
}
