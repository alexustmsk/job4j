package ru.job4j.tracker;

import ru.job4j.models.Item;

import java.util.ArrayList;
import java.util.List;

class EditItems extends BaseAction {

    public EditItems(int key, String name) {
        super(key, name);
    }

    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Редактирование заявки --------------");
        String id = input.ask("Введите Id заявки: ");
        Item item = tracker.findById(id);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка с именем " + id + " будет изменена");
            String name = input.ask("Введите имя новой заявки: ");
            String desc = input.ask("Введите описание новой заявки: ");
            Item newItem = new Item(name, desc);
            tracker.replace(id, newItem);
            System.out.println(" Заявка с Id изменена");
        } else {
            System.out.println("Заявка с таким Id не найдена");
        }
    }
}

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public int getActionLength() {
        return this.actions.size();
    }

    public void fillAction() {
        System.out.println("Menu: ");
        this.actions.add(this.new AddItem(0, "Add new Item"));
        this.actions.add(new MenuTracker.ShowItem(1, "Show all item."));
        this.actions.add(new EditItems(2, "Edit the new item."));
        this.actions.add(new DeleteItemAction(3, "Delete the item."));
        this.actions.add(new FindByIdAction(4, "Find the item (ID)."));
        this.actions.add(new FindByNameAction(5, "Find the item (Name)."));

    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки: ");
            String desc = input.ask("Введите описание заявки: ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }
    }

    private static class ShowItem extends BaseAction {

        public ShowItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Все заявки --------------");
            Item[] thisTrackerFindAll = tracker.findAll();

            System.out.println("Всего заявок: " + tracker.findAll().length);
            for (int i = 0; i < thisTrackerFindAll.length; i++) {
                System.out.println(String.format("Id заявки: %s Имя заявки: %s Описание: %s",
                        thisTrackerFindAll[i].getId(), thisTrackerFindAll[i].getName(), thisTrackerFindAll[i].getDescription()));
            }
        }
    }

    public class DeleteItemAction extends BaseAction {

        public DeleteItemAction(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите Id заявки: ");
            if (tracker.delete(id)) {
                tracker.delete(id);
                System.out.println("Заявка с Id " + id + " удалена");
            } else {
                System.out.println("Заявка с таким Id не найдена");
            }
        }
    }

    public class FindByIdAction extends BaseAction {

        public FindByIdAction(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по Id --------------");
            String id = input.ask("Введите Id заявки: ");
            Item found = tracker.findById(id);
            if (found != null) {
                System.out.println("Заявка с таким Id найдена:");
                System.out.println("Имя заявки: " + found.getName()
                        + " Описание заявки: " + found.getDescription());
            } else {
                System.out.println("Заявка с таким Id не найдена");
            }
        }
    }

    public class FindByNameAction extends BaseAction {

        public FindByNameAction(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по Имени --------------");
            String name = input.ask("Введите Имя заявки: ");
            Item[] items = tracker.findByName(name);
                if (tracker.findByName(name).length != 0) {
                    System.out.println("Найдено кол-во заявок: " + items.length);
                    for (int i = 0; i < items.length; i++) {
                        System.out.println(String.format("%s. Имя заявки: %s Описание: %s",
                                i + 1, items[i].getName(), items[i].getDescription()));
                    }
            } else {
                System.out.println("Заявка с таким Именем не найдена");
            }
        }
    }
}
