//package ru.job4j.tracker;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import ru.job4j.models.Item;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import java.util.StringJoiner;
//
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.assertThat;
//
//public class StartUITest {
//    private final PrintStream stdout = System.out;
//    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
//    private final Tracker tracker = new Tracker();
//    private final String menu = new StringJoiner(System.lineSeparator())
//            .add("Меню.")
//            .add("0. Add new Item")
//            .add("1. Show all items")
//            .add("2. Edit item")
//            .add("3. Delete item")
//            .add("4. Find item by Id")
//            .add("5. Find items by name")
//            .add("6. Exit Program")
//            .add("Select:")
//            .toString();
//
//    @Before
//    public void newTracker() {
//        System.out.println("execute before method");
//        new Tracker();
//        System.setOut(new PrintStream(this.out));
//    }
//
//    @After
//    public void backOutput() {
//        System.setOut(this.stdout);
//        System.out.println("execute after method");
//    }
//
//    @Test
//    public void whenUserAddItem() {
//        Input input = new StubInput(new String[]{"0", "test name", "desc", "6", "y"});
//        new StartUI(input, tracker).init();
//        assertThat(tracker.findAll()[0].getName(), is("test name"));
//    }
//
//    @Test
//    public void whenUpdateItem() {
//        Item item = tracker.add(new Item("test name", "desc"));
//        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6", "y"});
//        new StartUI(input, tracker).init();
//        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
//    }
//
//    @Test
//    public void whenDeleteItem() {
//        Item item = tracker.add(new Item("test name", "desc"));
//        Item item2 = tracker.add(new Item("test name1", "desc"));
//        Input input = new StubInput(new String[]{"3", item.getId(), "y", "6", "y"});
//        new StartUI(input, tracker).init();
//        assertThat(tracker.findAll().length, is(1));
//    }
//
//    @Test
//    public void whenFindIdItem() {
//        Item item = tracker.add(new Item("test name", "desc"));
//        Item item2 = tracker.add(new Item("test name1", "desc"));
//        String id = item.getId();
//        System.out.println(id);
//        Input input = new StubInput(new String[]{"4", id, "6", "y"});
//        new StartUI(input, tracker).init();
//        assertThat(tracker.findById(id).getName(), is("test name"));
//    }
//
//    @Test
//    public void whenFindNameItem() {
//        Item item = tracker.add(new Item("test name", "desc1"));
//        Item item2 = tracker.add(new Item("test name", "desc2"));
//        Item item3 = tracker.add(new Item("test name", "desc2"));
//        Input input = new StubInput(new String[]{"5", item.getName(), "test name", "6", "y"});
//        new StartUI(input, tracker).init();
//        assertThat(tracker.findByName("test name").length, is(3));
//    }
//
//    @Test
//    public void whenShowAllItem() {
//        Item item1 = tracker.add(new Item("test name1", "desc1"));
//        Input input = new StubInput(new String[]{"1", "6", "y"});
//        new StartUI(input, tracker).init();
//        assertThat(new String(out.toByteArray()), is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
//                .add(menu)
//                .add("------------ Все заявки --------------")
//                .add("Всего заявок: 1")
//                .add("1. " + " Имя заявки: test name1 Описание: desc1")
//                .add(menu)
//                .add("------------ Выход из программы --------------")
//                .toString()
//        ));
//    }
//
//    @Test
//    public void whenReplaceItem() {
//        Item item1 = tracker.add(new Item("test name1", "desc1"));
//        Input input = new StubInput(new String[]{"2", item1.getId(), "test replace", "заменили заявку", "6", "y"});
//        new StartUI(input, tracker).init();
//        assertThat(new String(out.toByteArray()), is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
//                .add(menu)
//                .add("------------ Редактирование заявки --------------")
//                .add("Заявка с именем " + item1.getId() + " будет изменена")
//                .add(" Заявка с Id изменена")
//                .add(menu)
//                .add("------------ Выход из программы --------------")
//                .toString()
//        ));
//    }
//}
