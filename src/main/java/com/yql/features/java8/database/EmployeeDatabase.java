package com.yql.features.java8.database;

import com.yql.features.java8.entity.Employee;

import java.util.Arrays;
import java.util.List;

/**
 * @Package com.yql.features.java8.database
 * @ClassName EmployeeDatabase
 * @Description TODO
 * @Author Ryan
 * @Date 1/7/2023
 */
public class EmployeeDatabase {
    public static List<Employee> employees = Arrays.asList(
            new Employee(1L, "Wang Wu", "QA", 5000D),
            new Employee(2L, "Zhang San", "QA", 6000D),
            new Employee(3L, "Zhao Liu", "DEV", 3500D),
            new Employee(4L, "Li Wei", "DEVOPS", 4500D),
            new Employee(5L, "Li Wei", "DEV", 5500D)
    );

    public static List<Employee> fetchAllEmployees() {
        return employees;
    }
}
