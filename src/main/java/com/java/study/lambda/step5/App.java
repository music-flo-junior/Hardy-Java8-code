package com.java.study.lambda.step5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.*;

/**
 * 설명 : 람다를 이용한 프로그래밍
 *
 * @author Hardy(조민국) / dev.mingood@sk.com
 * @since 2020. 09. 30
 */
public class App {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(App.class);
        // 필요할 때만 문자열 연산 발생 () -> "Hardy " + "TEST"
        // 1. 람다를 받는다.
        // 2. 람다를 호출해야 하는지 검사
        // 3. 필요할 때 람다를 호출
        info(logger, () -> "Hardy " + "TEST");


        String[] names = {"Hardy", "Java8", "FLO", "SpringBoot", "Junit"};
        Arrays.sort(names, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(names));


        repeat(10, i -> System.out.println("Countdown: " + (9 - i)));
        repeat(10, () -> System.out.println("Countdown: Hardy"));

        consumeNameAge("Hardy", 29, App::printNameAge);

        Function<Integer, Integer> times2 = e -> e * 2;
        Function<Integer, Integer> squared = e -> e * e;
        System.out.println(times2.compose(squared).apply(4));
        System.out.println(times2.andThen(squared).apply(4));

        UnaryOperator<Integer> multiply3 = e -> e * 3;
        UnaryOperator<Integer> multiply4 = e -> e * 4;
        System.out.println(multiply3.compose(multiply4).apply(4));
        System.out.println(multiply3.andThen(multiply4).apply(4));
    }

    public static void info(Logger logger, Supplier<String> message) {
        if (logger.isInfoEnabled()) {
            logger.info(message.get());
        }
    }

    public static void repeat(int n, IntConsumer action) {
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }
    }

    public static void repeat(int n, Runnable action) {
        for (int i = 0; i < n; i++) {
            action.run();
        }
    }

    public static void consumeNameAge(String name, int age, BiConsumer<String, Integer> action) {
        action.accept(name, age);
    }

    public static void printNameAge(String name, int age) {
        System.out.println(name + " " + age);
    }

}
