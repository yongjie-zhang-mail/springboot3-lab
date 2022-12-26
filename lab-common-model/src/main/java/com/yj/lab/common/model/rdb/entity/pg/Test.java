package com.yj.lab.common.model.rdb.entity.pg;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author zhangyj21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("test")
@ToString
public class Test {

    /**
     * 主键
     */
    @TableId(value = "id")
    private String id;

    @TableField(value = "count")
    private Integer count;

    @TableField(value = "create_time")
    private Date createTime;

}