package com.example.networkrepair2.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 工单列表
 * @TableName work_order_list
 */
@TableName(value ="work_order_list")
@Data
public class WorkOrderList implements Serializable {
    /**
     * 工单编号
     */
    @TableId(type = IdType.AUTO)
    private Long workOrderNumber;

    /**
     * 工单状态(1~4)
     */
    private Integer workOrderState;

    /**
     * 外-学生学号
     */
    private Long fkStudentNumber;

    /**
     * 提交时间
     */
    private LocalDateTime workOrderTime;

    /**
     * 提交者联系方式
     */
    private Long phoneNumber;

    /**
     * 维修地址
     */
    private String repairAddress;

    /**
     * 维修详细信息
     */
    private String repairContent;

    /**
     * 图片地址
     */
    private String pictureAddress;

    /**
     * 维修时间
     */
    private String repairTime;

    /**
     * 外-管理员工号
     */
    private Long fkAdministratorNumber;

    /**
     * 管理员描述
     */
    private String administratorContent;

    /**
     * 管理员时间
     */
    private LocalDateTime administratorTime;

    /**
     * 外-维修员工号
     */
    private Long fkRepairmanNumber;

    /**
     * 维修员描述
     */
    private String repairmanContent;

    /**
     * 维修员时间
     */
    private LocalDateTime repairmanTime;

    /**
     * 学生满意度
     */
    private Double evaluationState;

    /**
     * 学生评价
     */
    private String evaluation;

    /**
     * 评价时间
     */
    private LocalDateTime evaluationTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}