package ru.job4j.array;

public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }
    /**
     * Проверяет, что слово начинается с перфикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса.
     */
    public boolean starWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        //проверить, что массив data имеет первые элементы одинаковые с value
        if (prefix.equals(value)) {
            result = false;
        }
        return result;
    }
}
