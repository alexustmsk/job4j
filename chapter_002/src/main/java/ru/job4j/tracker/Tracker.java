package ru.job4j.tracker;

import ru.job4j.models.*;

import java.util.Arrays;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public boolean replace(String id, Item item) {
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                this.items[index] = item;
                item.setId(id);
                return true;
            }
        }
        return false;
    }

    public boolean delete(String id) {
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                System.arraycopy(items, index + 1, items, index, items.length - index - 1);
                position--;
                return true;
            }
        }
        return false;
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    public Item[] findByName(String name) {
        Item[] items = new Item[position];
        int count = 0;
        for (int index = 0; index < position; index++) {
            if (this.items[index].getName().equals(name)) {
                items[count++] = this.items[index];
            }
        }
        return Arrays.copyOf(items, count);
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

}
