package com.example.networkrepair2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.networkrepair2.pojo.RepairmanList;
import com.example.networkrepair2.service.RepairmanListService;
import com.example.networkrepair2.mapper.RepairmanListMapper;
import org.springframework.stereotype.Service;

/**
* @author Lm
* @description 针对表【repairman_list(维修员账号)】的数据库操作Service实现
* @createDate 2022-03-02 17:41:12
*/
@Service
public class RepairmanListServiceImpl extends ServiceImpl<RepairmanListMapper, RepairmanList>
    implements RepairmanListService{

}




