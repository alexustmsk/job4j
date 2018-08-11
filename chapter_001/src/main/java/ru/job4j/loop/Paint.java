package ru.job4j.loop;

public class Paint {
    // Реализация правого треугольника
    public String rightTrl(int height) {
        StringBuilder screen1 = new StringBuilder();
        int weight = height;
        // Внешний цикл двигается по строкам.
        for (int row = 0; row != height; row++) {
            // Внутренний цикл опрелеляет положение ячейки в строке.
            for (int column = 0; column != weight; column++) {
                // Если строка равна ячейки, то рисуем галку
                // В данном случае строка определяет, сколько галок будет на строке.
                if (row >= column) {
                    screen1.append("^");
                } else {
                    screen1.append(" ");
                }
            }
            // Добавляем перевод строки
            screen1.append(System.lineSeparator());
        }
        // Получаем результат
        return screen1.toString();
    }
    // Реализация левого треугольника
    public String leftTrl(int height) {
        StringBuilder screen2 = new StringBuilder();
        int weight = height;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= weight - column - 1) {
                    screen2.append("^");
                } else {
                    screen2.append(" ");
                }
            }
            screen2.append(System.lineSeparator());
        }
        return screen2.toString();
    }
    // Реализация полной пиримиды
    public String piramid(int height) {
        StringBuilder screen3 = new StringBuilder();
        int weight = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
                    screen3.append("^");
                } else {
                    screen3.append(" ");
                }
            }
            screen3.append(System.lineSeparator());
        }
        return screen3.toString();
    }
}
