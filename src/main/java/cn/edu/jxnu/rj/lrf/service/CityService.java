package cn.edu.jxnu.rj.lrf.service;

import cn.edu.jxnu.rj.lrf.entity.City;

import java.util.List;

/**
 * @Classname CityService
 * @Description TODO 城市
 * @Date 2021/5/19 10:01
 * @Created by 李发勇
 */
public interface CityService {
    /**
     * @Description //TODO  修改城市
     * @Param [city]
     * @return void
     **/
    void update(City city);

    /**
     * @Description //TODO  查找城市并且显示省份
     * @Param [cid]
     * @return java.util.List<cn.edu.jxnu.rj.lrf.entity.City>
     **/
   List<City> selectByCity(int cid);

}
