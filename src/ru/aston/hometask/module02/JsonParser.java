package ru.aston.hometask.module02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public static List<Student> readStudentsFromJsonFile(String filename) {
        List<Student> students = new ArrayList<>();

        try {
            String content = new String(Files.readAllBytes(Paths.get(filename)));
            content = content.trim();

            if (content.startsWith("[") && content.endsWith("]")) {
                content = content.substring(1, content.length() - 1);
            }

            List<String> studentJsons = splitJsonObjects(content);

            for (String studentJson : studentJsons) {
                Student student = parseStudent(studentJson);
                if (student != null) {
                    students.add(student);
                }
            }

            System.out.println("Успешно загружено студентов: " + students.size());
            return students;

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            return null;
        }
    }

    private static List<String> splitJsonObjects(String content) {
        List<String> objects = new ArrayList<>();
        int braceCount = 0;
        int start = 0;
        boolean inString = false;

        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);

            if (c == '"' && (i == 0 || content.charAt(i - 1) != '\\')) {
                inString = !inString;
            }

            if (!inString) {
                if (c == '{') {
                    if (braceCount == 0) {
                        start = i;
                    }
                    braceCount++;
                } else if (c == '}') {
                    braceCount--;
                    if (braceCount == 0) {
                        objects.add(content.substring(start, i + 1));
                    }
                }
            }
        }

        return objects;
    }

    private static Student parseStudent(String json) {
        try {
            String name = extractStringValue(json, "name");
            String surname = extractStringValue(json, "surname");
            int age = extractIntValue(json, "age");

            String booksArray = extractArray(json, "books");
            List<Book> books = parseBooks(booksArray);

            return new Student(name, surname, age, books);

        } catch (Exception e) {
            System.err.println("Ошибка парсинга студента: " + e.getMessage());
            return null;
        }
    }

    private static List<Book> parseBooks(String booksArray) {
        List<Book> books = new ArrayList<>();

        if (booksArray == null || booksArray.isEmpty()) {
            return books;
        }

        String content = booksArray.trim();
        if (content.startsWith("[") && content.endsWith("]")) {
            content = content.substring(1, content.length() - 1);
        }

        if (content.trim().isEmpty()) {
            return books;
        }

        List<String> bookJsons = splitJsonObjects(content);

        for (String bookJson : bookJsons) {
            String title = extractStringValue(bookJson, "title");
            String author = extractStringValue(bookJson, "author");
            int pages = extractIntValue(bookJson, "pages");
            int year = extractIntValue(bookJson, "year");

            books.add(new Book(title, author, pages, year));
        }

        return books;
    }

    private static String extractStringValue(String json, String key) {
        String searchKey = "\"" + key + "\":";
        int keyIndex = json.indexOf(searchKey);
        if (keyIndex == -1) {
            return "";
        }

        int start = keyIndex + searchKey.length();
        while (start < json.length() && Character.isWhitespace(json.charAt(start))) {
            start++;
        }

        if (start >= json.length() || json.charAt(start) != '"') {
            return "";
        }

        int end = start + 1;
        while (end < json.length() && json.charAt(end) != '"') {
            if (json.charAt(end) == '\\') {
                end++;
            }
            end++;
        }

        return json.substring(start + 1, end);
    }

    private static int extractIntValue(String json, String key) {
        String searchKey = "\"" + key + "\":";
        int keyIndex = json.indexOf(searchKey);
        if (keyIndex == -1) {
            return 0;
        }

        int start = keyIndex + searchKey.length();
        while (start < json.length() && Character.isWhitespace(json.charAt(start))) {
            start++;
        }

        int end = start;
        while (end < json.length() &&
                (Character.isDigit(json.charAt(end)) || json.charAt(end) == '-')) {
            end++;
        }

        String numberStr = json.substring(start, end);

        try {
            return Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static String extractArray(String json, String key) {
        String searchKey = "\"" + key + "\":";
        int start = json.indexOf(searchKey);
        if (start == -1) {
            return "";
        }

        start = start + searchKey.length();

        while (start < json.length() && Character.isWhitespace(json.charAt(start))) {
            start++;
        }

        if (start >= json.length() || json.charAt(start) != '[') {
            return "";
        }

        int braceCount = 0;
        int end = start;
        boolean inString = false;

        while (end < json.length()) {
            char c = json.charAt(end);

            if (c == '"' && (end == start || json.charAt(end - 1) != '\\')) {
                inString = !inString;
            }

            if (!inString) {
                if (c == '[') {
                    braceCount++;
                } else if (c == ']') {
                    braceCount--;
                    if (braceCount == 0) {
                        return json.substring(start, end + 1);
                    }
                }
            }
            end++;
        }

        return "";
    }
}
