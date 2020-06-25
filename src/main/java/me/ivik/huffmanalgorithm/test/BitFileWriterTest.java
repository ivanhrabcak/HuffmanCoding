package me.ivik.huffmanalgorithm.test;

import me.ivik.huffmanalgorithm.bitoperations.BitFileWriter;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.*;

public class BitFileWriterTest {

    @Test
    public void testWriting() throws IOException {
        File testFile = new File("test.bin");
        testFile.createNewFile();
        BitFileWriter testWriter = new BitFileWriter(testFile);
        testWriter.write(new boolean[]{true, false, true, true, false}); // 0b10110 == 22
        FileInputStream inputStream = new FileInputStream(new File("test.bin"));
        assertEquals(22, inputStream.read());
    }

}