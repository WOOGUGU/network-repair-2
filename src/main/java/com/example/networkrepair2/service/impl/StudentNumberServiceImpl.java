package com.example.networkrepair2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.networkrepair2.pojo.StudentNumber;
import com.example.networkrepair2.service.StudentNumberService;
import com.example.networkrepair2.mapper.StudentNumberMapper;
import org.springframework.stereotype.Service;

/**
* @author WOOGUGU
* @description 针对表【student_number(学生基本信息表)】的数据库操作Service实现
* @createDate 2022-03-02 15:01:30
*/
@Service
public class StudentNumberServiceImpl extends ServiceImpl<StudentNumberMapper, StudentNumber>
    implements StudentNumberService{

}




