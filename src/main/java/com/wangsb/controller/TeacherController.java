package com.wangsb.controller;

import com.wangsb.model.Teacher;
import com.wangsb.validation.common.ValidationList;
import com.wangsb.validation.group.AddStuAndTeach;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @PostMapping("/add")
    public String add(@Validated(AddStuAndTeach.class) @RequestBody ValidationList<Teacher> teachers) {
        System.out.println("添加老师:" + teachers.size());
        return "success";
    }
}