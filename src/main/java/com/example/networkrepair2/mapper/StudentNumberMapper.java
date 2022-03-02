package com.example.networkrepair2.mapper;

import com.example.networkrepair2.pojo.StudentNumber;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author WOOGUGU
* @description 针对表【student_number(学生基本信息表)】的数据库操作Mapper
* @createDate 2022-03-02 15:01:30
* @Entity com.example.networkrepair2.pojo.StudentNumber
*/

@Mapper
public interface StudentNumberMapper extends BaseMapper<StudentNumber> {

}




