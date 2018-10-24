package ru.job4j.tracker;

import ru.job4j.models.Item;
import ru.job4j.models.Task;

import java.util.ArrayList;
import java.util.List;

class EditItems implements UserAction {
    public EditItems(int i, String nameMenu) {
    }

    public int key() {
        return 2;
    }

    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Редактирование заявки --------------");
        String id = input.ask("Введите Id заявки: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Заявка с именем " + item.getId() + " будет изменена");
            String name = input.ask("Введите имя новой заявки: ");
            String desc = input.ask("Введите описание новой заявки: ");
            Item newItem = new Item(name, desc);
            tracker.replace(id, newItem);
            System.out.println(" Заявка с Id изменена");
        } else {
            System.out.println("Заявка с таким Id не найдена");
        }
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Edit the new item.");
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

    public int getActionLentgh() {
        return this.actions.size();
    }

    public void fillAction() {
        System.out.println("Menu: ");
        this.actions.add(this.new AddItem(0, "Add program"));
        this.actions.add(new MenuTracker.ShowItem(1, "Show all items"));
        this.actions.add(new EditItems(2, "Edit item"));
//        this.actions.add(new DeleteItem(3, "Delete item"));
//        this.actions.add(new FindItemById(4, "Find item by Id"));
//        this.actions.add(new FindItemsByName(5, "Find items by name"));
//        this.actions.add(new ExitProgram(6, "Exit Program"));
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

    private class AddItem implements UserAction {
        public AddItem(int i, String nameMenu) {
        }

        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name: ");
            String desc = input.ask("Please, enter the task's desc: ");
            tracker.add(new Task(name, desc));
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item.");
        }
    }

    private static class ShowItem implements UserAction {
        public ShowItem(int i, String nameMenu) {
        }

        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println(String.format("%s. %s", item.getId(), item.getName()));
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Show all item.");
        }
    }


}
