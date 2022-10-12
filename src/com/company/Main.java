package com.company;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    static BlockingQueue<String> queueCheckA = new ArrayBlockingQueue<>(100);
    static BlockingQueue<String> queueCheckB = new ArrayBlockingQueue<>(100);
    static BlockingQueue<String> queueCheckC = new ArrayBlockingQueue<>(100);

    public static void main(String[] args) {

//        поток, добавляющий строку в очереди
        Thread filler = new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                try {
                    String text = Generator.generateText("abc", 100_000);
                    queueCheckA.put(text);
                    queueCheckB.put(text);
                    queueCheckC.put(text);
                } catch (InterruptedException exception) {
                    return;
                }
            }
        });

        filler.start();

        new Thread(() -> Checker.checkLetter('a', queueCheckA)).start();
        new Thread(() -> Checker.checkLetter('b', queueCheckB)).start();
        new Thread(() -> Checker.checkLetter('c', queueCheckC)).start();
    }
}
