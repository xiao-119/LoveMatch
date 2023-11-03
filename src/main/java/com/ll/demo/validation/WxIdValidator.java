package com.ll.demo.validation;

import cn.hutool.core.util.ObjectUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WxIdValidator implements ConstraintValidator<WxIdValid, String> {
    @Override
    public boolean isValid(final String wxId, final ConstraintValidatorContext context) {
        // @formatter:off
        return ObjectUtil.isNotEmpty(wxId) && wxId.length() > 2;
    }
}
