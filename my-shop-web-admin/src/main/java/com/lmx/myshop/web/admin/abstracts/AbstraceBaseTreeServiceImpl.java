package com.lmx.myshop.web.admin.abstracts;

import com.lmx.myshop.commons.persitence.BaseEntity;
import com.lmx.myshop.commons.persitence.BaseTreeDao;
import com.lmx.myshop.commons.persitence.BaseTreeService;
import com.lmx.myshop.domain.TbContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by LMX on 2019/7/27 13:17
 */
public abstract class AbstraceBaseTreeServiceImpl <T extends BaseEntity,D extends BaseTreeDao<T>> implements BaseTreeService<T> {

    @Autowired
    protected D dao;

    /**
     * 重写查询全部
     * @return
     */
    @Override
    public List<T> selectAll() {

        return dao.selectAll();
    }

    /**
     * 根据Id查询全部数据
     * @param pid
     * @return
     */
    @Override
    public List<T> sellectByPId(Long pid) {
        return dao.sellectByPId(pid);
    }

    /**
     * 更新数据
     * @param entity
     */
    @Override
    @Transactional(readOnly = false)
    public void update(T entity) {
        dao.update(entity);

    }

    /**
     * 删除数据
     * @param id
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        dao.delete(new String[]{String.valueOf(id)});
    }

    /**
     * 根据ID查询数组
     * @param id
     * @return
     */
    @Override
    public T getById(long id) {
        return dao.getById(id);
    }

    /**
     * 插入
     * @param entity
     */
    @Transactional(readOnly = false)
    public void insert(T entity){
        dao.insert(entity);
    }


    /**
     * 根据 ID 查询信息
     *
     * @param id
     * @return
     */
    @Override
    public T getById(Long id) {
        return dao.getById(id);
    }
}
