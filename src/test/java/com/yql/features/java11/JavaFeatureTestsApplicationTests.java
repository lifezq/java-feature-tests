package com.yql.features.java11;

import com.yql.features.java11.service.UserService;
import com.yql.features.java11.service.WeatherService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class JavaFeatureTestsApplicationTests {
    @Autowired
    ApplicationContext context;

    @Test
    void singletonBeanTest() {
        UserService userService1 = context.getBean("userService", UserService.class);
        UserService userService2 = context.getBean("userService", UserService.class);
        Assertions.assertEquals(userService1.hashCode(), userService2.hashCode());
    }

    @Test
    void prototypeBeanScopeTest() {
        WeatherService weatherService1 = context.getBean("weatherService", WeatherService.class);
        WeatherService weatherService2 = context.getBean("weatherService", WeatherService.class);
        Assertions.assertNotEquals(weatherService1.hashCode(), weatherService2.hashCode());
    }
}
