package com.java.study.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 설명 : N/A
 *
 * @author Minkuk Jo / mingood92@gmail.com / https://velog.io/@mingood
 * @since 2020. 10. 19.
 */
public class CompletableFutureApp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName());

        CompletableFuture<String> future = CompletableFuture.completedFuture("Hardy");
        System.out.println(future.get());

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(
                () -> System.out.println("void completable future " + Thread.currentThread().getName())
        );
        voidCompletableFuture.get();

        CompletableFuture<String> supplyCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("supply completable future " + Thread.currentThread().getName());
            return "FLO";
        });
        System.out.println(supplyCompletableFuture.get());
    }

}
