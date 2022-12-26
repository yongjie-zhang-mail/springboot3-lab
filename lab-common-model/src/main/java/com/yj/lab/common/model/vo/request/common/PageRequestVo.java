package com.yj.lab.common.model.vo.request.common;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Zhang Yongjie
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PageRequestVo<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -3138677491851300562L;

    /**
     * 页码
     */
    private Long pageNum;
    /**
     * 每页条数
     */
    private Long pageSize;
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
