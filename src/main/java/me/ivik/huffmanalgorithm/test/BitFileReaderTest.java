package me.ivik.huffmanalgorithm.test;

import me.ivik.huffmanalgorithm.bitoperations.BitFileReader;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BitFileReaderTest {
    @Test
    public void testReading() throws IOException {
        File testFile = new File("readtest.bin");
        testFile.createNewFile();
        FileOutputStream testOutputStream = new FileOutputStream(testFile);
        testOutputStream.write(22);
        BitFileReader reader = new BitFileReader(testFile);
        boolean[] output = new boolean[5];
        for (int i = 0; i < 5; i++) {
            output[i] = reader.readBit();
        }
        System.out.println(Arrays.toString(output));
        assertArrayEquals(output, new boolean[]{false, true, true, false, true});
    }

}