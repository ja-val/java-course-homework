package ru.aston.hometask.module03.builder;

public class Computer {
    private final String cpu;
    private final int ram;
    private final int storage;
    private final String gpu;
    private final boolean bluetooth;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.bluetooth = builder.bluetooth;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + cpu + '\'' +
                ", RAM=" + ram +
                ", Storage=" + storage +
                ", GPU='" + gpu + '\'' +
                ", Bluetooth=" + bluetooth +
                '}';
    }

    public static class Builder {
        private String cpu;
        private int ram;
        private int storage;
        private String gpu;
        private boolean bluetooth;

        public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder setBluetooth(boolean bluetooth) {
            this.bluetooth = bluetooth;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
