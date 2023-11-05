package com.ll.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("t_file")
@Data
public class DBFile {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String fileName;
    private String fileType;
    private byte[] data;

}
