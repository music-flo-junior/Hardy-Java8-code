package com.java.study.lambda.step3;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * 설명 : XXXXXXXXXXX
 *
 * @author Hardy(조민국) / dev.mingood@sk.com
 * @since 2020. 09. 19
 */
public class App {

    public static void main(String[] args) {
        // Reference
        UnaryOperator<String> hi1 = (s) -> "hi " + s;
        UnaryOperator<String> hi2 = Greeting::hi;
        System.out.println(hi1.apply("hardy1"));
        System.out.println(hi2.apply("hardy2"));

        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("hardy3"));

        Supplier<Greeting> greetingSupplier = Greeting::new;
        Greeting greeting1 = greetingSupplier.get();// 이 시점에 만듦
        System.out.println(greeting1.hello("supplier"));

        Function<String, Greeting> greetingFunction = Greeting::new;
        System.out.println(greetingFunction.apply("HARDY").hello("function"));

        String[] names = {"hardy", "groot", "java8"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));

        // Interface
        Foo foo = new DefaultFoo("Hardy");
        foo.printName();
        foo.printNameUpperCase();

        Foo.pringAnything();

        Bar bar = new DefaultBar("Groot");
        bar.printName();
        bar.printNameUpperCase();
    }

}
