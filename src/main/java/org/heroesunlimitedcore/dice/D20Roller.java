package org.heroesunlimitedcore.dice;

import java.util.Random;
import java.util.stream.IntStream;

public class D20Roller {

    public static int roll() {
        return random.nextInt(FACES);
    }

    public static int rollMultiple(int times) {
        return IntStream.rangeClosed(1, times).map(x -> roll()).sum();
    }

    private D20Roller() {}
    private static final Random random = new Random();
    private static final int FACES = 20;
}
