package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckTest {
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true};
        boolean result = check.mono(input);
        boolean expect = true;
        assertThat(result, is(expect));
    }

    @Test
    public void whenDataMonoByFalseThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false};
        boolean result = check.mono(input);
        boolean expect = true;
        assertThat(result, is(expect));
    }

    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false, true, false};
        boolean result = check.mono(input);
        boolean expect = false;
        assertThat(result, is(expect));
    }
}
