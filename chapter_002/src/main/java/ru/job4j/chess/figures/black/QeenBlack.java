package ru.job4j.chess.figures.black;


import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 *
 * @author Alexander Ustyuzhanin (alexustmsk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class QeenBlack implements Figure {
    private final Cell position;

    public QeenBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[8];
        for (int i = 0; i < steps.length; i++) {
            if (source.y == dest.y && source.x != dest.x || source.y != dest.y && source.x == dest.x ||
                    (source.y - source.x) == (dest.y - dest.x) || (source.y + source.x) == (dest.y + dest.x)) {
                steps = new Cell[]{steps[i], dest};
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QeenBlack(dest);
    }
}
