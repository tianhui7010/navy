package com.navy.jianzaiji.service.jianzaiji;

import com.navy.jianzaiji.annotation.JianZaiJi;
import com.navy.jianzaiji.model.jianzaiji.City;
//import com.navy.jianzaiji.service.jianzaiji.impl.CityServiceImpl;
import com.navy.jianzaiji.service.jianzaiji.impl.CityServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by 52613 on 2019/8/23.
 */
@JianZaiJi
@FeignClient(value = JianZaiJi.JIAN15,fallbackFactory = CityServiceImpl.class)
public interface CityService {

    @RequestMapping("getPerson")
    City getPerson(@RequestParam("id") Integer id);

    @RequestMapping("getCity")
    List<City> getCity(@RequestParam("id") String id);

    @RequestMapping("addCity")
    String setCityRedis(@RequestParam("cityName") String cityName, @RequestParam("introuduce") String introuduce);

    @RequestMapping(value = "getCityRedis")
    City getCityRedis(@RequestParam("cityName") String cityName);

}
