package com.lmx.myshop.web.api.service;

import com.lmx.myshop.domain.TbContent;

import java.util.List;

/**
 * Created by LMX on 2019/7/30 16:42
 */
public interface TbContentService {

    /**
     * 根据类别ID查询内容
     * @param categoryId
     * @return
     */
    List<TbContent> selectByCategoryId(Long categoryId);

}
