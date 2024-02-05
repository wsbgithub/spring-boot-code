package com.wangsb.validation.Validator;

import com.wangsb.annotation.StuCodeValid;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * @author wangshenbing
 */
@Component
public class StuCodeValidator implements ConstraintValidator<StuCodeValid, String> {

    /**
     * 参数有效性校验
     *
     * @param value
     * @param context 校验规则:
     *                如果学生学号发生重复为无效返回false;
     *                如果学生学号不重复会有效,则返回true;
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        //查询学号是否重复,如果重复返回true,否则近回false;
        List<String> stuCodeList = List.of("sw28556");
        return !stuCodeList.contains(value);
    }
}