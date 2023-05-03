package com.ll.demo.util;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageUtils {

    public static <E> PageInfo<E> replace(PageInfo<?> pageSrc, Class<E> tClass) {
        List<?> list = pageSrc.getList();
        List<E> es = BeanUtil.copyToList(list, tClass);

        PageInfo<E> pageResult = new PageInfo<>();
        BeanUtil.copyProperties(pageSrc, pageResult);
        pageResult.setList(es);
        return pageResult;
    }

}
