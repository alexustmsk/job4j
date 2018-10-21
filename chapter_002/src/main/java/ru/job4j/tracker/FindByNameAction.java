package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public int key() {
        return 5;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявки по Имени --------------");
        String name = input.ask("Введите Имя заявки: ");
        if (name != null) {
            System.out.println("Найдено кол-во заявок: " + tracker.findByName(name).length);
        } else {
            System.out.println("Заявка с таким Именем не найдена");
        }
    }

    @Override
    public String info() {
        return "Find the item (Name)";
    }
}
