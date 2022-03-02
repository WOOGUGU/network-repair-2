package com.example.networkrepair2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.networkrepair2.pojo.WorkOrderList;
import com.example.networkrepair2.service.WorkOrderListService;
import com.example.networkrepair2.mapper.WorkOrderListMapper;
import org.springframework.stereotype.Service;

/**
* @author WOOGUGU
* @description 针对表【work_order_list(工单列表)】的数据库操作Service实现
* @createDate 2022-03-02 15:01:31
*/
@Service
public class WorkOrderListServiceImpl extends ServiceImpl<WorkOrderListMapper, WorkOrderList>
    implements WorkOrderListService{

}




