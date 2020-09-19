package com.java.study.lambda.step2;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * 설명 : XXXXXXXXXXX
 *
 * @author Hardy(조민국) / dev.mingood@sk.com
 * @since 2020. 09. 19
 */
public class CaptureEx {

    public static void main(String[] args) {
        CaptureEx captureEx = new CaptureEx();
        captureEx.run();
    }

    private void run() {
        int baseNumber = 10;    // effectively final

        // 로컬 클래스 (쉐도잉 가능)
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber);
            }
        }

        // 익명 클래스 (쉐도잉 가능)
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                int baseNumber = 11;
                System.out.println(baseNumber);
            }
        };
        integerConsumer.accept(10);

        // 람다 (쉐도잉 불가 scope이 run과 같다.)
        IntConsumer printInt = (i) -> System.out.println(i + baseNumber);
        printInt.accept(10);
    }

}
