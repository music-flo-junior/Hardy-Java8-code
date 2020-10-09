package com.java.study.map;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 설명 : XXXXXXXXXXX
 *
 * @author Hardy(조민국) / dev.mingood@sk.com
 * @since 2020. 10. 10
 */
public class FlatMapApp {

    public static void main(String[] args) {
        String[][] sample = new String[][]{
                {"Hardy", "M"},
                {"Mark", "A"},
                {"Nora", "L"}
        };

        Stream.of(sample)
                .filter(person -> person[0].startsWith("H") || "A".equals(person[1]))
                .forEach(person -> System.out.println(person[0] + " " + person[1]));

        Stream.of(sample)
                .flatMap(Arrays::stream)
                .filter(value -> value.startsWith("H") || "A".equals(value))
                .forEach(System.out::println);
    }

}
