package cn.edu.jxnu.rj.lrf.controller;

import cn.edu.jxnu.rj.lrf.service.MomentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liu rong fei
 * @title: MomentsController
 * @description:
 * @date: 2021/4/18 10:42
 */
@RestController
@RequestMapping("/moments")
public class MomentsController {
    @Autowired
    MomentsService momentsService;

}
