package ru.job4j.dream.model;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class Post {
    private int id;
    private String name;
    private String description;
    private final LocalDateTime created = LocalDateTime.now().truncatedTo(TimeUnit.MINUTES.toChronoUnit());

    public Post() { }

    public Post(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "Post{"
                + "id=" + id
                + ", name='" + name + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Post)) {
            return false;
        }

        Post post = (Post) o;

        if (id != post.id) {
            return false;
        }
        return name != null ? name.equals(post.name) : post.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}