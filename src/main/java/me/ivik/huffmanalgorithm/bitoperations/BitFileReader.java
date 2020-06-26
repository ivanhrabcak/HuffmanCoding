package me.ivik.huffmanalgorithm.bitoperations;

import java.io.*;

public class BitFileReader {
    private Byte buffer = null;
    private int bufferIndex = 0;
    private InputStream inputStream;

    public BitFileReader(InputStream input) {
        inputStream = input;
    }

    public byte readByte() throws IOException {
        byte output = 0;
        for (int i = 0; i < 8; i++) {
            boolean bit = readBit();
            if (bit) {
                output |= (byte) ((0b1 << (7 - i)));
            }
        }
        return output;
    }

    private byte readByteInternal() throws IOException {
        return inputStream.readNBytes(1)[0];
    }

    public boolean readBit() throws IOException {
        if (buffer == null) {
            buffer = readByteInternal();
            bufferIndex = 7;
        }

        boolean output = (buffer & (0b1 << bufferIndex--)) != 0;

        if (bufferIndex == -1) {
            buffer = null;
        }
        return output;
    }
}
