package ru.job4j.pseudo;

public class Triangle implements Shape {

    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        int height = 4;
        int weight = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
                    pic.append("^");
                } else {
                    pic.append(" ");
                }
            }
            pic.append(System.lineSeparator());
        }
        System.out.print(pic.toString());
        return pic.toString();
    }
}
