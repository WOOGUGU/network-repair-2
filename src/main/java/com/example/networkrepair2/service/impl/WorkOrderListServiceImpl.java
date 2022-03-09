package com.example.networkrepair2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.networkrepair2.pojo.WorkOrderList;
import com.example.networkrepair2.service.WorkOrderListService;
import com.example.networkrepair2.mapper.WorkOrderListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Lm
* @description 针对表【work_order_list(工单列表)】的数据库操作Service实现
* @createDate 2022-03-02 17:41:12
*/
@Service
public class WorkOrderListServiceImpl extends ServiceImpl<WorkOrderListMapper, WorkOrderList>
    implements WorkOrderListService{

    @Autowired(required = false)
    WorkOrderListMapper workOrderListMapper;

    //通过学生学号查询工单列表
    @Override
    public List<WorkOrderList> selectAllByFkStudentNumber(Long fkStudentNumber) {
        return workOrderListMapper.selectAllByFkStudentNumber(fkStudentNumber);
    }

    //通过工单编号查询工单列表
    @Override
    public WorkOrderList selectByWorkOrderNumber(Long workOrderNumber) {
        return workOrderListMapper.selectByWorkOrderNumber(workOrderNumber);
    }

    //通过学号查看最近的工单
    @Override
    public WorkOrderList getLastOne(Long fkStudentNumber) {
        return workOrderListMapper.getByFkStudentNumberAndMaxWorkOrderTime(fkStudentNumber);
    }

    @Override
    public List<WorkOrderList> searchAllByWorkOrderState(Integer workOrderState) {
        return workOrderListMapper.selectAllByWorkOrderState(workOrderState);
    }

    @Override
    public boolean updateById(WorkOrderList entity) {
        return super.updateById(entity);
    }
}




