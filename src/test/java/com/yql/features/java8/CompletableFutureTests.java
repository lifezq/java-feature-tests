package com.yql.features.java8;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * @Package com.yql.features.java8
 * @ClassName CompletableFuture
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/5
 */
public class CompletableFutureTests {
    @Test
    public void testCompletableFuture() throws InterruptedException {
        CompletableFutureTest.doTest();
    }


    static class CompletableFutureTest {
        private static final IntPredicate oddPredicate = x -> x % 2 != 0;
        private static final IntPredicate evenPredicate = x -> x % 2 == 0;
        private static final Object object = new Object();

        public static void doTest() throws InterruptedException {
            CompletableFuture.runAsync(() -> CompletableFutureTest.printNumber(oddPredicate));
            CompletableFuture.runAsync(() -> CompletableFutureTest.printNumber(evenPredicate));
            Thread.sleep(1000);
        }

        public static void printNumber(IntPredicate predicate) {
            IntStream.rangeClosed(1, 10).filter(predicate).forEach(CompletableFutureTest::execute);
        }

        private static void execute(int i) {
            synchronized (object) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    object.notify();
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
