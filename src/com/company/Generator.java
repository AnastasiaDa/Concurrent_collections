package com.company;

import java.util.Random;

public class Generator {

    String letters;
    int length;

    public Generator(String letters, int length) {
        this.letters = letters;
        this.length = length;
    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }
}
