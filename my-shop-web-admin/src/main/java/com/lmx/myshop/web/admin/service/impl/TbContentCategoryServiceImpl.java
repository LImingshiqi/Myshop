package com.lmx.myshop.web.admin.service.impl;

import com.lmx.myshop.commons.dto.BaseResult;
import com.lmx.myshop.commons.dto.PageInfo;
import com.lmx.myshop.commons.validator.BeanValidator;
import com.lmx.myshop.domain.TbContent;
import com.lmx.myshop.domain.TbContentCategory;
import com.lmx.myshop.web.admin.abstracts.AbstraceBaseTreeServiceImpl;
import com.lmx.myshop.web.admin.dao.TbContentCategoryDao;
import com.lmx.myshop.web.admin.service.TbContentCategoryService;
import com.lmx.myshop.web.admin.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class TbContentCategoryServiceImpl extends AbstraceBaseTreeServiceImpl<TbContentCategory,TbContentCategoryDao> implements TbContentCategoryService {



    @Override
    @Transactional(readOnly = false)
    public BaseResult save(TbContentCategory entity) {
        String validator = BeanValidator.validator(entity);
        if (validator != null) {
            return BaseResult.fail(validator) ;
        }
        else {
            TbContentCategory parent = entity.getParent();
            //如果没有选择父节点则默认设置为跟目录
            if (parent == null || parent.getId() == null) {
                //0代表跟目录
                parent.setId(0L);

            }
            entity.setUpdate(new Date());
            //新增
            if (entity.getId() == null) {
                entity.setCreated(new Date());
                entity.setIsParent(false);
                //判断当前新增的节点有没有父级节点
                if(parent.getId()!=0l){
                    TbContentCategory currenCategoryParent =getById(parent.getId());
                    if(currenCategoryParent!=null){
                        //为父级节点设置isParent为true
                        currenCategoryParent.setIsParent(true);
                        update(currenCategoryParent);
                    }
                    //父级节点为0,表示为跟目录
                    else{
                        //跟目录一定是父级目录
                        entity.setIsParent(true);
                    }
                }

                    
                insert(entity);
            }
            //修改
            else {
                update(entity);
            }
            return BaseResult.success("保存分类信息成功");
        }
    }




    /**
     * 查找出所有子节点
     */
    private void finaAllchiden(List<String> targetList,Long parentId){
        targetList.add(String.valueOf(parentId));

        List<TbContentCategory> tbContentCategorys=sellectByPId(parentId);
        for(TbContentCategory tbContentCategory:tbContentCategorys){
            finaAllchiden(targetList,tbContentCategory.getId());
        }
    }

}
