package ru.aston.hometask.module01;

public class ImmutableClass {
    private final String text;
    private final MutableClass mutableClass;

    public ImmutableClass(String text, MutableClass mutableClass) {
        this.text = text;
        this.mutableClass = mutableClass.clone();
    }

    public String getText() {
        return text;
    }

    public MutableClass getMutableClass() {
        return mutableClass.clone();
    }

    @Override
    public String toString() {
        return "ImmutableClass{text='" + text + "', mutable=" + mutableClass + "}";
    }
}
