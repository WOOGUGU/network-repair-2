package com.example.networkrepair2.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.example.networkrepair2.pojo.AdministratorList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author WOOGUGU
* @description 针对表【administrator_list(管理员账号)】的数据库操作Mapper
* @createDate 2022-03-02 15:01:30
* @Entity com.example.networkrepair2.pojo.AdministratorList
*/

@Mapper
public interface AdministratorListMapper extends BaseMapper<AdministratorList> {
    List<AdministratorList> selectAllByAdministratorNumber(@Param("administratorNumber") Long administratorNumber);
}




