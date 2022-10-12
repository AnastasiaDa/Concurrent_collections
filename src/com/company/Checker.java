package com.company;

import java.util.concurrent.BlockingQueue;

public class Checker {

    public static void checkLetter(Character letter, BlockingQueue<String> queueChecker) {
        long counter = 0;
        for (int i = 0; i < 10_000; i++) {
            try {
                String word = queueChecker.take();
                for (int j = 0; j < word.length(); j++) {
                    if (word.charAt(j) == letter) {
                        counter++;
                    }
                }
            } catch (InterruptedException e) {
                return;
            }
        }
        System.out.println("The letter " + letter + " occurs " + counter + " times");
    }
}
