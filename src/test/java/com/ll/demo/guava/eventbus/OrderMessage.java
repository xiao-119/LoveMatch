package com.ll.demo.guava.eventbus;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @name: OrderMessage
 * @author: tuacy.
 * @date: 2019/7/9.
 * @version: 1.0
 * @Description: 命令消息
 */
@Data
@AllArgsConstructor
public class OrderMessage {
    
    /**
     * 命令对应的内容
     */
    private String orderContent;


    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }
}