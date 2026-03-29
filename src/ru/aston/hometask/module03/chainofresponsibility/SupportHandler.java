package ru.aston.hometask.module03.chainofresponsibility;

public abstract class SupportHandler {
    protected SupportHandler next;

    protected static final int LEVEL_EASY = 1;
    protected static final int LEVEL_MEDIUM = 2;
    protected static final int LEVEL_HARD = 3;
    protected static final int LEVEL_VERY_HARD = 4;
    protected static final int LEVEL_IMPOSSIBLE = 5;

    public void setNext(SupportHandler next) {
        this.next = next;
    }

    public abstract void handleRequest(String issue, int severity);
}
