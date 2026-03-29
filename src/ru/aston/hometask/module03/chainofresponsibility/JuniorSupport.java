package ru.aston.hometask.module03.chainofresponsibility;

public class JuniorSupport extends SupportHandler {
    private static final int MAX_LEVEL = 2;

    @Override
    public void handleRequest(String issue, int severity) {
        if (severity <= MAX_LEVEL) {
            System.out.printf("Джун из поддержки решил проблему: %s.\n", issue);
        } else if (next != null) {
            next.handleRequest(issue, severity);
        }
    }
}
