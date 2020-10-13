package com.navy.jian16.service;

import com.navy.jian16.repository.CityRepository;
import com.navy.jianzaiji.annotation.Facade;
import com.navy.jianzaiji.model.jianzaiji.City;
import com.navy.jianzaiji.service.jianzaiji.CityService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 52613 on 2019/8/23.
 */
@Facade
@Slf4j
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public City getPerson(Integer id) {
        log.debug("jian-16 getPerson id is : {}" ,id);
        return cityRepository.getCityById(id);
    }

    @Override
    public List<City> getCity(String id) {
        log.debug("jian-16 getCity id is : {}" , id);
        Map<String,Object> condition = new HashMap<>();
        condition.put("id",id);
        return cityRepository.getCity(condition);
    }


    @Override
    public String rediSetCityName(String cityName, String introuduce) {
        log.debug("rediSetCityName cityName is {} introuduce is {}",cityName,introuduce);
        City city  = new City(cityName, introuduce);
        redisTemplate.opsForValue().set(cityName,city);
        return city.toString();
    }

    @Override
    public City getCityRedis(@RequestParam("cityName") String cityName) {
        log.debug("执行jian-16 getCityRedis cityName is {}",cityName);
        Object result = redisTemplate.opsForValue().get(cityName);
        log.debug("jian-16 getCityRedis result is {}",result);
        return (City)result;
    }

}
