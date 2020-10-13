package com.navy.jian16.repository;

import com.navy.jianzaiji.model.jianzaiji.City;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * CityRepository
 */
@Repository
public interface CityRepository {

    City getCityById(Integer id);

    List<City> getCity(Map<String, Object> id);

    Integer insertCity(City city);

}
