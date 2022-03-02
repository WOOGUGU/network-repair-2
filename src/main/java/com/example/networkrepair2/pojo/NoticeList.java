package com.example.networkrepair2.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 公告列表
 * @TableName notice_list
 */
@TableName(value ="notice_list")
@Data
public class NoticeList implements Serializable {
    /**
     * 公告编号
     */
    @TableId(type = IdType.AUTO)
    private Long noticeNumber;

    /**
     * 发布时间
     */
    private LocalDateTime noticeTime;

    /**
     * 公告内容
     */
    private String noticeContent;

    /**
     * 公告标题
     */
    private String noticeTitle;

    /**
     * 外-管理员工号
     */
    private Long fkAdministratorNumber;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}