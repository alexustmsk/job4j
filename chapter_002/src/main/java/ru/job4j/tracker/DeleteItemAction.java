package ru.job4j.tracker;

import ru.job4j.models.Item;

public class DeleteItemAction implements UserAction {
    @Override
    public int key() {
        return 3;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Удаление заявки --------------");
        String id = input.ask("Введите Id заявки: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Заявка с именем " + item.getId() + " будет удалена");
            String theConfir = input.ask("Подтверждаете удаление: y/n ");
            if (theConfir.equals("y")) {
                tracker.delete(id);
                System.out.println("Заявка с Id " + item.getId() + " удалена");
            }
        } else {
            System.out.println("Заявка с таким Id не найдена");
        }
    }

    @Override
    public String info() {
        return "Delete the item";
    }
}
