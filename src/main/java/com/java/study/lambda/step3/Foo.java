package com.java.study.lambda.step3;

/**
 * 설명 : XXXXXXXXXXX
 *
 * @author Hardy(조민국) / dev.mingood@sk.com
 * @since 2020. 09. 20
 */
public interface Foo {

    void printName();

    String getName();

    /**
     * @implSpec
     * 이 구현체는 getName()으로 가져온 문자열을 대문자로 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println(this.getName().toUpperCase());
    }

    static void pringAnything() {
        System.out.println("Foo");
    }

}
