package com.yj.lab.common.model.rdb.entity.pg;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Zhang Yongjie
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 123456L;

    @TableId(type = IdType.AUTO)
    private String uid;
    @TableField
    private String name;
    @TableField
    private String gender;
    @TableField
    private Date birthday;
    @TableField
    private String phone;
    @TableField
    private String email;

}