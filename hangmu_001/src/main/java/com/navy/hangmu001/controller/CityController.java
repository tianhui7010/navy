package com.navy.hangmu001.controller;

import com.navy.hangmu001.utils.lisher.ControllerEventPubLisher;
import com.navy.hangmu001.utils.response.Response;
import com.navy.jianzaiji.model.jianzaiji.City;
import com.navy.jianzaiji.model.user.User;
import com.navy.jianzaiji.service.jianzaiji.CityService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CityService cityService;

    @Autowired
    private ControllerEventPubLisher publisher;

    @RequestMapping("hahhahaha")
    public Response hahhahaha() {
        log.debug("hangmu_001 String id");
        return Response.success("测试");
    }

    /**
     * springCloud 第一种调用方式 restTemplate
     */
    @RequestMapping("getCity")
    public Response getCity(String id) {
        log.debug("hangmu_001 getCity");
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        log.debug("hangmu_001 获取 user is {} ", user);
        List<City> forObject = restTemplate.getForObject("http://jian-15/getCity?id=" + id, List.class);
        publisher.pushListener("hangmu_001 监听器执行：getCity");

        logger.debug("结果是 {}", forObject);
        return Response.success(forObject);
    }

    /**
     * springCloud 第二种调用方式 @EnableFeignClients + @FeignClient
     */
    @RequestMapping("getPerson")
//    @HystrixCommand(fallbackMethod = "getFallback")
    public Response getCityService(Integer id) {
        log.debug("hangmu_001 getPerson");
        City person = cityService.getPerson(id);
        publisher.pushListener("hangmu_001 监听器执行：getPerson");
//        String str = null;
//        str.toString();
        return Response.success(person);
    }

    @RequestMapping("testYbp")
    @HystrixCommand(fallbackMethod = "getFallback")
    public Response testYbp(Integer id) {
        log.debug("hangmu_001 testYbp");
        City person = cityService.getPerson(id);
        publisher.pushListener("hangmu_001 监听器执行：getPerson");
        return Response.success(person);
    }

    /**
     * springCloud hystrix 容错处理
     */
    public Response getFallback(Integer id) {
        return Response.error("执行方法失败！由hystrix处理异常方法！");
    }


    /**
     *
     */
    @RequestMapping("setCityRedis")
    public String setCityRedis(String cityName, String introuduce) {
        log.debug("hangmu_001 rediSetCityName cityName is {} introuduce is {}" ,cityName, introuduce);
        String addResult = cityService.setCityRedis(cityName, introuduce);
        log.debug("hangmu_001 rediSetCityName is {}" , addResult);
        return addResult;
    }

    /**
     * redis get
     */
    @RequestMapping("getCityRedis")
    public City getCityRedis(String cityName) {
        log.debug("执行 hangmu_001 getCityRedis cityName is {}" , cityName);
        City city = cityService.getCityRedis(cityName);
        log.debug("hangmu_001 getCityRedis is {}" , city);
        return city;

    }

    /**
     * 分布式 getCity
     */
    @RequestMapping("getCityByService")
    public Response getCityByService(String id) {
        log.debug("hangmu_001 getCityByService id is {}",id);
        List<City> city = cityService.getCity(id);
        return Response.success(city);
    }
}
