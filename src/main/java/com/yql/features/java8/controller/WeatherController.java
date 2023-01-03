package com.yql.features.java8.controller;

import com.yql.features.java8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @Package com.yql.features.java8.controller
 * @ClassName WeatherController
 * @Description TODO
 * @Author Ryan
 * @Date 1/3/2023
 */
@RequestMapping("/weather")
@RestController
public class WeatherController {
    @Autowired
    UserService userService;


    @GetMapping
    public List<String> weather() throws InterruptedException {
        String todayTemp1 = userService.getTodaysTemp();
        Thread.sleep(1000);
        String todayTemp2 = userService.getTodaysTemp();

        return Arrays.asList(todayTemp1, todayTemp2);
    }
}
