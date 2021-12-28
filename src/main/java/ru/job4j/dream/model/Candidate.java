package ru.job4j.dream.model;

import java.util.Objects;

public class Candidate {
    private String name;
    private int id;

    public Candidate(int id, String name) {
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
        if (!(o instanceof Candidate candidate)) {
            return false;
        }
        return id == candidate.id && Objects.equals(name, candidate.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}