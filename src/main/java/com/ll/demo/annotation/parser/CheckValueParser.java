package com.ll.demo.annotation.parser;

import com.ll.demo.annotation.CheckValue;

import java.lang.reflect.Field;

public class CheckValueParser {

    /**
     * 解析CheckValue注解
     *
     * @param o 解析对象
     */
    public static Object parse(Object o) {
        try {
            Class<?> mClass = o.getClass();
            Field[] fields = mClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(CheckValue.class)) {
                    // 获取当前field设置的注解
                    CheckValue checkValue = field.getAnnotation(CheckValue.class);
                    String value = checkValue.value();
                    field.setAccessible(true);
                    Object fieldValue = field.get(o);

                    System.out.println("value = " + value);
                    System.out.println("fieldValue = " + fieldValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }
}
