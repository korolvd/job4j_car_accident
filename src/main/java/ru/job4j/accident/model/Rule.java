package ru.job4j.accident.model;

public class Rule {
    private int id;
    private String name;

    public Rule() {
    }

    public Rule(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Rule of(int id, String name) {
        Rule rule = new Rule();
        rule.id = id;
        rule.name = name;
        return rule;
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
}
