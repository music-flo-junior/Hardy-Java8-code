package com.java.study.lambda.step2;

import java.util.function.*;

/**
 * 설명 : XXXXXXXXXXX
 *
 * @author Hardy(조민국) / dev.mingood@sk.com
 * @since 2020. 09. 08
 */
public class Step2Main {

    public static void main(String[] args) {
        // Function
        Plus10 plus10 = new Plus10();
        System.out.println("(1) " + plus10.apply(1));

        Function<Integer, Integer> plus10Function = (number) -> number + 10;
        System.out.println("(2) " + plus10Function.apply(2));

        // UnaryOperator
        UnaryOperator<Integer> ex = (i) -> i + 100;
        System.out.println("(2)-1 " + ex.apply(10));

        Function<Integer, Integer> multiply2Function = (number) -> number * 2;
        System.out.println("(3) " + multiply2Function.apply(2));

        System.out.println("(4) " + plus10Function.compose(multiply2Function).apply(2));
        System.out.println("(5) " + plus10Function.andThen(multiply2Function).apply(2));

        // BiFunction, BinaryOperator
        BiFunction<Integer, Integer, Integer> sum1 = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> sum2 = Integer::sum;
        BinaryOperator<Integer> sum3 = Integer::sum;
        System.out.println(sum1.apply(1, 2));
        System.out.println(sum2.apply(1, 2));
        System.out.println(sum3.apply(1, 2));

        // Consumer
        Consumer<Integer> printT = (i) -> System.out.println("(6) " + i);
        printT.accept(10);

        // Supplier
        Supplier<Integer> get10 = () -> 10;
        System.out.println("(7) " + get10.get());

        // Predicate
        Predicate<String> isStartsWithHardy = (s) -> s.startsWith("Hardy");
        Predicate<String> isStartsWithAA = (s) -> s.startsWith("AA");
        System.out.println("(8) " + isStartsWithHardy.or(isStartsWithAA).test("AA"));
        System.out.println("(9) " + isStartsWithHardy.negate().test("ardy"));
    }

}
