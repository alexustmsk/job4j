package ru.job4j.pseudo;

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        int height = 4;
        int weight = 8;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                pic.append("+");
            }
            pic.append(System.lineSeparator());
        }
        System.out.print(pic.toString());
        return pic.toString();
    }
}
