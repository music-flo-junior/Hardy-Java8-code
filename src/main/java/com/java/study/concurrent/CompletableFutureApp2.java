package com.java.study.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 설명 : N/A
 *
 * @author Minkuk Jo / mingood92@gmail.com / https://velog.io/@mingood
 * @since 2020. 10. 19.
 */
public class CompletableFutureApp2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> supplyCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("supply completable future " + Thread.currentThread().getName());
            return "FLO";
        }).thenApply(String::toLowerCase);

        System.out.println(supplyCompletableFuture.get());
    }

}
