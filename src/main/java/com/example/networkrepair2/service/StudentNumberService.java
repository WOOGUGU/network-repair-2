package com.example.networkrepair2.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.networkrepair2.pojo.StudentNumber;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Lm
* @description 针对表【student_number(学生基本信息表)】的数据库操作Service
* @createDate 2022-03-02 17:41:12
*/
public interface StudentNumberService extends IService<StudentNumber> {
    public StudentNumber getOne(Wrapper<StudentNumber> queryWrapper);
}
