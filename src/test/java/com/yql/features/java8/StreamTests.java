package com.yql.features.java8;

import com.yql.features.java8.entity.Employee;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BinaryOperator;
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
    public void testStreamGroupingBy() {
        String input = "Basanta";
        Map<String, Long> collect = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }

    @Test
    public void testStreamComparator() {
        List<Employee> employees = Arrays.asList(
                new Employee(1L, "Wang Wu", "QA", 5000D),
                new Employee(2L, "Zhang San", "QA", 6000D),
                new Employee(3L, "Zhao Liu", "DEV", 3500D),
                new Employee(4L, "Li Wei", "DEVOPS", 4500D),
                new Employee(5L, "Li Wei", "DEV", 5500D)
        );

        Comparator<Employee> comparing = Comparator.comparing(Employee::getSalary);
        Map<String, Optional<Employee>> employeeMap = employees.stream().collect(
                Collectors.groupingBy(Employee::getDept, Collectors.reducing(BinaryOperator.maxBy(comparing))));
        System.out.println(employeeMap);
    }
}
