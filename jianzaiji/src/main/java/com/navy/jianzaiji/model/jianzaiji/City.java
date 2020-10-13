package com.navy.jianzaiji.model.jianzaiji;

import java.io.Serializable;

/**
 * City
 */
public class City implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String cityName;
    private String introuduce;

    public City() {
    }

    public City(String cityName, String introuduce) {
        this.cityName = cityName;
        this.introuduce = introuduce;
    }

    public City(Integer id, String cityName, String introuduce) {
        this.id = id;
        this.cityName = cityName;
        this.introuduce = introuduce;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getIntrouduce() {
        return introuduce;
    }

    public void setIntrouduce(String introuduce) {
        this.introuduce = introuduce;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("City{");
        sb.append("id=").append(id);
        sb.append(", cityName='").append(cityName).append('\'');
        sb.append(", introuduce='").append(introuduce).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
