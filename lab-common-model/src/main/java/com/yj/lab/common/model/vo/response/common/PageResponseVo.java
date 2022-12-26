package com.yj.lab.common.model.vo.response.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResponseVo<T> {

    /**
     * 页码
     */
    private Long pageNum;
    /**
     * 每页条数
     */
    private Long pageSize;
    /**
     * 页数
     */
    private Long pages;
    /**
     * 总数
     */
    private Long total;
    /**
     * 数据
     */
    private List<T> list;

//    /**
//     * 分页构造
//     *
//     * @param page plus分页对象
//     */
//    public PageResponseVo(IPage<T> page) {
//        this.pageNum = page.getCurrent();
//        this.pageSize = page.getSize();
//        this.total = page.getTotal();
//        this.list = page.getRecords();
//        this.pages = page.getPages();
//    }
}
