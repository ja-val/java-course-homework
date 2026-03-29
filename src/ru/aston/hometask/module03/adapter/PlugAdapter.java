package ru.aston.hometask.module03.adapter;

public class PlugAdapter implements USPlug {
    private final EuropeanPlug europeanPlug;

    public PlugAdapter(EuropeanPlug europeanPlug) {
        this.europeanPlug = europeanPlug;
    }

    @Override
    public void connectToUSSocket() {
        System.out.println("Адаптер преобразует американскую розетку в европейскую");
        europeanPlug.connectToEuropeanSocket();
    }
}
