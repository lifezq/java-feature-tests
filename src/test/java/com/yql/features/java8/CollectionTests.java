package com.yql.features.java8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Package com.yql.features.java8
 * @ClassName CollectionTests
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/5
 */
public class CollectionTests {
    @Test
    public void testCollectionSort() {
        // Collections.sort -> Arrays.sort

        List<Integer> list = Arrays.asList(23, 434, 35, 45, 6565, 67676, 76);
        Collections.sort(list);
        System.out.println(list);
    }
}
