package ru.job4j.dream.servlet;

public class Email {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Email{"
                + "name='" + name + '\''
                + '}';
    }
}
