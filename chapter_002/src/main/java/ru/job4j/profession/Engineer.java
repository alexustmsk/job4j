package ru.job4j.profession;

public class Engineer extends Profession {
    public Engineer(String name) {
        super(name);
    }
    public Civil civilHouse(House house) {
        return new Civil();
    }
}
