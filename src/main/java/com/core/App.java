package com.core;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Hello World!");
        String arr[] = {"a", "b", "c"};
        System.out.println(arr);
        LocalDateTime fromDate = LocalDateTime.of(2024, 1, 25,
                12, 56, 12
        );
        LocalDateTime toDate = LocalDateTime.now();
        long millis = Duration.between(fromDate, toDate).toMillis();
        LocalDate localDate = fromDate.toLocalDate().plusDays(1);

        System.out.println(fromDate + "  " + localDate);

        System.out.println();

        int x = 15;
        int y = 10;

        x = x++ + ++y;

        System.out.println(x);

        Integer x1 = 127;

        Integer x2 = 127;

        System.out.println(x1 == x2);
    }
}
