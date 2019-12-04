package com.boatingdock.utils;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class BoatingDockInputProcessorImplTest {

    @Test
    public void process_shouldReturn_fileOutput_txt() throws IOException {
        File file1 = new File("src/main/java/com/boatingdock/doc/file_inputs.txt");
        BufferedReader expectedReader;
        expectedReader = new BufferedReader(new FileReader(file1));
        String scan;
        StringBuilder stringBuilder = new StringBuilder();

        File file2 = new File("src/main/java/com/boatingdock/doc/file_outputs.txt");
        BufferedReader actualReader;
        actualReader = new BufferedReader(new FileReader(file2));
        BoatingDockInputProcessorImpl dockInputProcessor = new BoatingDockInputProcessorImpl();

        while ((scan = actualReader.readLine()) != null) {
            stringBuilder.append(scan + "\n");
        }

        String expectedString =stringBuilder.toString();
        String actualString = dockInputProcessor.process(expectedReader);
        assertEquals(expectedString,actualString);

    }
}