package com.example.demo.controller;

import com.example.demo.vo.CaptchaVo;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class authController {

    @Autowired
    private DefaultKaptcha captchaProducer;
    @GetMapping("/getCaptcha")
    public CaptchaVo getCaptcha() throws IOException {
        //生成文字验证码
        String text = captchaProducer.createText ();
        System.out.println (text);
        //把文字验证码转成图片验证码
        BufferedImage image = captchaProducer.createImage (text);

        ByteArrayOutputStream outputStream=new ByteArrayOutputStream ();
        ImageIO.write (image,"jpg",outputStream);
        //对字节数组Base64编码
        BASE64Encoder encoder=new BASE64Encoder ();

        String str="data:image/jpeg;base64,";

        String base64Img =str+encoder.encode (outputStream.toByteArray ()).replace ("\n","").replace ("\r","");

        CaptchaVo captchaVo = new CaptchaVo ();
        captchaVo.setBase64Img (base64Img);
        return captchaVo;
    }
}
