package ru.job4j.tracker;


import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, List<Integer> range) {
        boolean exit = false;
        int key = Integer.valueOf(this.ask(question));
        for (int value : range) {
            if (value == key) {
                exit = true;
                break;
            }
        }
        return key;
    }
}
