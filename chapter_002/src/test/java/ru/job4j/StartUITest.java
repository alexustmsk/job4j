package ru.job4j;

import org.junit.Test;
import ru.job4j.models.Item;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.StartUI;
import ru.job4j.tracker.StubInput;
import ru.job4j.tracker.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenUserAddItem() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6", "y"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateItem() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6", "y"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test name1", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "y", "6", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(1));
    }

    @Test
    public void whenFindIdItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test name1", "desc"));
        String id = item.getId();
        System.out.println(id);
        Input input = new StubInput(new String[]{"4", id,"6", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(id).getName(), is("test name"));
    }

    @Test
    public void whenFindNameItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc1"));
        Item item2 = tracker.add(new Item("test name", "desc2"));
        Item item3 = tracker.add(new Item("test name", "desc2"));
        Input input = new StubInput(new String[]{"5", item.getName(), "test name","6", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName("test name").length, is(3));
    }

}
