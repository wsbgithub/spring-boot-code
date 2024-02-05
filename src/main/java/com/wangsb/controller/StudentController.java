package com.wangsb.controller;

import com.wangsb.group.AddStuAndTeach;
import com.wangsb.group.AddStudent;
import com.wangsb.group.QueryDetail;
import com.wangsb.model.Student;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author wangshenbing
 */
@RestController
@RequestMapping("/student")
@Validated
public class StudentController {
    @GetMapping("/{sex}/info")
    public String getBySex(@PathVariable("sex") @Pattern(regexp = "boy||girl", message = "学生性别只能是boy或girl") String sex) {
        System.out.println("学生性别:" + sex);
        return "success";
    }

    @GetMapping("/getOne")
    public String getOne(@NotNull(message = "学生姓名不能为空") String stuName, @NotNull(message = "学生学号不能为空") String stuCode) {
        System.out.println("stuName:" + stuName + ",stuCode:" + stuCode);
        return "success";
    }

    @PostMapping("/addStuaAndTeach")
    public String addStuaAndTeach(@Validated(AddStuAndTeach.class) @RequestBody Student student){
        System.out.println("学生的工号:"+student.getStuCode()+",学生的老师的姓名:"+student.getTeacher().getTecName());
        return "success";
    }

    @PostMapping("/add")
    public Student add(@Validated(AddStudent.class) @RequestBody Student student) {
        System.out.println(student.getStuName());
        return student;
    }

    @PostMapping("/detail")
    public String detail(@Validated(QueryDetail.class)@RequestBody Student student){
        System.out.println("学生id:"+student.getId());
        return "success";
    }
}