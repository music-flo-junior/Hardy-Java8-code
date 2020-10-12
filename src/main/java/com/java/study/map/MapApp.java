package com.java.study.map;

import java.util.Arrays;
import java.util.List;

/**
 * 설명 : XXXXXXXXXXX
 *
 * @author Hardy(조민국) / dev.mingood@sk.com
 * @since 2020. 10. 10
 */
public class MapApp {

    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("Hardy", 30),
                new Person("Mark", 29),
                new Person("Nora", 28)
        );

        personList.stream()
                .map(Person::getName)
                .forEach(System.out::println);

        personList.stream()
                .filter(person -> person.getName().startsWith("H"))
                .forEach(person -> System.out.println(person.getName()));

        personList.stream()
                .map(Person::getName)
                .filter(name -> name.startsWith("H"))
                .forEach(System.out::println);
    }

}
