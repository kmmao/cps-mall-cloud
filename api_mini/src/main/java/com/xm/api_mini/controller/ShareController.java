package com.xm.api_mini.controller;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import com.xm.api_mini.poster.GoodsPoster;
import com.xm.comment_serialize.module.mall.ex.SmProductEntityEx;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@RequestMapping("/share")
@Controller
public class ShareController {

    @GetMapping(value = "/goods",produces = MediaType.IMAGE_PNG_VALUE)
    public void goods(SmProductEntityEx smProductEntityEx, HttpServletResponse res) throws IOException {
        long time = System.currentTimeMillis();
        try {
            BufferedImage image = new GoodsPoster(smProductEntityEx).draw();
            System.out.println(System.currentTimeMillis() - time);
//            ImageIO.write(image,"png",res.getOutputStream());
            ImgUtil.writePng(image,res.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(System.currentTimeMillis() - time);
        }

    }

}
