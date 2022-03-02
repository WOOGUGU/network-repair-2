package com.example.networkrepair2.mapper;

import com.example.networkrepair2.pojo.WorkOrderList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author WOOGUGU
* @description 针对表【work_order_list(工单列表)】的数据库操作Mapper
* @createDate 2022-03-02 15:01:31
* @Entity com.example.networkrepair2.pojo.WorkOrderList
*/

@Mapper
public interface WorkOrderListMapper extends BaseMapper<WorkOrderList> {

}




