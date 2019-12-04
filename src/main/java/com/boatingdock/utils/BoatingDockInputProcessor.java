package com.boatingdock.utils;

import java.io.BufferedReader;
import java.io.IOException;

public interface BoatingDockInputProcessor {

    public String process(BufferedReader bufferedReader) throws IOException;
}
