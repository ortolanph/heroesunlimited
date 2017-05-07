package org.heroesunlimited.core.util;

import org.heroesunlimited.core.dice.D20Roller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SerialNumber {
    public static String generate() {
        LocalDateTime now = LocalDateTime.now();
        String part1 = toHexNumber(now.format(DateTimeFormatter.ofPattern(FORMAT_HOUR_MINUTE)));
        String part2 = toHexNumber(now.format(DateTimeFormatter.ofPattern(FORMAT_YEAR)));
        String part3 = toHexNumber(now.format(DateTimeFormatter.ofPattern(FORMAT_MONTH_DAY)));
        String part4 = toHexNumber(now.format(DateTimeFormatter.ofPattern(FORMAT_MILLI)));
        String part5 = Integer.toHexString(D20Roller.rollMultiple(10));

        return String.format(SERIAL_NUMBER_FORMAT, part1, part2, part3, part4, part5);
    }

    private static String toHexNumber(String part) {
        return Integer.toHexString(Integer.valueOf(part));
    }

    private static final String SERIAL_NUMBER_FORMAT = "%s%s%s%s%s";
    private static final String FORMAT_HOUR_MINUTE = "HHmm";
    private static final String FORMAT_YEAR = "yyyy";
    private static final String FORMAT_MONTH_DAY = "MMdd";
    private static final String FORMAT_MILLI = "A";
}
