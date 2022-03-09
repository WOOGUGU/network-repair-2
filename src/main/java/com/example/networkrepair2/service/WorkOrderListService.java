package com.example.networkrepair2.service;

import com.example.networkrepair2.pojo.WorkOrderList;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Lm
* @description 针对表【work_order_list(工单列表)】的数据库操作Service
* @createDate 2022-03-02 17:41:12
*/
public interface WorkOrderListService extends IService<WorkOrderList> {
    //通过学生学号查询工单列表
    List<WorkOrderList> selectAllByFkStudentNumber(Long fkStudentNumber);

    //通过工单编号查询工单列表
    WorkOrderList selectByWorkOrderNumber(Long workOrderNumber);

    //通过学号查看最近的工单
    WorkOrderList getLastOne(Long fkStudentNumber);

    //通过工单状态来获取工单
    List<WorkOrderList> searchAllByWorkOrderState(Integer workOrderState);

}
