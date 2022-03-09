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
        NoticeList other = (NoticeList) that;
        return (this.getNoticeNumber() == null ? other.getNoticeNumber() == null : this.getNoticeNumber().equals(other.getNoticeNumber()))
            && (this.getNoticeTime() == null ? other.getNoticeTime() == null : this.getNoticeTime().equals(other.getNoticeTime()))
            && (this.getNoticeContent() == null ? other.getNoticeContent() == null : this.getNoticeContent().equals(other.getNoticeContent()))
            && (this.getNoticeTitle() == null ? other.getNoticeTitle() == null : this.getNoticeTitle().equals(other.getNoticeTitle()))
            && (this.getFkAdministratorNumber() == null ? other.getFkAdministratorNumber() == null : this.getFkAdministratorNumber().equals(other.getFkAdministratorNumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNoticeNumber() == null) ? 0 : getNoticeNumber().hashCode());
        result = prime * result + ((getNoticeTime() == null) ? 0 : getNoticeTime().hashCode());
        result = prime * result + ((getNoticeContent() == null) ? 0 : getNoticeContent().hashCode());
        result = prime * result + ((getNoticeTitle() == null) ? 0 : getNoticeTitle().hashCode());
        result = prime * result + ((getFkAdministratorNumber() == null) ? 0 : getFkAdministratorNumber().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", noticeNumber=").append(noticeNumber);
        sb.append(", noticeTime=").append(noticeTime);
        sb.append(", noticeContent=").append(noticeContent);
        sb.append(", noticeTitle=").append(noticeTitle);
        sb.append(", fkAdministratorNumber=").append(fkAdministratorNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}