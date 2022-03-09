package com.example.networkrepair2.controller.student;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.networkrepair2.pojo.StudentNumber;
import com.example.networkrepair2.pojo.WorkOrderList;
import com.example.networkrepair2.service.impl.StudentNumberServiceImpl;
import com.example.networkrepair2.service.impl.WorkOrderListServiceImpl;
import com.example.networkrepair2.util.ResponseCode;
import com.example.networkrepair2.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class StudentController {


    @Autowired(required = false)
    StudentNumberServiceImpl studentNumberServiceImpl;

    @Autowired(required = false)
    WorkOrderListServiceImpl workOrderListService;




    //登录
    @PostMapping("/login/student")
    public Object login(
            @RequestParam Long student_number,
            @RequestParam String passport
    ){
        if(student_number==null || passport.equals("")){
            return ResultCode.getJson(ResponseCode.ParamLost.value,"0","用户名或者密码为空");
        }

        QueryWrapper<StudentNumber> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("student_number",student_number)
                .eq("student_password",passport);
        StudentNumber studentNumber = studentNumberServiceImpl.getOne(queryWrapper);
        if(studentNumber==null){
            return ResultCode.getJson(ResponseCode.ParamLost.value,"0","用户不存在");
        }else {
            studentNumber.setStudentPassword(null);
            return ResultCode.getJson(studentNumber,"用户存在");
        }
    }

    //学生提交工单
    @PostMapping("/student/submitorder")
    public Object studentSubmit(
            @RequestParam Long student_number,
            @RequestParam Long contact_information,
            @RequestParam String workorder_content,
            @RequestParam String address,
            @RequestParam String picture_address,
            @RequestParam(required = false) String fixed_time
    ){
        if(student_number==null || contact_information==null || workorder_content==null|| address==null || fixed_time==null){
            return ResultCode.getJson(ResponseCode.ParamLost.value,"0","缺少必要参数");
        }
        WorkOrderList workOrderList = new WorkOrderList();
        workOrderList.setFkStudentNumber(student_number);
        workOrderList.setPhoneNumber(contact_information);
        workOrderList.setRepairAddress(address);
        workOrderList.setPictureAddress(picture_address);
        workOrderList.setRepairTime(fixed_time);
        workOrderList.setWorkOrderState(1);
        if (workOrderListService.save(workOrderList)){
            return ResultCode.getJson("1");
        }else {
            return ResultCode.getJson(ResponseCode.INTERNAL_SERVER_ERROR.value,"0","添加失败");
        }


    }

    //学生查看工单列表
    @PostMapping("/student/orderlist")
    public Object studentOrderList(
        @RequestParam Long student_number
    ){
        if(student_number==null){
            return ResultCode.getJson(ResponseCode.ParamLost.value,"0","学号为空！请重新访问");
        }
        QueryWrapper<WorkOrderList> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("FK_student_number",student_number).orderByDesc("work_order_number");
        return ResultCode.getJson(workOrderListService.list(queryWrapper));

    }

    //查看某工单
    @PostMapping("/student/getorder")
    public  Object getOrder(
        @RequestParam Long workorder_number
    ){
        if(workorder_number==null){
            return ResultCode.getJson(ResponseCode.ParamLost.value,"0","工单号为空");
        }

        //直接返回的实体类
        return ResultCode.getJson(workOrderListService.selectByWorkOrderNumber(workorder_number));
    }

    //提交评价
    @PostMapping("/student/evaluate")
    public Object Evaluate(
            @RequestParam Long student_number,
            @RequestParam Long workorder_number,
            @RequestParam Double maintenance_satisfaction,
            @RequestParam String evaluation
    ){
        if(student_number==null || workorder_number==null || maintenance_satisfaction==null){
            return ResultCode.getJson(ResponseCode.ParamLost.value,"0","缺少必要参数");
        }
        WorkOrderList workOrderList=workOrderListService.selectByWorkOrderNumber(workorder_number);
        if(workOrderList.getFkStudentNumber().equals(student_number)&& workOrderList.getWorkOrderState()==3){
            workOrderList.setEvaluation(evaluation);
            workOrderList.setEvaluationState(maintenance_satisfaction);
            workOrderList.setWorkOrderState(4);
            workOrderList.setEvaluationTime(LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))));
            workOrderListService.updateById(workOrderList);
            return ResultCode.getJson("1");
        }else {
            //应该分别return
            return ResultCode.getJson(ResponseCode.FAIL.value, "0", "用户非法或当前阶段无法评价");
        }
    }


    //查看最近提交工单

    public Object getLatestOrder(
            @RequestParam Long student_number
    ){
        if(student_number==null){
            return ResultCode.getJson(ResponseCode.ParamLost.value,"0","缺少必要参数");
        }
        return ResultCode.getJson(workOrderListService.getLastOne(student_number));
    }
}
