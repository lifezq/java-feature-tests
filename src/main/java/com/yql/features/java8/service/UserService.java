package com.yql.features.java8.service;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @Package com.yql.features.java11.service
 * @ClassName UserService
 * @Description TODO
 * @Author Ryan
 * @Date 1/2/2023
 */
@Service
public class UserService {
    @Autowired
    WeatherService weatherService;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    ObjectFactory<WeatherService> objectFactory;

    public String getTodaysTemp() {
//        return weatherService.getTodaysTemp(); // return the same value for WeatherController.weather

        // below return the different value for WeatherController.weather
//        return applicationContext.getBean(WeatherService.class).getTodaysTemp();
//        return objectFactory.getObject().getTodaysTemp();
        return lookupWeatherService().getTodaysTemp();
    }

    @Lookup
    WeatherService lookupWeatherService() {
        return null;
    }
}
