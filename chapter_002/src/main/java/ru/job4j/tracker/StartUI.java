package ru.job4j.tracker;

import ru.job4j.models.*;

public class StartUI {

    private static final String ADD = "0";
    private static final String FINDALL = "1";
    private static final String REPLACE = "2";
    private static final String DELETE = "3";
    private static final String FINDID = "4";
    private static final String FINDNAME = "5";
    private static final String EXIT = "6";

    private final Input input;
    private final Tracker tracker;
    private boolean exit = true;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        while (exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню: ");
            switch (answer) {
                case ADD:
                    createItem();
                    break;
                case FINDALL:
                    findAll();
                    break;
                case REPLACE:
                    replaceItem();
                    break;
                case DELETE:
                    deleteItem();
                    break;
                case FINDID:
                    findById();
                    break;
                case FINDNAME:
                    findByName();
                    break;
                case EXIT:
                    exitProgram();
                    break;
                default:
                    break;
            }
        }
    }

    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки: ");
        String desc = this.input.ask("Введите описание заявки: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void findAll() {
        System.out.println("------------ Все заявки --------------");
        Item[] thisTrackerFindAll = this.tracker.findAll();
        System.out.println("Всего заявок: " + this.tracker.findAll().length);
        for (int i = 0; i < thisTrackerFindAll.length; i++) {
            System.out.println(i + 1 + ". " + "Id заявки: " + thisTrackerFindAll[i].getId()
                    + " Имя заявки: " + thisTrackerFindAll[i].getName()
                                + " Описание: " + thisTrackerFindAll[i].getDescription());
        }
    }

    private void replaceItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите Id заявки: ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("Заявка с именем " + item.getId() + " будет изменена");
            String name = this.input.ask("Введите имя новой заявки: ");
            String desc = this.input.ask("Введите описание новой заявки: ");
            Item newItem = new Item(name, desc);
            this.tracker.replace(id, newItem);
            System.out.println(" Заявка с Id изменена");
        } else {
            System.out.println("Заявка с таким Id не найдена");
        }
    }

    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите Id заявки: ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("Заявка с именем " + item.getId() + " будет удалена");
            String theConfir = this.input.ask("Подтверждаете удаление: y/n ");
            if (theConfir.equals("y")) {
                this.tracker.delete(id);
                System.out.println("Заявка с Id " + item.getId() + " удалена");
            }
        } else {
            System.out.println("Заявка с таким Id не найдена");
        }
    }

    private void findById() {
        System.out.println("------------ Поиск заявки по Id --------------");
        String id = this.input.ask("Введите Id заявки: ");
        Item found = this.tracker.findById(id);
        if (id != null) {
            System.out.println("Заявка с таким Id найдена:");
            System.out.println("Имя заявки: " + found.getName()
                    + " Описание заявки: " + found.getDescription());
        } else {
            System.out.println("Заявка с таким Id не найдена");
        }
    }

    private void findByName() {
        System.out.println("------------ Поиск заявки по Имени --------------");
        String name = this.input.ask("Введите Имя заявки: ");
        if (name != null) {
            System.out.println("Найдено кол-во заявок: " + this.tracker.findByName(name).length);
        } else {
            System.out.println("Заявка с таким Именем не найдена");
        }
    }

    private void exitProgram() {
        System.out.println("------------ Выход из программы --------------");
        String answer = this.input.ask("Подтверждаете выход из программы?: y/n ");
        if (answer.equals("y")) {
            exit = false;
        }
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select:");
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

}
