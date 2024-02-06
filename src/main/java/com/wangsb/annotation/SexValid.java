package com.wangsb.annotation;

import com.wangsb.validation.Validator.SexValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author wangshenbing
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Documented
@Constraint(validatedBy = SexValidator.class)
public @interface SexValid {
    //定义注解的里值
    String[] value() default {"男","女"};
    //定义异常信息
    String message() default "性别格式错误,请更正";
    //如果是需要分组校验,这个属性就用得上了
    Class<?>[] groups() default {};
    //这个可以携带无
    Class<? extends Payload>[] payload() default {};
}