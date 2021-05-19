package cn.edu.jxnu.rj.lrf.service.impl;

import cn.edu.jxnu.rj.lrf.dao.ProvinceMapper;
import cn.edu.jxnu.rj.lrf.entity.City;
import cn.edu.jxnu.rj.lrf.entity.Province;
import cn.edu.jxnu.rj.lrf.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname ProvinceServiceImpl
 * @Description TODO 省份实现类
 * @Date 2021/5/19 10:10
 * @Created by 李发勇
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceMapper provinceMapper;


    @Override
    public void update(Province province) {
        provinceMapper.updateByPrimaryKeySelective(province);
    }

    @Override
    public List<City> selectByCity(int pid) {
        return provinceMapper.selectByPid(pid);
    }

}
