package com.yql.features.java8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Package com.yql.feature.java8
 * @ClassName StreamTests
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/3
 */
public class StreamTests {
    @Test
    public void testStreamDebugTraces() {
        int[] ints = Arrays.stream(new int[]{22, 323, 434, 23, 2, 232, 34, 23, 24, 23, 23, 43})
                .flatMap(IntStream::of)
                .distinct()
                .sorted()
                .toArray();
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void testStreamGroupingby() {
        String input = "Basanta";
        Map<String, Long> collect = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }
}
