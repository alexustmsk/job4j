package ru.job4j.tracker;

import ru.job4j.models.Item;

public class FindAllAction implements UserAction {
    @Override
    public int key() {
        return 1;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Все заявки --------------");
        Item[] thisTrackerFindAll = tracker.findAll();
        System.out.println("Всего заявок: " + tracker.findAll().length);
        for (int i = 0; i < thisTrackerFindAll.length; i++) {
            System.out.println("Id заявки: " + thisTrackerFindAll[i].getId()
                    + " Имя заявки: " + thisTrackerFindAll[i].getName()
                    + " Описание: " + thisTrackerFindAll[i].getDescription());
        }
    }

    @Override
    public String info() {
        return "Show all items";
    }
}
