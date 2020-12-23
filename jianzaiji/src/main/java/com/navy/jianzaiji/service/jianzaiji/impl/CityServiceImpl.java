package com.navy.jianzaiji.service.jianzaiji.impl;

import com.navy.jianzaiji.model.jianzaiji.City;
import com.navy.jianzaiji.service.jianzaiji.CityService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by tian on 2020/12/22.
 */
@Component
public class CityServiceImpl implements FallbackFactory<CityService> {

    @Override
    public CityService create(Throwable throwable) {
        return new CityService() {
            @Override
            public City getPerson(@RequestParam("id") Integer id) {
                return new City("测试断路", "断路");
            }

            @Override
            public List<City> getCity(@RequestParam("id") String id) {
                return null;
            }

            @Override
            public String setCityRedis(@RequestParam("cityName") String cityName, @RequestParam("introuduce") String introuduce) {
                return null;
            }

            @Override
            public City getCityRedis(@RequestParam("cityName") String cityName) {
                return null;
            }
        };
    }
}