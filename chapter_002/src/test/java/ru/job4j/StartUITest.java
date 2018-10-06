package ru.job4j;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.StartUI;
import ru.job4j.tracker.StubInput;

public class StartUITest {

    public static void main(String[] args) {
        Input input = new StubInput(new String[] {"create stub task"});
        new StartUI(input).init();
    }
}
