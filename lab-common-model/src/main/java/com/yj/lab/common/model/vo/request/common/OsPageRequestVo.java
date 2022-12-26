package com.yj.lab.common.model.vo.request.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Zhang Yongjie
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OsPageRequestVo<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -3138677491851300562L;

    /**
     * 要查询的索引，默认 jd_product
     */
    private String index = "jd_product";
    /**
     * 页码
     */
    private Long pageNum = 0L;
    /**
     * 每页条数
     */
    private Long pageSize = 10L;
    /**
     * 排序字段
     */
    private String orderBy;
    /**
     * 是否正序，true-正，false-反
     */
    private Boolean asc;
    /**
     * 条件实体类
     */
    private T entity;
}
