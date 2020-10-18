package com.java.study.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 설명 : N/A
 *
 * @author Minkuk Jo / mingood92@gmail.com / https://velog.io/@mingood
 * @since 2020. 10. 19.
 */
public class CompletableFutureApp3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        String result = hello.thenCompose(CompletableFutureApp3::getWorld).get();
        System.out.println(result);

        System.out.println("=================================");

        CompletableFuture<String> goodBye = CompletableFuture.supplyAsync(() -> {
            System.out.println("Goodbye " + Thread.currentThread().getName());
            return "Goodbye";
        });

        CompletableFuture<String> space = CompletableFuture.supplyAsync(() -> {
            System.out.println("Space " + Thread.currentThread().getName());
            return "Space";
        });

        CompletableFuture<String> future = goodBye.thenCombine(space, (g, s) -> g + " " + s);
        System.out.println(future.get());
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(message + " World " + Thread.currentThread().getName());
            return message + " World";
        });
    }

}
