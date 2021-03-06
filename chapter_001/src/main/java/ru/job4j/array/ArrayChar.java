package ru.job4j.array;

public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }
    /**
     * Проверяет, что слово начинается с перфикса.
     * Также проверяем, что массив data имеет первые элементы одинаковые с value.
     * @param prefix префикс.
     * @return если слово начинается с префикса.
     */
    public boolean starWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int i = 0; i < value.length; i++) {
            if (value[i] != (data[i])) {
                result = false;
                break;
            }
        }
        return result;
    }
}
