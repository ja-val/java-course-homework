package ru.aston.hometask.module04;

import java.util.concurrent.atomic.AtomicBoolean;

public class LivelockExample {
    private static final AtomicBoolean flagOne = new AtomicBoolean(true);
    private static final AtomicBoolean flagTwo = new AtomicBoolean(false);
    private static final int PAUSE_SLEEP = 10;

    public static void main(String[] args) {
        Thread workerOne = new Thread(() -> {
            while (true) {
                while (!flagOne.get()) {}
                System.out.println("Воркер 1: хочу работать, но вижу, что Воркер 2 тоже хочет работать)");
                flagOne.set(false);
                flagTwo.set(true);
                try {
                    Thread.sleep(PAUSE_SLEEP);
                } catch (InterruptedException e) {}
            }
        });

        Thread workerTwo = new Thread(() -> {
            while (true) {
                while (!flagTwo.get()) {}
                System.out.println("Воркер 2: хочу работать, но вижу, что Воркер 1 тоже хочет работать)");
                flagTwo.set(false);
                flagOne.set(true);
                try {
                    Thread.sleep(PAUSE_SLEEP);
                } catch (InterruptedException e) {}
            }
        });

        workerOne.start();
        workerTwo.start();
    }
}
