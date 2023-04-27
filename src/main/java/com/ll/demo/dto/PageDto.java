package com.ll.demo.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PageDto {
    @Min(value = 1, message = "页码最小为1")
    Integer pageNo;


    // @Size(min = 1, max = 10, message = "页码最小为1")
    @Min(value = 1, message = "页大小最小为1")
    Integer pageSize;


    @NotNull(message = "msg不能为空")
    String msg;
}
