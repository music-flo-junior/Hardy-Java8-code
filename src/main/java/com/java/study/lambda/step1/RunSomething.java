package com.java.study.lambda.step1;

/**
 * 설명 : XXXXXXXXXXX
 *
 * @author Hardy(조민국) / dev.mingood@sk.com
 * @since 2020. 09. 08
 */
@FunctionalInterface
public interface RunSomething {

    int doIt(int number);

    static void printName() {
        System.out.println("Hardy");
    }

    default void printAge() {
        System.out.println("29");
    }

}
