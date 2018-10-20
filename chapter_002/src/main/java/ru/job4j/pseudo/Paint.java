package ru.job4j.pseudo;

public class Paint {
    private Shape shape;

    public Paint(Shape shape) {
        this.shape = shape;
    }


    public String executePaint() {
        return shape.draw();
    }

    public static void main(String[] args) {
        Paint paint = new Paint(new Triangle());
        Paint paint1 = new Paint(new Square());
        paint.executePaint();
        paint1.executePaint();
    }
}
