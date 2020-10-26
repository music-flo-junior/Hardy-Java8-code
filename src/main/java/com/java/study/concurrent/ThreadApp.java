package com.java.study.concurrent;

/**
 * 설명 : N/A
 *
 * @author Minkuk Jo / mingood92@gmail.com / https://velog.io/@mingood
 * @since 2020. 10. 18.
 */
public class ThreadApp {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("Thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException ie) {
                    System.out.println("interrupted!");
//                    return;
                    throw new IllegalStateException(ie);
                }
            }
        });
        thread.start();

        System.out.println("Hello: " + Thread.currentThread().getName());
        Thread.sleep(3000L);
//        thread.interrupt();

        thread.join();
        System.out.println(thread + " is finished!");
    }

}
