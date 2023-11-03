package com.ll.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ll.demo.annotation.UpdateTime;
import com.ll.demo.validation.WxIdValid;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    @Schema(description = "用户ID")
    private Long id;

    @Schema(description = "微信ID",example = "110")
//    @NotEmpty(message = "微信ID不能为空")
    @WxIdValid(message = "wxId长度大于2")
    private String wxId;
    @Schema(description = "姓名",example = "韩梅梅")
    private String name;
    @Schema(description = "性别male female，必须为'男'或'女'",example = "female")
    @Pattern(regexp = "^(male|female)$", message = "性别必须为'男male'或'女female'")
    private String sex;
    @Schema(description = "星座",example = "白羊座")
    private String star;
    @Schema(description = "年龄",example = "25")
    private Integer age;
    @Schema(description = "身高",example = "188")
    private Integer height;
    @Schema(description = "学历",example = "本科")
    private String grade;
    @Schema(description = "毕业院校",example = "大清学院")
    private String school;
    @Schema(description = "所在单位",example = "财务")
    private String dept;
    @Schema(description = "爱好",example = "唱;跳;rap")
    private String hobby;
    @Schema(description = "特长",example = "emo")
    private String specialty;
    @Schema(description = "籍贯",example = "大清")
    private String birthPlace;
    @Schema(description = "居住地",example = "热河")
    private String address;
    @Schema(description = "是否删除 0未删除 1已删除",example = "0")
    private Integer isDel;
//    @Schema(description = "手机号",example = "119")
//    private String phoneNumber;
//    private String avatar;

    @Schema(description = "邮箱",example = "110@gmail.com")
    private String email;
    @UpdateTime
    private Date updateTime;

    private String role;

    public User(Long id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.updateTime = new Date();
    }
}
