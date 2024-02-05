package com.wangsb.model;


import com.wangsb.annotation.StuCodeValid;
import com.wangsb.validation.group.AddStuAndTeach;
import com.wangsb.validation.group.AddStudent;
import com.wangsb.validation.group.QueryDetail;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author wangshenbing
 */
@Data
public class Student {

    @NotNull(message = "学生id不能为空",groups = QueryDetail.class)
    private Integer id;
    @NotNull(message = "学号不能为空",groups = AddStudent.class)
    @Length(min = 2, max = 4, message = "学号的长度范围是(2,4)")
    @StuCodeValid(groups = AddStudent.class,message = "学生的学号不能重复")
    private String stuCode;
    @NotNull(message = "姓名不能为空",groups = AddStudent.class)
    @Length(min = 2, max = 3, message = "姓名的长度范围是(2,3)",groups = AddStudent.class)
    private String stuName;
    @Valid
    @NotNull(message = "学生的老师不能为空", groups = AddStuAndTeach.class)
    private Teacher teacher;
}