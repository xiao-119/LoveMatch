package com.ll.demo.config;

import com.ll.demo.entity.User;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
public class MySessionScopedBean {
    private User user;


    public String getWxId(){
        if (user == null) return null;
        return user.getWxId();}
}
