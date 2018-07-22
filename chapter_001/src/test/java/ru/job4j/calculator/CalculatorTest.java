package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Alexander Ustyuzhanin (alexustmsk@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class CalculatorTest {
    /**
     * Test add.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    /**
     * Test Subtract.
     */
    @Test
    public void whenSubstract2On2Then1() {
        Calculator calc1 = new Calculator();
        calc1.subtract(5D, 3D);
        double result = calc1.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    /**
     * Test Div.
     */
    @Test
    public void whenDiv2On2Then1() {
        Calculator calc2 = new Calculator();
        calc2.div(8D, 2D);
        double result = calc2.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }
    /**
     * Test Multiple.
     */
    @Test
    public void whenMultiple2On2Then1() {
        Calculator calc3 = new Calculator();
        calc3.multiple(4D, 2D);
        double result = calc3.getResult();
        double expected = 8D;
        assertThat(result, is(expected));
    }
}
