package com.yj.lab.common.model.rdb.entity.pg;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zhang Yongjie
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("product")
public class Product implements IdEntity {

    @TableId
    private String id;
    @TableField
    private String name;
    @TableField
    private String price;
    @TableField
    private String img;

}
