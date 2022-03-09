package com.example.networkrepair2.mapper;

import com.example.networkrepair2.pojo.AdministratorList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Lm
* @description 针对表【administrator_list(管理员账号)】的数据库操作Mapper
* @createDate 2022-03-02 17:41:12
* @Entity com.example.networkrepair2.pojo.AdministratorList
*/

@Mapper
public interface AdministratorListMapper extends BaseMapper<AdministratorList> {
    //通过管理员工号查询账户
    AdministratorList selectAllByAdministratorNumber(@Param("administratorNumber") Long administratorNumber);


}




