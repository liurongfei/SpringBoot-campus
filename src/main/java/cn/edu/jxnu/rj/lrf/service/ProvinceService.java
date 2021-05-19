package cn.edu.jxnu.rj.lrf.service;

import cn.edu.jxnu.rj.lrf.entity.City;
import cn.edu.jxnu.rj.lrf.entity.Province;

import java.util.List;

/**
 * @Classname ProvinceService
 * @Description TODO 省会
 * @Date 2021/5/19 10:01
 * @Created by 李发勇
 */
public interface ProvinceService {
    /**
     * @Description //TODO  修改省会
     * @Param [city]
     * @return void
     **/
    void update(Province province);

    /**
     * @Description //TODO  查找省份,并显示城市
     * @Param [cid]
     * @return java.util.List<cn.edu.jxnu.rj.lrf.entity.City>
     **/
    List<City> selectByCity(int pid);
}
