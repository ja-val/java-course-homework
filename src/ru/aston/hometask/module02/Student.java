package ru.aston.hometask.module02;

import java.util.List;

public class Student {
    private String name;
    private String surname;
    private int age;
    private List<Book> books;

    public Student(String name, String surname, int age, List<Book> books) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return String.format("Student: %s %s, age: %d, books: %d",
                name, surname, age, books.size());
    }
}
