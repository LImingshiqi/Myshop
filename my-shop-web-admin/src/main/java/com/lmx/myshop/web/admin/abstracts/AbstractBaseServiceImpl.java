package com.lmx.myshop.web.admin.abstracts;

import com.lmx.myshop.commons.dto.PageInfo;
import com.lmx.myshop.commons.persitence.BaseDao;
import com.lmx.myshop.commons.persitence.BaseEntity;
import com.lmx.myshop.commons.persitence.BaseService;
import com.lmx.myshop.domain.TbContent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LMX on 2019/7/27 14:20
 */
public abstract class AbstractBaseServiceImpl <T extends BaseEntity,D extends BaseDao<T>> implements BaseService<T>{
    @Autowired
    protected D dao;


    /**
     * 查询全部
     * @return
     */
    @Override
    public List<T> selectAll() {

        return dao.selectAll();
    }

    /**
     * 新增
     * @param entity
     */

   public void insert(T entity){
        dao.insert(entity);
   }


    /**
     * 删除
     * @param TbId
     */
    @Override
  public   void delete(Long TbId){
       dao.delete(TbId);
  }

    /**
     * 根据ID查找
     * @param l
     * @return
     */

    @Override
    public T getById(long l) {
        return dao.getById(l);
    }


    /**
     * 批量删除
     * @param ids
     */
    @Override
      public void deleteMulti(String[] ids){
        dao.deleteMulti(ids);
        }

    /**
     * 跟新用户信息
     * @param entity
     */
    public void update(T entity){
        dao.update(entity);
    }

    /**
     * 查询总笔数
     * @param entity
     * @return
     */
    @Override
    public int count(T entity){
        return  dao.count(entity);
    }

    /**
     * 分页查询
     *
     * @param start
     * @param length
     * @param draw
     * @param entity
     * @return
     */
    @Override
    public PageInfo<T> page(int start, int length, int draw, T entity) {
        int count = count(entity);

        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", entity);

        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecodsTotal(count);
        pageInfo.setRecodsFiltered(count);
        pageInfo.setData(dao.page(params));

        return pageInfo;

    }



}
