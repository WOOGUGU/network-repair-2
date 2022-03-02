package com.example.networkrepair2.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 管理员账号
 * @TableName administrator_list
 */
@TableName(value ="administrator_list")
@Data
public class AdministratorList implements Serializable {
    /**
     * 管理员工号
     */
    @TableId
    private Long administratorNumber;

    /**
     * 管理员姓名
     */
    private String administratorName;

    /**
     * 管理员密码
     */
    private String administratorPassword;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}