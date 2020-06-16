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

    public byte readByte() throws IOException {
        boolean[] bits = new boolean[8];
        for (int i = 7; i >= 0; i--) {
            bits[i] = stream.read();
        }
        byte b = 0;
        int k = 1;
        for (int i = 7; i >= 0; i--) {
            if (bits[i]) {
                b += k;
            }
            k += k * 2;
        }
        return b;
    }
}
