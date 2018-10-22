package ru.job4j.tracker;

import ru.job4j.models.Item;
import ru.job4j.models.Task;

import java.util.ArrayList;
import java.util.List;

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
        this.actions.add(new AddItem(0, "Add program"));
        this.actions.add(new ShowItem(1, "Show all items"));
        this.actions.add(new MenuTracker.EditItem(2, "Edit item"));
        this.actions.add(new MenuTracker.DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));
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

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<Integer>();
        menu.fillAction();
        for (int i = 0; i < menu.getActionLentgh(); i++) {
            range.add(i);
        }
//        do {
//            menu.show();
//            menu.select(input.ask("Select: ", range));
//        } while(!"y".equals(this.input.ask("Exit? (y/n)")));
    }

    private static class AddItem implements UserAction {
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
