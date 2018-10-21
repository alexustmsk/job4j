package ru.job4j.tracker;

import ru.job4j.models.*;

import java.util.ArrayList;
import java.util.List;

public class StartUI {

    private static final String ADD = "0";
    private static final String FINDALL = "1";
    private static final String REPLACE = "2";
    private static final String DELETE = "3";
    private static final String FINDID = "4";
    private static final String FINDNAME = "5";
    private static final String EXIT = "6";

    private Input input;
    private Tracker tracker;

    public StartUI(Input input) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<Integer>();
        menu.fillAction();
        for (int i = 0; i < menu.getActionLentgh(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("Select: ", range));
        } while(!"y".equals(this.input.ask("Exit? (y/n)")));
    }

//    private void exitProgram() {
//        System.out.println("------------ Выход из программы --------------");
//        String answer = this.input.ask("Подтверждаете выход из программы?: y/n ");
//        if (answer.equals("y")) {
//            exit = false;
//        }
//    }

    private void showMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add new Item");
        System.out.println("2. Show all items");
        System.out.println("3. Edit item");
        System.out.println("4. Delete item");
        System.out.println("5. Find item by Id");
        System.out.println("6. Find items by name");
        System.out.println("7. Exit Program");
        System.out.println();
        System.out.println("Select:");
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput()).init();
    }

}
