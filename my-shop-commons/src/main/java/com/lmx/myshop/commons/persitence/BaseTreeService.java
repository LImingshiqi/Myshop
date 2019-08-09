package com.lmx.myshop.commons.persitence;

import com.lmx.myshop.commons.dto.BaseResult;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by LMX on 2019/7/26 23:41
 *
 * 通用的树形结构的接口
 */
public interface BaseTreeService <T extends BaseEntity> {

    /**
     * 查询所有
     */
    List<T> selectAll();

    /**
     * 新增
     *
     * @param entity
     */
    BaseResult save(T entity);

    /**
     * 删除
     *
     * @param TbId
     */
    void delete(Long TbId);

    /**
     * 根据ID查询用户信息
     *
     * @param l
     * @return
     */
    T getById(long l);

    /**
     * 更新用户信息
     *
     * @param entity
     */
    void update(T entity);

    /**
     *根据用户
     * @param entity
     * @return
     */


    /**
     * 根据 ID 查询信息
     *
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 根据父级节点ID查询所有子节点
     *
     * @return
     */
    List<T> sellectByPId(Long pid);
}

