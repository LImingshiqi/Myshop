package com.lmx.myshop.commons.persitence;

import java.util.List;
import java.util.Map;

/**
 * Created by LMX on 2019/7/24 0:19
 * 通用的数据访问层基类
 */
public interface BaseDao<T extends  BaseEntity > {
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
    void delete(Long TbId);

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
     * 批量删除
     * @param ids
     */
    void deleteMulti (String[] ids);

    /**
     *分页功能
     * @param
     * @param
     * @return
     */
    List<T> page(Map<String,Object> params);

    /**
     * 查询总笔数
     * @return
     */
    int count(T entity);


}
