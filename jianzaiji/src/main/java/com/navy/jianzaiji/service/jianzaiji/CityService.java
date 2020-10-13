package com.navy.jianzaiji.service.jianzaiji;

import com.navy.jianzaiji.annotation.JianZaiJi;
import com.navy.jianzaiji.model.jianzaiji.City;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by 52613 on 2019/8/23.
 */
@JianZaiJi
public interface CityService {

    @RequestMapping("getPerson")
    City getPerson(@RequestParam("id") Integer id);

    @RequestMapping("getCity")
    List<City> getCity(@RequestParam("id") String id);

    @RequestMapping("addCity")
    String rediSetCityName(@RequestParam("cityName") String cityName, @RequestParam("introuduce") String introuduce);

    @RequestMapping(value = "getCityRedis")
    City getCityRedis(@RequestParam("cityName") String cityName);

}
