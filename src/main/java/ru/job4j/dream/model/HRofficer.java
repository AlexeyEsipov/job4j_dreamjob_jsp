package ru.job4j.dream.model;

import java.util.Objects;

public class HRofficer {
    private String name;
    private int id;

    public HRofficer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HRofficer hRofficer = (HRofficer) o;
        return id == hRofficer.id && Objects.equals(name, hRofficer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}