package ru.job4j.loop;

public class Factorial {
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            if (n == 0) {
                return 1;
            } else {
                result *= i;
            }
        }
            return result;
    }
}
