package com.example.networkrepair2.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 学生基本信息表
 * @TableName student_number
 */
@TableName(value ="student_number")
@Data
public class StudentNumber implements Serializable {
    /**
     * 学号
     */
    @TableId
    private Long studentNumber;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 密码，MD5加密
     */
    private String studentPassword;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}