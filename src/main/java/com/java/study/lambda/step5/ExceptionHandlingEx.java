package com.java.study.lambda.step5;

import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * 설명 : XXXXXXXXXXX
 *
 * @author Hardy(조민국) / dev.mingood@sk.com
 * @since 2020. 09. 30
 */
public class ExceptionHandlingEx {

    public static void main(String[] args) {

    }

    public static void runInSequence(Runnable first, Runnable second, Consumer<Exception> exceptionConsumer) {
        try {
            first.run();
            second.run();
        } catch (Exception e) {
            exceptionConsumer.accept(e);
        }
    }

    public static void parallelRunInSequence(Runnable one, Runnable two, Consumer<Exception> exceptionConsumer) {
        BiFunction<Runnable, Consumer<Exception>, Runnable> action = (run, consumer) ->
                () -> {
                    try {
                        run.run();
                    } catch (Exception e) {
                        consumer.accept(e);
                    }
                };

        new Thread(action.apply(one, exceptionConsumer)).start();
        new Thread(action.apply(two, exceptionConsumer)).start();
    }

}
