package com.java.study.lambda.step1;

import java.util.Comparator;

/**
 * 설명 : XXXXXXXXXXX
 *
 * @author Hardy(조민국) / dev.mingood@sk.com
 * @since 2020. 09. 08
 */
public class Step1Main {

    public static void main(String[] args) {
        RunSomething runSomething = (number) -> number + 10;
        System.out.println(runSomething.doIt(10));
        runSomething.printAge();
        RunSomething.printName();

        Runnable task = () -> {
            for (int i = 0; i < 1000; ++i) {
                System.out.println("task " + i);
            }
        };
        task.run();

        Comparator<String> stringComparator = (first, second) -> {
            int difference = first.length() - second.length();
            return Integer.compare(difference, 0);
        };
    }

}
