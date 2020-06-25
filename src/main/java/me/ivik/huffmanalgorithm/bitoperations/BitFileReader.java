package me.ivik.huffmanalgorithm.bitoperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BitFileReader {
    private Byte buffer = null;
    private int bufferIndex = 0;
    private FileInputStream inputStream;

    public BitFileReader(File file) {
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public byte readByte() throws IOException {
        return inputStream.readNBytes(1)[0];
    }

    public boolean readBit() throws IOException {
        if (buffer == null) {
            buffer = inputStream.readNBytes(1)[0];
            bufferIndex = 0;
        }
        else {
            if (bufferIndex == 7) {
                buffer = 0;
                return readBit();
            }
        }
        return Integer.toBinaryString(buffer & (0b1 << bufferIndex++)).contains("1");
    }
}
