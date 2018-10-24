package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private Input input;
    private Tracker tracker;

    public StartUI(Input input) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillAction();
        for (int i = 0; i < menu.getActionLentgh(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("Select: ", range));
        } while (!"y".equals(this.input.ask("Exit? (y/n)")));
    }

    //
////    private void exitProgram() {
////        System.out.println("------------ Выход из программы --------------");
////        String answer = this.input.ask("Подтверждаете выход из программы?: y/n ");
////        if (answer.equals("y")) {
////            exit = false;
////        }
////    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(new ConsoleInput()).init();
    }
}
