package com.yj.lab.common.model.converter;

import java.util.List;

/**
 * 使用 mapstruct 进行类型转换
 *
 * @author Zhang Yongjie
 */
public interface BaseConverter<V, E> {

    /**
     * Vo转domain
     *
     * @param vo /
     * @return /
     */
    E toDomain(V vo);

    /**
     * domain转Vo
     *
     * @param domain /
     * @return /
     */
    V toVo(E domain);

    /**
     * Vo集合转domain集合
     *
     * @param voList /
     * @return /
     */
    List<E> toDomain(List<V> voList);

    /**
     * domain集合转Vo集合
     *
     * @param domainList /
     * @return /
     */
    List<V> toVo(List<E> domainList);
}
