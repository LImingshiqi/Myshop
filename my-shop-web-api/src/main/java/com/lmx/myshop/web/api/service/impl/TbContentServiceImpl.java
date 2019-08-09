package com.lmx.myshop.web.api.service.impl;

import com.lmx.myshop.domain.TbContent;
import com.lmx.myshop.domain.TbContentCategory;
import com.lmx.myshop.web.api.dao.TbContentDao;
import com.lmx.myshop.web.api.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by LMX on 2019/7/30 16:43
 */
@Service
@Transactional(readOnly = true)
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    private TbContentDao tbContentDao;

    @Override
    public List<TbContent> selectByCategoryId(Long categoryId) {
        TbContent tbContent=new TbContent();
        TbContentCategory tbContentCategory=new TbContentCategory();
        tbContentCategory.setId(categoryId);
        tbContent.setTbContentCategory(tbContentCategory);


        return tbContentDao.selectByCategoryId(tbContent);
    }

}
