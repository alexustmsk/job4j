package ru.job4j.max;
/**
 * @author Alexander Ustyuzhanin
 * @version $Id$
 * @since 0.1
 */
public class Max {
    public int max(int first, int second) {
        return first < second ? second : first;
    }

    public int max(int first, int second, int third) {
        return max(max(first, second), third);
    }
}
