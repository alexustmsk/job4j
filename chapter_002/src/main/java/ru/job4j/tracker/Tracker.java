package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private Item[] items = new Items[100];

    /**
     * Указатель ячейки для новой заявки
     */
    private int position = 0;

    /**
     * Метод public Item add(Item) добавляет заявку, переданную в аргументах
     * в массив заявок this.items;
     * В методе add нужно проставить уникальный ключ в объект Item item.
     * Уникальный ключ нужно генерировать на основании времени и произвольного числа.
     * item.setId(this.generateId());
     * В качестве ключа нельзя использовать индекс.
     * @param item новая заявка
     */
    public Item add(Item item){
        item.setId(this.generateId());
        item.items[this.position++] = item;
        return item;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.curentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод public void replace(String id, Item item)
     * должен заменить ячейку в массиве this.items.
     * Для этого необходимо найти ячейку в массиве по id
     */
    public void replace(String id, Item item){

    }
    /**
     * Метод public void delete(String id) должен удалить ячейку в массиве this.items.
     * Для этого необходимо найти ячейку в массиве по id.  Далее сместить все значения
     * справа от удаляемого элемента - на одну ячейку влево с помощью System.arrayCopy();
     */
    public void delete(String id){

    }
    /**
     *	Метод public Item[] findAll() возвращает копию массива this.items без null элементов;
     */
    public Item[] findAll(){

    }
    /**
     * Метод public Item[] findByName(String key) проверяет в цикле все элементы массива this.items,
     * сравнивая name (используя метод getName класса Item) с аргументом метода String key.
     */
    public Item[] findByName(String key){

    }
    /**
     * Метод public Item findById(String id) проверяет в цикле все элементы массива this.items,
     * сравнивая id с аргументом String id и возвращает найденный Item. Если Item не найден - возвращает null.
     */
    public Item findById(String id){

    }
}
