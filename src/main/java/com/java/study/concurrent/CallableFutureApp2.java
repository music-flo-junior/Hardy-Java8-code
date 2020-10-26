package com.java.study.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 설명 : N/A
 *
 * @author Minkuk Jo / mingood92@gmail.com / https://velog.io/@mingood
 * @since 2020. 10. 19.
 */
public class CallableFutureApp2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Callable<String> spring = () -> {
            Thread.sleep(1000L);
            return "Spring";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "Java";
        };


        // invokeAll은 3개의 Callable이 모두 끝날 때까지 기다린다.
        List<Future<String>> futureList = executorService.invokeAll(Arrays.asList(hello, java, spring));
        for (Future<String> future : futureList) {
            System.out.println(future.get());
        }

        String anyString = executorService.invokeAny(Arrays.asList(hello, java, spring));
        System.out.println(anyString);

        executorService.shutdown();
    }

}
