package com.example.networkrepair2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.networkrepair2.pojo.AdministratorList;
import com.example.networkrepair2.service.AdministratorListService;
import com.example.networkrepair2.mapper.AdministratorListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Lm
* @description 针对表【administrator_list(管理员账号)】的数据库操作Service实现
* @createDate 2022-03-02 17:41:12
*/
@Service
public class AdministratorListServiceImpl extends ServiceImpl<AdministratorListMapper, AdministratorList>
    implements AdministratorListService{

    @Autowired(required = false)
    AdministratorListMapper administratorListMapper;

    @Override
    public AdministratorList getBYId(Long administratorNumber) {
        return administratorListMapper.selectAllByAdministratorNumber(administratorNumber);
    }

}




