package com.lmx.myshop.web.admin.abstracts;

import com.lmx.myshop.commons.dto.BaseResult;
import com.lmx.myshop.commons.persitence.BaseEntity;
import com.lmx.myshop.commons.persitence.BaseService;
import com.lmx.myshop.commons.persitence.BaseTreeService;
import com.lmx.myshop.commons.persitence.BaserTreeEntity;
import com.lmx.myshop.domain.TbContentCategory;
import com.lmx.myshop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by LMX on 2019/7/28 0:30
 */
public abstract class AbstractBaseTreeController <T extends BaserTreeEntity,S extends BaseTreeService<T>> {

    @Autowired
    protected S service;

    /**
     * 跳转列表页
     *
     * @param model
     * @return
     */

    public abstract String list(Model model);

    /**
     * 树形结构
     *
     * @return
     */
    public abstract List<T> treeData(Long id);


    /**
     * 保存内容
     *
     * @return
     */
    public abstract String save(T entity, Model model, RedirectAttributes redirectAttributes);
    /**
     * 跳转表单页
     *
     * @return
     */
    public abstract String form(T entity);
    /**
     *
     *删除方法
     */
    public abstract BaseResult delete(String ids);


    /**
     *
     * @param sourceList 数据源集合
     * @param targetList 排序后的集合
     * @param parentId  父节点的ID
     */

    private void sortList(List<T> sourceList,List<T> targetList,Long parentId){

        for (T sourceEntity:sourceList){
            if( sourceEntity.getParent().getId().equals(parentId)){
                targetList.add(sourceEntity);

                //判断有没有子节点，如果有继续追加
                if(sourceEntity.getIsParent()){
                    for (T contentEntity :sourceList){
                        if(contentEntity.getParent().getId().equals(sourceEntity.getId())){
                            sortList(sourceList,targetList,sourceEntity.getId());
                            break;
                        }
                    }
                }

            }

        }

    }

}
