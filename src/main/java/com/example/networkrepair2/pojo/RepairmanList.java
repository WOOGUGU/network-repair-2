package com.example.networkrepair2.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 维修员账号
 * @TableName repairman_list
 */
@TableName(value ="repairman_list")
@Data
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
}