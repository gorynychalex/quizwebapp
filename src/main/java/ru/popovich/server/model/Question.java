package ru.popovich.server.model;

import java.util.List;

public class Question {
    private int id;
    private String name;
    private List<String> options;

    public Question(int id, String name, List<String> options) {
        this.id=id;
        this.name = name;
        this.options = options;
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

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
