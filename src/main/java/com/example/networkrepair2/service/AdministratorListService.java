package com.example.networkrepair2.service;

import com.example.networkrepair2.pojo.AdministratorList;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Lm
* @description 针对表【administrator_list(管理员账号)】的数据库操作Service
* @createDate 2022-03-02 17:41:12
*/
public interface AdministratorListService extends IService<AdministratorList> {
    public AdministratorList getBYId(Long administratorNumber);

}
