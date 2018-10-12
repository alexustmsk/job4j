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
                case "2": replaceItem(); break;
                case "3": deleteItem(); break;
                case "4": findById(); break;
                case "5": findByName(); break;
                case "6": exitProgram(); break;
                    default: break;
            }
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
    private void findAll() {
        System.out.println("------------ Все заявки --------------");
        System.out.println("Всего заявок: " + this.tracker.findAll().length);
        for (int i = 0; i < this.tracker.findAll().length; i++) {
            System.out.println(i + 1 + ". " + "Id заявки: " + tracker.findAll()[i].getId() + " Имя заявки: " + tracker.findAll()[i].getName() + " Описание: " + tracker.findAll()[i].getDescription());
        }
    }

    /**
     * Метод реализует замену заявки
     */
    private void replaceItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите Id заявки: ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("Заявка с именем " + item.getId() + " будет изменена");
            String name = this.input.ask("Введите имя новой заявки: ");
            String desc = this.input.ask("Введите описание новой заявки: ");
            Item newItem = new Item(name, desc);
            newItem.setId(item.getId());
            this.tracker.replace(id, newItem);
            System.out.println(" Заявка с Id изменена");
        } else {
            System.out.println("Заявка с таким Id не найдена");
        }
    }

    /**
     * Метод реализует удаление заявки
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите Id заявки: ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("Заявка с именем " + item.getId() + " будет удалена");
            String pp = this.input.ask("Подтверждаете удаление: y/n ");
            if (pp.equals("y")) {
                this.tracker.delete(id);
                System.out.println("Заявка с Id " + item.getId() + " удалена");
            }
        } else {
            System.out.println("Заявка с таким Id не найдена");
        }
    }

    /**
     * Метод реализует поиск заявки по Id
     */
    private void findById() {
        System.out.println("------------ Поиск заявки по Id --------------");
        String id = this.input.ask("Введите Id заявки: ");
        if (id != null) {
            System.out.println("Заявка с таким Id найдена:");
            System.out.println("Имя заявки: " + this.tracker.findById(id).getName() + " Описание заявки: " + this.tracker.findById(id).getDescription());
        } else {
            System.out.println("Заявка с таким Id не найдена");
        }
    }

    /**
     * Метод реализует поиск заявки по Имени
     */
    private void findByName() {
        System.out.println("------------ Поиск заявки по Имени --------------");
        String name = this.input.ask("Введите Имя заявки: ");
        if (name != null) {
            System.out.println("Найдено кол-во заявок: " + this.tracker.findByName(name).length);
        } else {
            System.out.println("Заявка с таким Именем не найдена");
        }
    }

    /**
     * Метод реализует выход из программы
     */
    private void exitProgram() {
        System.out.println("------------ Выход из программы --------------");
        String answer = this.input.ask("Подтверждаете выход из программы?: y/n ");
        if (answer.equals("y")) {
                System.exit(0);
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
