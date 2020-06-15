package me.ivik.huffmanalgorithm.bitstreams;

import java.io.*;

public class BitFileWriter {
    private BitOutputStream outputStream;

    public BitFileWriter(File file) {
        try {
            this.outputStream = new BitOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeBit(boolean bit) throws IOException {
        outputStream.write(bit);
    }

    public void writeByte(byte b) throws IOException {
        boolean[] bitArray = new boolean[8];
        for (int bit = 0; bit < 8; bit++) { // http://helpdesk.objects.com.au/java/converting-large-byte-array-to-binary-string
            if (((b >> bit) & 1) > 0) {
                bitArray[bit] = true;
            }
            else {
                bitArray[bit] = false;
            }
        }

        for (int i = 7; i > -1; i--) {
                outputStream.write(bitArray[i]);
        }
    }

}
