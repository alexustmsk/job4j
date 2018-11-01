package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private Input input;

    public StartUI(Input input) {
        this.input = input;
    }

    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillAction();
        for (int i = 0; i < menu.getActionLength(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("Select: ", range));
        } while (!"y".equals(this.input.ask("Exit? (y/n)")));
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput()).init();
    }
}
