package com.example.demo.config;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * TODO
 *
 * @author LWP
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
public class CaptchaConfig {
    @Bean(name = "captchaProducer")
    public DefaultKaptcha getKaptchaBeanMath()
    {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        // 是否有边框 默认为true 我们可以自己设置yes，no
        properties.setProperty(Constants.KAPTCHA_BORDER, "yes");
        // 边框颜色 默认为Color.BLACK
        properties.setProperty(Constants.KAPTCHA_BORDER_COLOR, "105,179,90");
        //设置边框的厚度
        properties.setProperty (Constants.KAPTCHA_BORDER_THICKNESS,"1");
        // 验证码干扰的颜色 默认为Color.BLACK
        properties.setProperty(Constants.KAPTCHA_NOISE_COLOR, "black");
        // 验证码干扰实现类  DefaultNoise默认干扰   NoNoise无干扰
        //com.google.code.kaptcha.impl.DefaultNoise
        //com.google.code.kaptcha.impl.NoNoise
        properties.setProperty(Constants.KAPTCHA_NOISE_IMPL, "com.google.code.kaptcha.impl.DefaultNoise");
        //验证码图片样式
        //  水纹com.google.code.kaptcha.impl.WaterRipple
        //  鱼眼com.google.code.kaptcha.impl.FishEyeGimpy
        //  阴影com.google.code.kaptcha.impl.ShadowGimpy
        properties.setProperty(Constants.KAPTCHA_OBSCURIFICATOR_IMPL, "com.google.code.kaptcha.impl.WaterRipple");
        // 生成图片验证码 支持扩展，自己可以写一个生成验证码图片的类，
        //properties.setProperty(Constants.KAPTCHA_PRODUCER_IMPL, "com.google.code.kaptcha.impl.DefaultKaptcha");
        // 验证码文本生成器
        // properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_IMPL, "com.qjwl.rabbitmq.config.KaptchaTextCreator");
        //文本生成器生成的文本集合，验证码值从此集合中获取
        properties.setProperty (Constants.KAPTCHA_TEXTPRODUCER_CHAR_STRING,"123456789");
        // 验证码文本字符数量 默认为5
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "4");
        // 验证码文本字体样式 Arial,Courier
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, "Courier");
        // 验证码文本字符颜色 默认为Color.BLACK
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "blue");
        // 验证码文本字符大小 默认为40
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "30");
        // 验证码文本字符间距 默认为2
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE, "5");
        // 生成验证码文本的文字渲染器
        properties.setProperty(Constants.KAPTCHA_WORDRENDERER_IMPL, "com.google.code.kaptcha.text.impl.DefaultWordRenderer");
        //设置验证码图片的背景类
        properties.setProperty (Constants.KAPTCHA_BACKGROUND_IMPL,"com.google.code.kaptcha.impl.DefaultBackground");
        //设置验证码图片的背景渐变色(开始)
        properties.setProperty (Constants.KAPTCHA_BACKGROUND_CLR_FROM,"105,179,90");
        //设置验证码图片的背景渐变色(结束)
        properties.setProperty (Constants.KAPTCHA_BACKGROUND_CLR_TO,"255,23,140");
        // 验证码图片宽度 默认为200
        properties.setProperty(Constants.KAPTCHA_IMAGE_WIDTH, "110");
        // 验证码图片高度 默认为50
        properties.setProperty(Constants.KAPTCHA_IMAGE_HEIGHT, "40");
        // 验证码文本生成器(自定义)
      //  properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_IMPL, "com.trs.cpec.modular.verification.MathExpressionTextCreator");

        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
