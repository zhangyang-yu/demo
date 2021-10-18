package com.example.demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 验证码
 */

@Data
@ApiModel(value = "CaptchaVo对象",description = "验证码标识")
public class CaptchaVo {

    @ApiModelProperty(value = "验证码标识符")
    private String captchaKey;

    @ApiModelProperty(value = "验证码过期时间")
    private  Long expire;

    @ApiModelProperty(value = "base64图片字符串")
    private  String base64Img;
}
