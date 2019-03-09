package ru.job4j.chess.figures.black;


import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 *
 * @author Alexander Ustyuzhanin (alexustmsk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class RookBlack implements Figure {
    private final Cell position;

    public RookBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[8]; //Определяем возможность движения фигуры и получаем размер массива
        int deltaX = source.x - dest.x; // Определяем дельты
        int deltaY = source.y - dest.y;// Определяем дельты
        // заполняем массив с проверкой
        for (int i = 0; i < steps.length; i++) {
            if (move(source, dest)) {
                steps[i] = Cell.values()[deltaX, deltaY];
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }

    public boolean move (Cell source, Cell dest) {
        try {
            if (source.y == dest.y && source.x != dest.x || source.y != dest.y && source.x == dest.x) {
                return true;
            } catch(ImpossibleMoveException ime){
                System.out.println("Невозможно ходить");
            } catch(OccupiedWayException owe){
                System.out.println("Клетка занята");
            } catch(FigureNotFoundException fnfe){
                System.out.println("Фигура не найдена");
            }
        }

        return false;
    }
}