package com.yql.features.java8;

import org.junit.jupiter.api.Test;

/**
 * @Package com.yql.features.java8
 * @ClassName ExceptionTests
 * @Description In following cases, finally block will not be executed :-
 * When System.exit(0) is invoked from try block.
 * When JVM runs out of memory
 * When your java process is killed forcefully from task mgr or console
 * Deadlock condition in your try block
 * When your machine shuts down due power failure
 * @Author Ryan
 * @Date 1/8/2023
 */
public class ExceptionTests {
    @Test
    public void testException() {
        try {
            System.out.println("test running...");
            Thread.sleep(1000);
            return;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally running...");
        }
    }

    @Test
    public void testExceptionWithoutFinally() {
        try {
            System.out.println("test running...");
            System.exit(0);
            // deadlock or endless loop
        } finally {
            System.out.println("this will never be executed.");
        }
    }

    @Test
    public void testExceptionWithoutFinally2() throws InterruptedException {
        Thread daemon = new Thread(runnable);
        daemon.setDaemon(true);
        daemon.start();
        Thread.sleep(100);
        // daemon.stop();
        System.out.println("Last non-daemon thread exits.");
    }

    private static final Runnable runnable = () -> {
        try {
            while (true) {
                System.out.println("Is alive");
                Thread.sleep(10);
                // throw new RuntimeException();
            }
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            System.out.println("This will never be executed.");
        }
    };
}


