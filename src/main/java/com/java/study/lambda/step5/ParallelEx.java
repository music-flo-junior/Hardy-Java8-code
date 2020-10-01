package com.java.study.lambda.step5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 설명 : XXXXXXXXXXX
 *
 * @author Hardy(조민국) / dev.mingood@sk.com
 * @since 2020. 09. 30
 */
public class ParallelEx {

    public static void main(String[] args) {
        int availableProcessorCount = Runtime.getRuntime().availableProcessors();

        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            for (int i = 0; i < availableProcessorCount; ++i) {
                System.out.println("==================" + i);
                if (i == 1) {
                    executorService.submit(
                            () -> {
                                for (int j = 0; j < 10; ++j) {
                                    System.out.println("!! " + j);
                                }
                            }
                    );
                } else if (i == 2) {
                    executorService.submit(
                            () -> {
                                for (int j = 0; j < 10; ++j) {
                                    System.out.println("@@ " + j);
                                }
                            }
                    );
                } else if (i == 3) {
                    executorService.submit(
                            () -> {
                                for (int j = 0; j < 10; ++j) {
                                    System.out.println("## " + j);
                                }
                            }
                    );
                } else if (i == 4) {
                    executorService.submit(
                            () -> {
                                for (int j = 0; j < 10; ++j) {
                                    System.out.println("$$ " + j);
                                }
                            }
                    );
                } else if (i == 5) {
                    executorService.submit(
                            () -> {
                                for (int j = 0; j < 10; ++j) {
                                    System.out.println("%% " + j);
                                }
                            }
                    );
                } else {
                    executorService.submit(
                            () -> {
                                for (int j = 0; j < 10; ++j) {
                                    System.out.println("^^ " + j);
                                }
                            }
                    );
                }
            }
        } catch (Exception e) {

        }
    }

}
