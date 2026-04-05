package ru.aston.hometask.module04;

public class DeadlockExample {
    private static final Object RESOURCE_1 = new Object();
    private static final Object RESOURCE_2 = new Object();
    private static final int SLEEP_TIME = 100;

    public static void main(String[] args) {
        Thread threadOne = new Thread(() -> {
            synchronized (RESOURCE_1) {
                System.out.println("Поток 1: захватил RESOURCE_1");
                try {
                    Thread.sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                }
                System.out.println("Поток 1: ожидает RESOURCE_2");
                synchronized (RESOURCE_2) {
                    System.out.println("Поток 1: захватил RESOURCE_2");
                }
            }
        });

        Thread threadTwo = new Thread(() -> {
            synchronized (RESOURCE_2) {
                System.out.println("Поток 2: захватил RESOURCE_2");
                try {
                    Thread.sleep(SLEEP_TIME);
                } catch (InterruptedException e) {}
                System.out.println("Поток 2: ожидает RESOURCE_1");
                synchronized (RESOURCE_1) {
                    System.out.println("Поток 2: захватил RESOURCE_1");
                }
            }
        });

        threadOne.start();
        threadTwo.start();
    }
}
