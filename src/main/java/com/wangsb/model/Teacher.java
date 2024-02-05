package com.wangsb.model;

import com.wangsb.validation.group.AddStuAndTeach;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author wangshenbing
 */
@Data
public class Teacher {
    @NotBlank(message = "学生的老师姓名不能为null或者\"\"",groups = AddStuAndTeach.class)
    private String tecName;
    @NotNull(message = "学生的老师教授科目不能为空",groups = AddStuAndTeach.class)
    private String subject;
}