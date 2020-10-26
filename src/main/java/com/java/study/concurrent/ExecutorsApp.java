package com.java.study.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 설명 : N/A
 *
 * @author Minkuk Jo / mingood92@gmail.com / https://velog.io/@mingood
 * @since 2020. 10. 19.
 */
public class ExecutorsApp {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(getRunnable("Hardy"));
        executorService.submit(getRunnable("Nora"));
        executorService.submit(getRunnable("Mark"));
        executorService.submit(getRunnable("FLO"));
        executorService.submit(getRunnable("Java"));

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(getRunnable("Scheduled"), 3, TimeUnit.SECONDS);

//        executorService.execute(() -> System.out.println("Thread " + Thread.currentThread().getName()));
//        executorService.submit(() -> System.out.println("Thread " + Thread.currentThread().getName()));
        executorService.shutdown(); // graceful shutdown
        scheduledExecutorService.shutdown();
    }

    public static Runnable getRunnable(String message) {
        return () -> System.out.println(message + " " + Thread.currentThread().getName());
    }

}
