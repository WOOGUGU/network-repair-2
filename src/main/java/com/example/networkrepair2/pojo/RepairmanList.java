package com.example.networkrepair2.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 维修员账号
 * @TableName repairman_list
 */
@TableName(value ="repairman_list")
@Data
@AllArgsConstructor
public class RepairmanList implements Serializable {
    /**
     * 维修员工号
     */
    @TableId
    private Long repairmanNumber;

    /**
     * 维修员姓名
     */
    private String repairmanName;

    /**
     * 维修员密码
     */
    private String repairmanPassword;

    /**
     * 维修员性别
     */
    private String repairmanSex;

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
        RepairmanList other = (RepairmanList) that;
        return (this.getRepairmanNumber() == null ? other.getRepairmanNumber() == null : this.getRepairmanNumber().equals(other.getRepairmanNumber()))
            && (this.getRepairmanName() == null ? other.getRepairmanName() == null : this.getRepairmanName().equals(other.getRepairmanName()))
            && (this.getRepairmanPassword() == null ? other.getRepairmanPassword() == null : this.getRepairmanPassword().equals(other.getRepairmanPassword()))
            && (this.getRepairmanSex() == null ? other.getRepairmanSex() == null : this.getRepairmanSex().equals(other.getRepairmanSex()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRepairmanNumber() == null) ? 0 : getRepairmanNumber().hashCode());
        result = prime * result + ((getRepairmanName() == null) ? 0 : getRepairmanName().hashCode());
        result = prime * result + ((getRepairmanPassword() == null) ? 0 : getRepairmanPassword().hashCode());
        result = prime * result + ((getRepairmanSex() == null) ? 0 : getRepairmanSex().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", repairmanNumber=").append(repairmanNumber);
        sb.append(", repairmanName=").append(repairmanName);
        sb.append(", repairmanPassword=").append(repairmanPassword);
        sb.append(", repairmanSex=").append(repairmanSex);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}