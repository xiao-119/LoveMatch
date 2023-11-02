package com.ll.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ll.demo.annotation.UpdateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String wxId;
    // 只能是英文
    private String name;
    @Schema(description = "性别male female，必须为'男'或'女'",example = "female")
    @Pattern(regexp = "^(male|female)$", message = "性别必须为'男male'或'女female'")
    private String sex;
    @Schema(description = "年龄",example = "25")
    private Integer age;

    @Schema(description = "手机号",example = "119")
    private String phoneNumber;
    private String avatar;

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
