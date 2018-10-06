package ru.job4j.tracker;

import ru.job4j.models.*;

public class StartUI {

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Task("first task", "firs desc"));
        for (Item item : tracker.findAll()) {
            System.out.println(item.getName());
        }
    }
}
