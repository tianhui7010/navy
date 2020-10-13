package com.navy.hangmu002.controller;

import com.navy.hangmu002.utils.lisher.ControllerEventPubLisher;
import com.navy.hangmu002.utils.response.Response;
import com.navy.jianzaiji.model.jianzaiji.City;
import com.navy.jianzaiji.model.user.User;
import com.navy.jianzaiji.service.jianzaiji.CityService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


/**
 * CityController
 */
@RestController
@Slf4j
public class CityController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CityService cityService;

    @Autowired
    private ControllerEventPubLisher publisher;

    /**
     * springCloud 第一种调用方式 restTemplate
     */
    @RequestMapping("getCity")
    public Response getCity(String id) {
        System.out.println("hangmu_002 getCity");
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        log.debug("hangmu_002 获取 user is {} ", user);
        List<City> forObject = restTemplate.getForObject("http://jian-15/getCity?id=" + id, List.class);
        publisher.pushListener("hangmu_002 监听器执行：getCity");

        log.debug("结果是 {}", forObject);
        return Response.success(forObject);
    }

    /**
     * springCloud 第二种调用方式 @EnableFeignClients + @FeignClient
     */
    @RequestMapping("getPerson")
    @HystrixCommand(fallbackMethod = "fallback")
    public Response getCityService(Integer id) {
        log.debug("hangmu_002 getPerson");
        City person = cityService.getPerson(id);
        publisher.pushListener("hangmu_002 监听器执行：getPerson");
        return Response.success(person);
    }

    /**
     * springCloud hystrix 容错处理
     */
    public Response fallback(Integer id) {
        return Response.error("hangmu_002 执行方法失败！由hystrix处理异常方法！");
    }


    /**
     *
     */
    @RequestMapping("rediSetCityName")
    public String rediSetCityName(String cityName, String introuduce) {
        log.debug("hangmu_002 rediSetCityName cityName is {} introuduce is {}" ,cityName, introuduce);
        String addResult = cityService.rediSetCityName(cityName, introuduce);
        log.debug("hangmu_002 rediSetCityName is {}" , addResult);
        return addResult;
    }

    /**
     * redis get
     */
    @RequestMapping("getCityRedis")
    public City getCityRedis(String cityName) {
        log.debug("hangmu_002 getCityRedis cityName is {}" , cityName);
        City city = cityService.getCityRedis(cityName);
        log.debug("hangmu_002 getCityRedis is {}" , city);
        return city;

    }

    /**
     * 分布式 getCity
     */
    @RequestMapping("getCityByService")
    public Response getCityByService(String id) {
        log.debug("hangmu_002 getCityByService id is {}",id);
        List<City> city = cityService.getCity(id);
        return Response.success(city);
    }
}
