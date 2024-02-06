package com.wangsb.validation.Validator;

import com.wangsb.annotation.SexValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangshenbing
 */
public class SexValidator implements ConstraintValidator<SexValid, String> {

    private String[] values;

    @Override
    public void initialize(SexValid constraintAnnotation) {
        this.values = constraintAnnotation.value();
    }

    /**
     * 参数有效性校验
     *
     * @param value
     * @param context
     * @return 如果参数有效, 返回true;否则false
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<String> list = Arrays.asList(values);
        if (value == null) {
            return false;
        }
        return list.contains(value);
    }
}