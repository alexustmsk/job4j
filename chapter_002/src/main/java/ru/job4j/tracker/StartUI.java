package ru.job4j.tracker;

import ru.job4j.models.*;

public class StartUI {

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для вывода всех заявок.
     */
    private static final String FINDALL = "1";
    /**
     * Константа меню для изменения заявок.
     */
    private static final String REPLACE = "2";
    /**
     * Константа меню для удаления заявок.
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для поиска по ID заявок.
     */
    private static final String FINDID = "4";
    /**
     * Константа меню для поиска по имени заявок.
     */
    private static final String FINDNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструктор инициализирующий поля.
     * @param input
     * @param tracker
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основной цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню: ");
            switch (answer) {
                case "0": createItem(); break;
                case "1": findAll(); break;
//                case "2": replaceItem(); break;
//                case "3": deleteItem(); break;
//                case "4": findById(); break;
//                case "5": findByName(); break;
//                case "6": exitProgram(); break;
            }
//            if (ADD.equals(answer)) {
//                // добавление заявки вынесено в отдельный метод.
//                this.createItem();
//            } else if (...){
//
//            } else if (EXIT.equals(answer)) {
//                exit = true;
//            }
        }

        String name = input.ask("Please, enter the tak's name:");

        Tracker tracker = new Tracker();
        tracker.add(new Task(name, "firs desc"));
        for (Item item : tracker.findAll()) {
            System.out.println(item.getName());
        }
    }

    /**
     * Метод реализует добовление новой заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки: ");
        String desc = this.input.ask("Введите описание заявки: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует вывод всех заявок
     */
    private void findAll(){
        System.out.println("------------ Заявки --------------");
        System.out.println("Всего заявок: " + this.tracker.findAll().length);
        for (int i = 0; i < this.tracker.findAll().length; i++) {
            System.out.println(i + 1 +". " + "Имя заявки: " + tracker.findAll()[i].getName() +" Описание: " + tracker.findAll()[i].getDescription());
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
    /**
     * Запуск программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

}
