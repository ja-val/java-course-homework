package ru.aston.hometask.module03.chainofresponsibility;

public class SeniorSupport extends SupportHandler {
    private static final int MAX_LEVEL = 4;

    @Override
    public void handleRequest(String issue, int severity) {
        if (severity <= MAX_LEVEL) {
            System.out.printf("Сеньор из поддержки решил проблему: %s.\n", issue);
        } else if (next != null) {
            next.handleRequest(issue, severity);
        }
    }
}
