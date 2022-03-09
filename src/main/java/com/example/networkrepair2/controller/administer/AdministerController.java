package com.example.networkrepair2.controller.administer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.networkrepair2.pojo.AdministratorList;
import com.example.networkrepair2.pojo.RepairmanList;
import com.example.networkrepair2.pojo.WorkOrderList;
import com.example.networkrepair2.service.impl.AdministratorListServiceImpl;
import com.example.networkrepair2.service.impl.RepairmanListServiceImpl;
import com.example.networkrepair2.service.impl.WorkOrderListServiceImpl;
import com.example.networkrepair2.util.ResponseCode;
import com.example.networkrepair2.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@CrossOrigin
@RestController
public class AdministerController {

    @Autowired(required = false)
    AdministratorList administratorList;

    @Autowired(required = false)
    AdministratorListServiceImpl administratorListService;

    @Autowired(required = false)
    WorkOrderListServiceImpl workOrderListService;

    @Autowired(required = false)
    RepairmanListServiceImpl repairmanListService;


    //登入
    @PostMapping("/login/administer")
    public Object login(
            @RequestParam(value = "jobNumber") Long jobNumber,
            @RequestParam(value = "password") String password
    ) {
        if (jobNumber == null || "".equals(password)) {
            return ResultCode.getJson(ResponseCode.ParamLost.value, "0", "缺少必要参数");
        }

        AdministratorList administratorList = administratorListService.getBYId(jobNumber);
        if (administratorList == null) {
            return ResultCode.getJson(ResponseCode.IndexLost.value, "0", "用户不存在");
        } else if (!administratorList.getAdministratorPassword().equals(password)) {
            return ResultCode.getJson(ResponseCode.ParamLost.value, "0", "密码错误");
        } else {
            administratorList.setAdministratorPassword(null);
            return ResultCode.getJson(administratorList, "登陆成功");
        }
    }

    //管理员获取待处理工单列表
    @PostMapping("/administer/orderlist")
    public Object getPendingOrder() {
        List<WorkOrderList> workOrderLists = workOrderListService.searchAllByWorkOrderState(1);
        return ResultCode.getJson(workOrderLists);
    }

    //管理员获得某工单详细信息
    @PostMapping("/administer/getorder")
    public Object getOrdered(
            @RequestParam Long workorder_number
    ) {
        if (workorder_number == null) {
            return ResultCode.getJson(ResponseCode.ParamLost.value, "0", "缺少必要参数");
        }
        WorkOrderList workOrderList = workOrderListService.getById(workorder_number);
        return ResultCode.getJson(workOrderList);
    }

    //管理员获得维修员基本信息
    @PostMapping("/administer/maintainerlist")
    public Object getMaintainerList() {
        QueryWrapper<RepairmanList> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("repairman_number");
        List<RepairmanList> repairmanListList = repairmanListService.list(queryWrapper);
        return ResultCode.getJson(repairmanListList);
    }

    //管理员填写初步方案
    @PostMapping("/administer/preliminary")
    public Object preliminary(
            @RequestParam Long workorder_number,
            @RequestParam String preliminary_porgram,
            @RequestParam Long administrator_number,
            @RequestParam Long maintainer_number
    ) {
        if (workorder_number == null || preliminary_porgram.equals("") || administrator_number == null || maintainer_number == null) {
            return ResultCode.getJson(ResponseCode.ParamLost.value, "0", "缺少必要参数");
        }

        WorkOrderList workOrderList = workOrderListService.getById(workorder_number);
        if (workOrderList.getWorkOrderState() != 1) {
            return ResultCode.getJson(ResponseCode.hasNotAccess.value, "0", "订单已被处理");
        }

        workOrderList.setAdministratorContent(preliminary_porgram);
        workOrderList.setFkAdministratorNumber(administrator_number);
        workOrderList.setFkRepairmanNumber(maintainer_number);
        workOrderList.setAdministratorTime(LocalDateTime.parse(DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00").format(LocalDateTime.now())));
        workOrderList.setWorkOrderState(2);
        if (workOrderListService.updateById(workOrderList)) {
            return ResultCode.getJson("1");
        } else {
            return ResultCode.getJson(ResponseCode.INTERNAL_SERVER_ERROR.value, "0", "添加失败");
        }
    }

    //添加维修员
    @PostMapping("/administer/addmaintainer")
    public Object addRepairman(
            @RequestParam Long job_number,
            @RequestParam String name,
            @RequestParam String passport,
            @RequestParam String sex
    ) {
        if (job_number == null || name.equals("") || passport.equals("") || sex.equals("")) {
            return ResultCode.getJson(ResponseCode.ParamLost.value, "0", "缺少必要参数");
        }
        RepairmanList repairmanList = new RepairmanList(job_number, name, passport, sex);
        if (repairmanListService.save(repairmanList)) {
            return ResultCode.getJson("1");
        } else {
            return ResultCode.getJson(ResponseCode.INTERNAL_SERVER_ERROR.value, "0", "添加失败");
        }
    }

    //删除维修员
    @PostMapping("/administer/deletemaintainer")
    public Object deleteRepairman(
            @RequestParam Long administer_number,
            @RequestParam Long maintainer_number,
            @RequestParam String passport
    ) {
        if (administer_number == null || maintainer_number == null || passport.equals("")) {
            return ResultCode.getJson(ResponseCode.ParamLost.value, "0", "缺少必要参数");
        }

        AdministratorList administratorList = administratorListService.getById(administer_number);
        if (!administratorList.getAdministratorPassword().equals(passport)) {
            return ResultCode.getJson(ResponseCode.IndexLost.value, "0", "管理员认证失败");
        }

        if (repairmanListService.removeById(maintainer_number)) {
            return ResultCode.getJson("1", "成功移出维修人员" + maintainer_number);
        } else {
            return ResultCode.getJson(ResponseCode.INTERNAL_SERVER_ERROR.value, "0", "移出失败");
        }
    }

    //管理员获取待维修工单接口
    @PostMapping("/administer/orderlist2")
    public Object getWaitOrderList() {
        List<WorkOrderList> workOrderLists = workOrderListService.searchAllByWorkOrderState(2);
        return ResultCode.getJson(workOrderLists);
    }

    //管理员获已完成工单接口
    @PostMapping("/administer/orderlist3")
    public Object getFinalOrderList() {
        List<WorkOrderList> workOrderLists = workOrderListService.searchAllByWorkOrderState(4);
        return ResultCode.getJson(workOrderLists);
    }


}
