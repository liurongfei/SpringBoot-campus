package cn.edu.jxnu.rj.lrf.controller;

import cn.edu.jxnu.rj.lrf.common.ResponseModel;
import cn.edu.jxnu.rj.lrf.entity.City;
import cn.edu.jxnu.rj.lrf.entity.Province;
import cn.edu.jxnu.rj.lrf.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname ProvinceController
 * @Description TODO 省份控制层
 * @Date 2021/5/19 10:21
 * @Created by 李发勇
 */
@RestController
@RequestMapping("/province")
public class ProvinceController {

    @Autowired
    ProvinceService provinceService;

    /**
     * @Description //TODO  修改城市信息
     * @Param [province]
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @PostMapping("/updateProvince")
    public ResponseModel updateProvince(Province province){
        provinceService.update(province);
        return new ResponseModel();
    }


    /**
     * @Description //TODO  选择省份信息
     * @Param [pid]
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @GetMapping("/selectProvince")
    public ResponseModel selectProvince(int pid){
        List<City> list = provinceService.selectByCity(pid);
        return new ResponseModel(list);
    }

}
