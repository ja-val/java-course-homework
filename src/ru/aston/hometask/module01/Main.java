package ru.aston.hometask.module01;

public class Main {
    static void main(String[] args) {
        MutableClass mutable = new MutableClass(33, "Expedition");
        ImmutableClass immutable = new ImmutableClass("Gustave", mutable);

        System.out.println("После создания:");
        System.out.println("   ImmutableClass: " + immutable);
        System.out.println("   MutableClass: " + mutable);

        mutable.setNum(0);
        mutable.setStr("Clair Obscur");

        System.out.println("После изменения изменяемого класса:");
        System.out.println("   ImmutableClass: " + immutable);
        System.out.println("   MutableClass: " + mutable);

        MutableClass newMutable = immutable.getMutableClass();
        newMutable.setNum(2025);
        newMutable.setStr("Goty");

        System.out.println("После изменения через геттер:");
        System.out.println("   ImmutableClass: " + immutable);
        System.out.println("   NewMutable: " + newMutable);
    }
}
