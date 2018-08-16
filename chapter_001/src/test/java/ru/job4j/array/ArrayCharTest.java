package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayCharTest {
    @Test
    public void whenStarWithPrefixThenTrue() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.starWith("He");
        assertThat(result, is(true));
    }
    @Test
    public void whenNotStarWithPrefixThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.starWith("Hi");
        assertThat(result, is(false));
    }
}
