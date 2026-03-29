package ru.aston.hometask.module03.proxy;

public class Main {
    public static void main(String[] args) {
        Database userDb = new DatabaseProxy("USER");
        userDb.query("SELECT * FROM users");
        userDb.query("DROP TABLE users"); // Запрещено

        Database adminDb = new DatabaseProxy("ADMIN");
        adminDb.query("DROP TABLE users"); // Разрешено
        adminDb.query("SELECT * FROM users");
        adminDb.query("SELECT * FROM users"); // Из кэша
    }
}
