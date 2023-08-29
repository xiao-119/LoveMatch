package com.ll.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ll.demo.annotation.CheckValue;
import com.ll.demo.annotation.UpdateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
    @TableId
    private Long id;
    private String name;

    @CheckValue("整数 18-20")
    private Integer age;
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
