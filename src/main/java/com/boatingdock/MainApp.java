package com.boatingdock;

import com.boatingdock.dao.BoatingDockDaoImpl;
import com.boatingdock.model.Boat;
import com.boatingdock.utils.BoatingDockInputProcessorImpl;

import java.io.*;

public class MainApp {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/com/boatingdock/doc/file_inputs.txt");
        BufferedReader r;
        r = new BufferedReader(new FileReader(file));
        BoatingDockInputProcessorImpl dockInputProcessor = new BoatingDockInputProcessorImpl();
        System.out.println(dockInputProcessor.process(r));
    }
}
