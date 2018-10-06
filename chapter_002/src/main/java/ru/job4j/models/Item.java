package ru.job4j.models;

public class Item {
    private String id;

    public String name;

    public String description;

    public String comment;

    public long create;

    public Item() {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return description;
    }

    public long getCreate() {
        return create;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
