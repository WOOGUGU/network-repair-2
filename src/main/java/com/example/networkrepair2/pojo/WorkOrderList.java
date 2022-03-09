package com.example.networkrepair2.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        WorkOrderList other = (WorkOrderList) that;
        return (this.getWorkOrderNumber() == null ? other.getWorkOrderNumber() == null : this.getWorkOrderNumber().equals(other.getWorkOrderNumber()))
            && (this.getWorkOrderState() == null ? other.getWorkOrderState() == null : this.getWorkOrderState().equals(other.getWorkOrderState()))
            && (this.getFkStudentNumber() == null ? other.getFkStudentNumber() == null : this.getFkStudentNumber().equals(other.getFkStudentNumber()))
            && (this.getWorkOrderTime() == null ? other.getWorkOrderTime() == null : this.getWorkOrderTime().equals(other.getWorkOrderTime()))
            && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()))
            && (this.getRepairAddress() == null ? other.getRepairAddress() == null : this.getRepairAddress().equals(other.getRepairAddress()))
            && (this.getRepairContent() == null ? other.getRepairContent() == null : this.getRepairContent().equals(other.getRepairContent()))
            && (this.getPictureAddress() == null ? other.getPictureAddress() == null : this.getPictureAddress().equals(other.getPictureAddress()))
            && (this.getRepairTime() == null ? other.getRepairTime() == null : this.getRepairTime().equals(other.getRepairTime()))
            && (this.getFkAdministratorNumber() == null ? other.getFkAdministratorNumber() == null : this.getFkAdministratorNumber().equals(other.getFkAdministratorNumber()))
            && (this.getAdministratorContent() == null ? other.getAdministratorContent() == null : this.getAdministratorContent().equals(other.getAdministratorContent()))
            && (this.getAdministratorTime() == null ? other.getAdministratorTime() == null : this.getAdministratorTime().equals(other.getAdministratorTime()))
            && (this.getFkRepairmanNumber() == null ? other.getFkRepairmanNumber() == null : this.getFkRepairmanNumber().equals(other.getFkRepairmanNumber()))
            && (this.getRepairmanContent() == null ? other.getRepairmanContent() == null : this.getRepairmanContent().equals(other.getRepairmanContent()))
            && (this.getRepairmanTime() == null ? other.getRepairmanTime() == null : this.getRepairmanTime().equals(other.getRepairmanTime()))
            && (this.getEvaluationState() == null ? other.getEvaluationState() == null : this.getEvaluationState().equals(other.getEvaluationState()))
            && (this.getEvaluation() == null ? other.getEvaluation() == null : this.getEvaluation().equals(other.getEvaluation()))
            && (this.getEvaluationTime() == null ? other.getEvaluationTime() == null : this.getEvaluationTime().equals(other.getEvaluationTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWorkOrderNumber() == null) ? 0 : getWorkOrderNumber().hashCode());
        result = prime * result + ((getWorkOrderState() == null) ? 0 : getWorkOrderState().hashCode());
        result = prime * result + ((getFkStudentNumber() == null) ? 0 : getFkStudentNumber().hashCode());
        result = prime * result + ((getWorkOrderTime() == null) ? 0 : getWorkOrderTime().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getRepairAddress() == null) ? 0 : getRepairAddress().hashCode());
        result = prime * result + ((getRepairContent() == null) ? 0 : getRepairContent().hashCode());
        result = prime * result + ((getPictureAddress() == null) ? 0 : getPictureAddress().hashCode());
        result = prime * result + ((getRepairTime() == null) ? 0 : getRepairTime().hashCode());
        result = prime * result + ((getFkAdministratorNumber() == null) ? 0 : getFkAdministratorNumber().hashCode());
        result = prime * result + ((getAdministratorContent() == null) ? 0 : getAdministratorContent().hashCode());
        result = prime * result + ((getAdministratorTime() == null) ? 0 : getAdministratorTime().hashCode());
        result = prime * result + ((getFkRepairmanNumber() == null) ? 0 : getFkRepairmanNumber().hashCode());
        result = prime * result + ((getRepairmanContent() == null) ? 0 : getRepairmanContent().hashCode());
        result = prime * result + ((getRepairmanTime() == null) ? 0 : getRepairmanTime().hashCode());
        result = prime * result + ((getEvaluationState() == null) ? 0 : getEvaluationState().hashCode());
        result = prime * result + ((getEvaluation() == null) ? 0 : getEvaluation().hashCode());
        result = prime * result + ((getEvaluationTime() == null) ? 0 : getEvaluationTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", workOrderNumber=").append(workOrderNumber);
        sb.append(", workOrderState=").append(workOrderState);
        sb.append(", fkStudentNumber=").append(fkStudentNumber);
        sb.append(", workOrderTime=").append(workOrderTime);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", repairAddress=").append(repairAddress);
        sb.append(", repairContent=").append(repairContent);
        sb.append(", pictureAddress=").append(pictureAddress);
        sb.append(", repairTime=").append(repairTime);
        sb.append(", fkAdministratorNumber=").append(fkAdministratorNumber);
        sb.append(", administratorContent=").append(administratorContent);
        sb.append(", administratorTime=").append(administratorTime);
        sb.append(", fkRepairmanNumber=").append(fkRepairmanNumber);
        sb.append(", repairmanContent=").append(repairmanContent);
        sb.append(", repairmanTime=").append(repairmanTime);
        sb.append(", evaluationState=").append(evaluationState);
        sb.append(", evaluation=").append(evaluation);
        sb.append(", evaluationTime=").append(evaluationTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}