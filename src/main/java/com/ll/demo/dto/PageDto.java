package com.ll.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class PageDto {
    @Min(value = 1, message = "页码最小为1")
    @Schema(description = "页码序号")
    Integer pageNo;


    // @Size(min = 1, max = 10, message = "页码最小为1")
    @Min(value = 1, message = "页大小最小为1")
    @Schema(description = "单页大小")
    Integer pageSize;


    @NotNull(message = "msg不能为空")
    String msg;
}
