package ru.aston.hometask.module04;

import java.util.concurrent.Semaphore;

public class AlternatePrinter {
    private static final int INITIAL_PERMITS_THREAD_ONE = 1;
    private static final int INITIAL_PERMITS_THREAD_TWO = 0;

    private static final Semaphore semaphoreOne = new Semaphore(INITIAL_PERMITS_THREAD_ONE);
    private static final Semaphore semaphoreTwo = new Semaphore(INITIAL_PERMITS_THREAD_TWO);

    public static void main(String[] args) {
        Thread threadOne = new Thread(() -> {
            while (true) {
                try {
                    semaphoreOne.acquire();
                } catch (InterruptedException e) {}
                System.out.print("1 ");
                semaphoreTwo.release();
            }
        });

        Thread threadTwo = new Thread(() -> {
            while (true) {
                try {
                    semaphoreTwo.acquire();
                } catch (InterruptedException e) {}
                System.out.print("2 ");
                semaphoreOne.release();
            }
        });

        threadOne.start();
        threadTwo.start();
    }

}
