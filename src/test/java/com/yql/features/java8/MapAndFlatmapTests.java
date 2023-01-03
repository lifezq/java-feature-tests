package com.yql.features.java8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Package com.yql.feature.java8
 * @ClassName MapAndFlatmapTests
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/3
 */
public class MapAndFlatmapTests {

    @Test
    public void testMap() {
        Optional<String> s = Optional.of("test");
        assertEquals(Optional.of("TEST"), s.map(String::toUpperCase));
    }

    @Test
    public void testNestedOptionalMap() {
        assertEquals(Optional.of(Optional.of("STRING")),
                Optional
                        .of("string")
                        .map(s -> Optional.of("STRING")));
    }

    @Test
    public void testFlatmap() {
        assertEquals(Optional.of("STRING"), Optional
                .of("string")
                .flatMap(s -> Optional.of("STRING")));
    }

    @Test
    public void testStreamMap() {
        List<String> myList = Stream.of("a", "b")
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        assertEquals(Arrays.asList("A", "B"), myList);
    }

    @Test
    public void testNestedList() {
        List<List<String>> list = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("b"));
        System.out.println(list); //out: [[a], [b]]

        System.out.println(list
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));//out: [a, b]
    }


    private void assertEquals(Object test, Object s) {
        Assertions.assertEquals(test, s);
    }
}
