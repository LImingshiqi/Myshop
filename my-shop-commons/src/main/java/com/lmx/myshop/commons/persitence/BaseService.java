package com.lmx.myshop.commons.persitence;

import com.lmx.myshop.commons.dto.BaseResult;
import com.lmx.myshop.commons.dto.PageInfo;

import java.util.List;

/**
 * Created by LMX on 2019/7/24 0:24
 * 所有业务逻辑层的基类
 *
 */
public interface BaseService<T extends BaseEntity >  {


    /**
     * 查询全部用户信息
     * @return
     */
    List<T> selectAll();

    /**
     * 保存用户信息
     * @param tbUser
     * @return
     */
    BaseResult save(T tbUser);

    /**
     * 删除用户
     * @param TbId
     */
    void delete(Long TbId);

    /**
     * 根虎ID查询用户
     * @param l
     * @return
     */

    T getById(long l);

    /**
     * 跟新用户信息
     * @param entity
     */
    void update(T entity);

    /**
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param start
     * @param length
     * @return
     */
    PageInfo<T> page(int start, int length, int draw, T tbUser);

    /**
     * 查询总笔数
     * @return
     */
    int count(T tbUser);


}
