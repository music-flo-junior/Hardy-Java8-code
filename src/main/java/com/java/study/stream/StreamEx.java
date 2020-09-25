package com.java.study.stream;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * 설명 : XXXXXXXXXXX
 *
 * @author Hardy(조민국) / dev.mingood@sk.com
 * @since 2020. 09. 25
 */
@SuppressWarnings("unchecked")
public class StreamEx {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Hardy");
        names.add("Java8");
        names.add("Foo");
        names.add("Bar");

        List<String> nameList1 = names.parallelStream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        nameList1.forEach(System.out::println);

        System.out.println("=======================");

        List<String> nameList2 = names.stream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        nameList2.forEach(System.out::println);


        Stream<String> song = Stream.of("gently", "down", "the", "stream");
        song.forEach(System.out::println);

        Stream.generate(Math::random)
                .limit(100)
                .forEach(System.out::println);

        Stream.of("word", "word", "hardy")
                .distinct()
                .forEach(System.out::println);

        Stream.of("word", "hardy", "spring boot")
                .sorted(Comparator.comparing(String::length).reversed())
                .forEach(System.out::println);

        Stream.iterate(1, i -> i * 2)
                .peek(e -> System.out.println("Fetching " + e))
                .limit(20)
                .toArray();

        Stream.of("hardy")
                .filter(s -> s.startsWith("Q"))
                .findFirst()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("NULL")
                );

        Map<String, String> localeMap = Stream.of(Locale.getAvailableLocales())
                .collect(Collectors.toMap(
                        Locale::getDisplayCountry,
                        Locale::getDisplayLanguage,
                        (dupA, dupB) -> dupA
                ));

        // groupingBy, partitioningBy
        Map<String, Long> countryToLocaleCount = Stream.of(Locale.getAvailableLocales())
                .collect(groupingBy(Locale::getCountry, counting()));
        System.out.println(countryToLocaleCount.get("KR"));

        Map<String, List<Locale>> countryToLocales = Stream.of(Locale.getAvailableLocales())
                .collect(groupingBy(Locale::getDisplayCountry));
        System.out.println(countryToLocales.get("프랑스"));

        Map<Boolean, List<Locale>> englishAndOtherLocaleMap = Stream.of(Locale.getAvailableLocales())
                .collect(Collectors.partitioningBy(locale -> locale.getLanguage().equals("en")));
        System.out.println(englishAndOtherLocaleMap.get(true));

        // 리덕션 연산
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
        values.stream()
                .reduce(Integer::sum)
                .ifPresentOrElse(System.out::println, () -> System.out.println(0));

        System.out.println(values.stream().reduce(0, Integer::sum));

        // 병렬 스트림
        List<String> words = Arrays.asList("하디", "스프링", "봄", "애플", "아이패드", "아이폰", "셀토스", "쏘카", "그린카", "자바");
        Map<Integer, Long> shortWordCount = words.parallelStream()
                .filter(s -> s.length() < 3)
                .collect(
                        groupingBy(
                                String::length,
                                counting()
                        )
                );
        System.out.println(shortWordCount.getOrDefault(3, 0L));
        System.out.println(shortWordCount.get(2));
        System.out.println(shortWordCount.get(1));

        ConcurrentMap<Integer, List<String>> result = words.parallelStream()
                .collect(Collectors.groupingByConcurrent(String::length));
        System.out.println(result.getOrDefault(5, Collections.EMPTY_LIST));
        System.out.println(result.get(4));
        System.out.println(result.get(3));
        System.out.println(result.get(2));
        System.out.println(result.get(1));

        ConcurrentMap<Integer, Long> wordCounts = words.parallelStream()
                .collect(Collectors.groupingByConcurrent(String::length, counting()));
        System.out.println(wordCounts.getOrDefault(5, 0L));
        System.out.println(wordCounts.get(4));
        System.out.println(wordCounts.get(3));
        System.out.println(wordCounts.get(2));
        System.out.println(wordCounts.get(1));
    }

}
