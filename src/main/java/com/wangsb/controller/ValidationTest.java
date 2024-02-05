package com.wangsb.controller;

import com.wangsb.model.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author wangshenbing
 * @date 2024/02/06
 **/
@RestController
@RequestMapping("/validation/")
public class ValidationTest {

    @PostMapping("add")
    public Student add(@Valid @RequestBody Student student){
        System.out.println(student.getStuName());
        return student;
    }
}