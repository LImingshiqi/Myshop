package com.lmx.myshop.commons.persitence;

import java.util.List;
import java.util.Map;

/**
 * Created by LMX on 2019/7/26 23:39
 * 通用的树形结构的接口
 */
public interface BaseTreeDao <T extends BaseEntity> {
    /**
     *查询所有
     */
    List<T> selectAll();

    /**
     * 新增
     * @param entity
     */
    void insert(T entity);

    /**
     * 删除
     * @param TbId
     */
    void delete(String[] TbId);

    /**
     * 根据ID查询用户信息
     * @param l
     * @return
     */
    T getById(long l);

    /**
     * 更新用户信息
     * @param entity
     */
    void update(T entity);

    /**
     *根据用户
     * @param entity
     * @return
     */


    /**
     * 根据父级节点ID查询所有子节点
     * @return
     */
    List<T> sellectByPId(Long pid);





}
