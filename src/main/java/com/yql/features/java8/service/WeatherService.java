package com.yql.features.java8.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * @Package com.yql.features.java11.service
 * @ClassName weatherService
 * @Description TODO
 * @Author Ryan
 * @Date 1/3/2023
 */
@Service
@Scope("prototype")
public class WeatherService {
    String time = LocalDateTime.now().toString();
    int temp = new Random().nextInt(60);

    public String getTodaysTemp() {
        return time + "->" + temp;
    }
}
