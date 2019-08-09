package com.lmx.myshop.web.api.dao;

import com.lmx.myshop.domain.TbContent;

import java.util.List;

/**
 * Created by LMX on 2019/7/30 16:37
 */
public interface TbContentDao {
    /**
     * 根据类别ID查询内容
     * @param tbContent
     * @return
     */
    List<TbContent> selectByCategoryId(TbContent tbContent);
}
