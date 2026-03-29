package ru.aston.hometask.module03.adapter;

public class Main {
    static void main(String[] args) {
        EuropeanPlug euroPlug = new EuropeanPlug();
        USPlug adapter = new PlugAdapter(euroPlug);
        adapter.connectToUSSocket();
    }
}
