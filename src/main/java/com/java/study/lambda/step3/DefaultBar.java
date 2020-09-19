package com.java.study.lambda.step3;

/**
 * 설명 : XXXXXXXXXXX
 *
 * @author Hardy(조민국) / dev.mingood@sk.com
 * @since 2020. 09. 20
 */
public class DefaultBar implements Bar {

    private String name;

    public DefaultBar(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    // Bar에서는 추상 메소드이기 때문에 재정의 해야한다.
    @Override
    public void printNameUpperCase() {
        System.out.println(this.getName().toUpperCase());
    }

}
