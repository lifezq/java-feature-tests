package com.yql.features.java8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package com.yql.features.java8.entity
 * @ClassName Employee
 * @Description TODO
 * @Author Ryan
 * @Date 1/4/2023
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String dept;
    private Double salary;
}

