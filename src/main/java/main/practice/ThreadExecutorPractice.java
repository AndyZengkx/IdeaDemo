package main.practice;

import java.util.Formatter;

public class ThreadExecutorPractice {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int COUNT_MASK = (1 << COUNT_BITS) - 1;

    public static void main(String... args) {
        Formatter formatter = new Formatter(System.out);
        formatter.format("%d\n", COUNT_BITS);
        System.out.println("COUNT_MASK: " + Integer.toBinaryString(COUNT_MASK));
        System.out.println("~COUNT_MASK: " + Integer.toBinaryString(~COUNT_MASK));
    }
}
