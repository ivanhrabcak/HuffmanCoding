package me.ivik.huffmanalgorithm.test;

import me.ivik.huffmanalgorithm.bitoperations.BitFileReader;
import me.ivik.huffmanalgorithm.bitoperations.BitFileWriter;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.*;
import java.util.Arrays;

public class BitFileOperationsTest {

    @Test
    public void testWriting_2bytes() throws IOException {
        File testFile = new File("test.bin");
        testFile.delete();
        testFile.createNewFile();
        BitFileWriter testWriter = new BitFileWriter(testFile);
        testWriter.write(new boolean[]{false, false, false, false, true, true, false, true}); // 0b10110 == 22
        testWriter.write(new boolean[]{false, false, false, false, true, true, false, true});
        testWriter.close();
        FileInputStream inputStream = new FileInputStream(new File("test.bin"));
        assertEquals(13, inputStream.read());
        assertEquals(13, inputStream.read());
    }

    @Test
    public void testWriting() throws IOException {
        File testFile = new File("test.bin");
        testFile.delete();
        testFile.createNewFile();
        BitFileWriter testWriter = new BitFileWriter(testFile);
        testWriter.write(new boolean[]{false, false, false, false, true, true, false, true}); // 0b10110 == 22
        testWriter.close();
        FileInputStream inputStream = new FileInputStream(new File("test.bin"));
        assertEquals(13, inputStream.read());
    }

    @Test
    public void testReading() throws IOException {
        File testFile = new File("readtest.bin");
        testFile.createNewFile();
        FileOutputStream testOutputStream = new FileOutputStream(testFile);
        testOutputStream.write(22);
        BitFileReader reader = new BitFileReader(testFile);
        boolean[] output = new boolean[8];
        for (int i = 0; i < 8; i++) {
            output[i] = reader.readBit();
        }
        System.out.println(Arrays.toString(output));
        assertArrayEquals(output, new boolean[]{false, false, false, true, false, true, true, false});
    }

    @Test
    public void testReading_2bytes() throws IOException {
        File testFile = new File("readtest.bin");
        testFile.createNewFile();
        FileOutputStream testOutputStream = new FileOutputStream(testFile);
        testOutputStream.write(22);
        testOutputStream.write(22);
        BitFileReader reader = new BitFileReader(testFile);
        boolean[] output = new boolean[8];
        for (int i = 0; i < 8; i++) {
            output[i] = reader.readBit();
        }
        System.out.println(Arrays.toString(output));
        assertArrayEquals(output, new boolean[]{false, false, false, true, false, true, true, false});
        for (int i = 0; i < 8; i++) {
            output[i] = reader.readBit();
        }
        System.out.println(Arrays.toString(output));
        assertArrayEquals(output, new boolean[]{false, false, false, true, false, true, true, false});
    }

}