package com.java.study.lambda.step4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

/**
 * 설명 : XXXXXXXXXXX
 *
 * @author Hardy(조민국) / dev.mingood@sk.com
 * @since 2020. 09. 20
 */
public class App {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Hardy");
        names.add("Java8");
        names.add("Foo");
        names.add("Bar");

        names.forEach(System.out::println);
        System.out.println("=======================");

        Spliterator<String> spliterator = names.spliterator();
        //noinspection StatementWithEmptyBody
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("=======================");

        Spliterator<String> spliterator1 = names.spliterator().trySplit();
        //noinspection StatementWithEmptyBody
        while (spliterator1.tryAdvance(System.out::println));
        System.out.println("=======================");

        names.removeIf(name -> name.startsWith("H"));
        names.forEach(System.out::println);
        System.out.println("=======================");

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        names.sort(compareToIgnoreCase.reversed());
        System.out.println(names);
    }

}
