package ru.aston.hometask.module03.builder;

public class Main {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder()
                .setCpu("Intel i9")
                .setRam(32)
                .setStorage(1000)
                .setGpu("RTX 4070 Super")
                .setBluetooth(true)
                .build();

        Computer officePC = new Computer.Builder()
                .setCpu("Intel i5")
                .setRam(16)
                .setStorage(512)
                .build();

        System.out.println(gamingPC);
        System.out.println(officePC);
    }
}
