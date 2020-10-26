package com.java.study.concurrent;

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
public class CallableFutureApp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Future<String> submit = executorService.submit(hello);
        System.out.println(submit.isDone());
        System.out.println("started!");
        System.out.println(submit.isDone());
//        submit.cancel(false);
        System.out.println(submit.get());   // Blocking Call // 취소되면 값을 가져올 수 없다.
        System.out.println(submit.isDone());
        System.out.println("end!");

        executorService.shutdown();
    }

}
