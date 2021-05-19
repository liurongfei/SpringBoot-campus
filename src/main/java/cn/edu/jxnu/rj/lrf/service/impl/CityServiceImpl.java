package cn.edu.jxnu.rj.lrf.service.impl;

import cn.edu.jxnu.rj.lrf.dao.CityMapper;
import cn.edu.jxnu.rj.lrf.entity.City;
import cn.edu.jxnu.rj.lrf.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname CityServiceImpl
 * @Description TODO 城市实现类
 * @Date 2021/5/19 10:09
 * @Created by 李发勇
 */
@Service
public class CityServiceImpl  implements CityService {
    @Autowired
    CityMapper cityMapper;


    @Override
    public void update(City city) {
        cityMapper.updateByPrimaryKeySelective(city);

    }

    @Override
    public List<City> selectByCity(int cid) {
        return cityMapper.selectByCity(cid);
    }
}
