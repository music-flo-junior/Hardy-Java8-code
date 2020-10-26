package com.java.study.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 설명 : N/A
 *
 * @author Minkuk Jo / mingood92@gmail.com / https://velog.io/@mingood
 * @since 2020. 10. 19.
 */
public class CompletableFutureApp4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            if (false) {
                throw new IllegalArgumentException();
            }

            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).exceptionally(ex -> {
            System.out.println(ex);
            return "Error!";
        });

        System.out.println(hello.get());
        System.out.println("===========================");

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            if (false) {
                throw new IllegalArgumentException();
            }

            System.out.println("World " + Thread.currentThread().getName());
            return "World";
        }).handle((success, ex) -> {
            if (ex != null) {
                System.out.println(ex);
                return "ERROR";
            }
            return success;
        });
        System.out.println(world.get());
    }

}
