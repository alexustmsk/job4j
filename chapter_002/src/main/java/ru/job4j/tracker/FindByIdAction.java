package ru.job4j.tracker;

import ru.job4j.models.Item;

public class FindByIdAction implements UserAction {
    @Override
    public int key() {
        return 4;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявки по Id --------------");
        String id = input.ask("Введите Id заявки: ");
        Item found = tracker.findById(id);
        if (id != null) {
            System.out.println("Заявка с таким Id найдена:");
            System.out.println("Имя заявки: " + found.getName()
                    + " Описание заявки: " + found.getDescription());
        } else {
            System.out.println("Заявка с таким Id не найдена");
        }
    }

    @Override
    public String info() {
        return "Find the item (ID)";
    }
}
