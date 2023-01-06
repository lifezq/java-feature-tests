package com.yql.features.java8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
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

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Test
    public void testComparable() {
        Assertions.assertTrue(((Comparable) 10).compareTo(8) > 0);
    }

    @Test
    public void testFuture() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Future<?> future = executorService.submit(() -> {
            System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +
                    "." + Thread.currentThread().getName());
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Arrays.asList(10, 343, 545, 32, 443, 54);
        });

        List<Integer> futureGets = (List<Integer>) future.get();
        System.out.println(futureGets);
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
