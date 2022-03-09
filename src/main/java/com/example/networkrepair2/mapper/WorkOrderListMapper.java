package com.example.networkrepair2.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.example.networkrepair2.pojo.WorkOrderList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Lm
* @description 针对表【work_order_list(工单列表)】的数据库操作Mapper
* @createDate 2022-03-02 17:41:12
* @Entity com.example.networkrepair2.pojo.WorkOrderList
*/

@Mapper
public interface WorkOrderListMapper extends BaseMapper<WorkOrderList> {



    //通过学生学号查询工单列表
    List<WorkOrderList> selectAllByFkStudentNumber(@Param("fkStudentNumber") Long fkStudentNumber);

    //通过工单编号查询工单列表
    WorkOrderList selectByWorkOrderNumber(@Param("workOrderNumber") Long workOrderNumber);

    //通过学号查看最近的工单
    WorkOrderList getByFkStudentNumberAndMaxWorkOrderTime(@Param("fkStudentNumber") Long fkStudentNumber);

    //通过工单状态来获取工单
    List<WorkOrderList> selectAllByWorkOrderState(@Param("workOrderState") Integer workOrderState);

    //通过维修员编号获取工单
    List<WorkOrderList> selectAllByFkRepairmanNumber(@Param("fkRepairmanNumber") Long fkRepairmanNumber);





}




