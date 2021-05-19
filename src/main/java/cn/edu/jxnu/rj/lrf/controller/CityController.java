package cn.edu.jxnu.rj.lrf.controller;

import cn.edu.jxnu.rj.lrf.common.ResponseModel;
import cn.edu.jxnu.rj.lrf.entity.City;
import cn.edu.jxnu.rj.lrf.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname CityController
 * @Description TODO 城市表控制层
 * @Date 2021/5/19 10:20
 * @Created by 李发勇
 */
@RestController
@RequestMapping("/city")
public class CityController {


    @Autowired
    CityService cityService;



    /**
     * @Description //TODO  修改城市
     * @Param [city]
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @PostMapping("/update")
    public ResponseModel updateCity(City city){
        cityService.update(city);
        return new ResponseModel();
    }


    /**
     * @Description //TODO 查找城市信息
     * @Param [cid]
     * @return cn.edu.jxnu.rj.lrf.common.ResponseModel
     **/
    @GetMapping("/selectCity")
    public ResponseModel selectCity(int cid){
        List <City> list =cityService.selectByCity(cid);
        return new ResponseModel(list);
    }

}
