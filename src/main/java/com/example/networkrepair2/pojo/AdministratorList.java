package com.example.networkrepair2.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 管理员账号
 *
 * @TableName administrator_list
 */
@TableName(value = "administrator_list")
@Data
public class AdministratorList implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
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
        AdministratorList other = (AdministratorList) that;
        return (this.getAdministratorNumber() == null ? other.getAdministratorNumber() == null : this.getAdministratorNumber().equals(other.getAdministratorNumber()))
                && (this.getAdministratorName() == null ? other.getAdministratorName() == null : this.getAdministratorName().equals(other.getAdministratorName()))
                && (this.getAdministratorPassword() == null ? other.getAdministratorPassword() == null : this.getAdministratorPassword().equals(other.getAdministratorPassword()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdministratorNumber() == null) ? 0 : getAdministratorNumber().hashCode());
        result = prime * result + ((getAdministratorName() == null) ? 0 : getAdministratorName().hashCode());
        result = prime * result + ((getAdministratorPassword() == null) ? 0 : getAdministratorPassword().hashCode());
        return result;
    }

    @Override
    public String toString() {
        String sb = getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", administratorNumber=" + administratorNumber +
                ", administratorName=" + administratorName +
                ", administratorPassword=" + administratorPassword +
                ", serialVersionUID=" + serialVersionUID +
                "]";
        return sb;
    }
}