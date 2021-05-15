package cn.edu.jxnu.rj.lrf.controller;

import cn.edu.jxnu.rj.lrf.common.BusinessException;
import cn.edu.jxnu.rj.lrf.common.ErrorCodeEnum;
import cn.edu.jxnu.rj.lrf.common.ResponseModel;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author liu rong fei
 * @title: UtilController
 * @description:
 * @date: 2021/4/16 16:31
 */
@RestController
@RequestMapping("/util")
public class UtilController {
    private Logger logger = LoggerFactory.getLogger(UtilController.class);

    @Autowired
    private Producer producer;
    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/kaptcha.jpg")
    public void kaptcha(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setHeader("Cache-Control", "no-store,no-cache");
        response.setContentType("image/jpeg");
        //生成文字验证码
        String text=producer.createText();
        //生成图片验证码
        BufferedImage image=producer.createImage(text);
        //保存验证码到session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        ServletOutputStream out=response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        //用到IO工具包控制开关
        IOUtils.closeQuietly(out);
    }
}
