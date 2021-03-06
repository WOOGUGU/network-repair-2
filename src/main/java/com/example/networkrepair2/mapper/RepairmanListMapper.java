package com.example.networkrepair2.mapper;

import com.example.networkrepair2.pojo.RepairmanList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Lm
* @description 针对表【repairman_list(维修员账号)】的数据库操作Mapper
* @createDate 2022-03-02 17:41:12
* @Entity com.example.networkrepair2.pojo.RepairmanList
*/

@Mapper
public interface RepairmanListMapper extends BaseMapper<RepairmanList> {

}




