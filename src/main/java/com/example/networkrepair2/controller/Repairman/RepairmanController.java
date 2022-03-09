package com.example.networkrepair2.controller.Repairman;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.networkrepair2.pojo.RepairmanList;
import com.example.networkrepair2.pojo.WorkOrderList;
import com.example.networkrepair2.service.impl.RepairmanListServiceImpl;
import com.example.networkrepair2.service.impl.WorkOrderListServiceImpl;
import com.example.networkrepair2.util.ResponseCode;
import com.example.networkrepair2.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class RepairmanController {
    @Autowired(required = false)
    RepairmanListServiceImpl repairmanListService;

    @Autowired(required = false)
    WorkOrderListServiceImpl workOrderListService;


    @PostMapping("/login/maintainer")
    public Object repairmanLogin(
            @RequestParam Long jobnumber,
            @RequestParam String passport
    ){
        if(jobnumber==null || passport.equals("")){
            return ResultCode.getJson(ResponseCode.ParamLost.value,"0","缺少重要参数");
        }
        RepairmanList repairmanList = repairmanListService.getById(jobnumber);
        if(repairmanList==null){
            return ResultCode.getJson(ResponseCode.IndexLost.value,"0","用户不存在");
        }

        if(repairmanList.getRepairmanPassword().equals(passport)){
            repairmanList.setRepairmanPassword(null);
            return ResultCode.getJson(repairmanList,"用户存在");
        }else {
            return ResultCode.getJson(ResponseCode.FAIL.value,"0","密码错误");
        }
    }

    //维修员获得自己的工单
    @PostMapping("/maintainer/preliminarylist")
    public Object getMyOrder(
            @RequestParam Long maintainer_number
    ){
        if(maintainer_number==null){
            return ResultCode.getJson(ResponseCode.ParamLost.value,"0","缺少重要参数");
        }
        List<WorkOrderList> workOrderLists = workOrderListService.selectAllByFkStudentNumber(maintainer_number);
        return ResultCode.getJson(workOrderLists);
    }

    //维修员填写工单记录
    @PostMapping("/maintainer/maintenance")
    public Object repairFill(
            @RequestParam Long workorder_number,
            @RequestParam String maintenance_record,
            @RequestParam Long maintainer_number
    ){
        if(workorder_number==null || maintenance_record.equals("")|| maintainer_number==null){
            return ResultCode.getJson(ResponseCode.ParamLost.value,"0","缺少重要参数");
        }
        WorkOrderList workOrderList = workOrderListService.getById(workorder_number);
        if(!workOrderList.getFkRepairmanNumber().equals(maintainer_number)){
            return ResultCode.getJson(ResponseCode.hasNotAccess.value,"0","不是你的工单，没有权限");
        }else if(workOrderList.getWorkOrderState()!=2){
            return ResultCode.getJson(ResponseCode.hasNotAccess.value,"0","该工单已经完成");
        }else {
            workOrderList.setRepairmanContent(maintenance_record);
            workOrderList.setRepairmanTime(LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))));
            workOrderList.setWorkOrderState(3);
            if(workOrderListService.updateById(workOrderList)){
                return ResultCode.getJson(1);
            }else {
                return ResultCode.getJson(ResponseCode.INTERNAL_SERVER_ERROR.value, "0", "添加失败");
            }
        }
    }

    //维修员查看某工单
    @PostMapping("/maintainer/preliminary")
    public Object repairmangetOrder(
            @RequestParam Long workorder_number
    ){
        if(workorder_number==null){
            return ResultCode.getJson(ResponseCode.ParamLost.value,"0","缺少重要参数");
        }
        WorkOrderList workOrderList = workOrderListService.getById(workorder_number);
        return ResultCode.getJson(workOrderList);
    }

    //维修员获得自己的待维修工单
    @PostMapping("/maintainer/preliminarylist2")
    public Object getMyPreliminaryList(
            @RequestParam Long maintainer_number
    ){
        if(maintainer_number==null){
            return ResultCode.getJson(ResponseCode.ParamLost.value,"0","缺少必要参数");
        }
        QueryWrapper<WorkOrderList> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("FK_repairman_number",maintainer_number)
                .eq("work_order_state",2)
                .orderByAsc("work_order_time");
        List<WorkOrderList> workOrderLists = workOrderListService.list(queryWrapper);
        return ResultCode.getJson(workOrderLists);
    }

    //维修员获得自己的已完成工单
    @PostMapping("/maintainer/preliminarylist3")
    public Object getMyFinalList(
            @RequestParam Long maintainer_number
    ){
        if(maintainer_number==null){
            return ResultCode.getJson(ResponseCode.ParamLost.value,"0","缺少必要参数");
        }
        QueryWrapper<WorkOrderList> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("FK_repairman_number",maintainer_number)
                .eq("work_order_state",4)
                .orderByAsc("work_order_time");
        List<WorkOrderList> workOrderLists = workOrderListService.list(queryWrapper);
        return ResultCode.getJson(workOrderLists);
    }
}
