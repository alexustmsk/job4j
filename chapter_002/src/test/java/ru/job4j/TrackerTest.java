package ru.job4j;

import org.junit.Test;
import ru.job4j.models.Item;
import ru.job4j.tracker.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void whenDeleteItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        Item item2 = new Item("test2", "testDescription", 123L);
        tracker.add(item2);
        Item item3 = new Item("test3", "testDescription", 123L);
        tracker.add(item3);

        tracker.delete(item.getId());
        assertThat(tracker.findAll()[1], is(item3));
    }

    @Test
    public void whenDeleteItemThenTrackerArrayAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test11", "testDescription", 123L);
        tracker.add(item1);
        Item item2 = new Item("test22", "testDescription", 123L);
        tracker.add(item2);
        Item item3 = new Item("test33", "testDescription", 123L);
        tracker.add(item3);

        tracker.delete(item3.getId());

        assertThat(tracker.findAll().length, is(3));
    }

    @Test
    public void whenFindByNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test11", "testDescription", 123L);
        tracker.add(item1);
        Item item2 = new Item("test22", "testDescription", 123L);
        tracker.add(item2);
        Item item3 = new Item("test33", "testDescription", 123L);
        tracker.add(item3);

        tracker.findByName("test22");
        // Проверяем, что происходит вызов метода
        assertThat(tracker.findByName("test22")[0].getDescription(), is("testDescription"));
    }
}
