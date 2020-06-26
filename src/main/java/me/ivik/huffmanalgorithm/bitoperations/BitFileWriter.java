package me.ivik.huffmanalgorithm.bitoperations;

import java.io.*;

public class BitFileWriter {
    private FileOutputStream stream;
    private byte buffer;
    private int byteIndex;

    public BitFileWriter(File file) {
        try {
            this.stream = new FileOutputStream(file);
            byteIndex = 7;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeBuffer() {
        try {
            stream.write(buffer);
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(boolean[] bits) {
        for (boolean bit : bits) {
            write(bit);
        }
    }

    public void write(boolean bit) {
        if (bit) {
            buffer = (byte) ((0b1 << byteIndex) | buffer);
        }

        if (byteIndex == 0) {
            byteIndex = 7;
            writeBuffer();
        }
        else {
            byteIndex--;
        }
    }



    public void close() {
        writeBuffer();
    }
}
