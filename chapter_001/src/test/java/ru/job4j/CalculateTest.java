package test.java.ru.job4j;

import main.java.ru.job4j.calculate.Calculate;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test.
 *
 * @author Alexander Ustyuzhanin (alexustmsk@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class CalculateTest {
    /**
     * Test add.
     */
    @Test
    public void whenAddOneToOneThenTwo() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Calculate.main(null);
        assertThat(
                out.toString(),
                is(
                        String.format(
                                "Hello World\r\n",
                                System.getProperty("line.separator")
                        )
                )
        );
    }

    /**
     * Test echo
     */
    @Test
    public void whenTakeNameThenTreeEchoPlusName() {
        String input = "Alexander Ustyuzhanin";
        String expect = "Echo, echo, echo : Alexander Ustyuzhanin";
        Calculate calc = new Calculate();
        String result = calc.echo(input);
        assertThat(result, is(expect));
    }
}
