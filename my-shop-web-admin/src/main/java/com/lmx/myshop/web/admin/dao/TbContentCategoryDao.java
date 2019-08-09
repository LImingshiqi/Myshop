package com.lmx.myshop.web.admin.dao;

import com.lmx.myshop.commons.dto.BaseResult;
import com.lmx.myshop.commons.persitence.BaseDao;
import com.lmx.myshop.commons.persitence.BaseEntity;
import com.lmx.myshop.commons.persitence.BaseTreeDao;
import com.lmx.myshop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  TbContentCategoryDao  extends BaseTreeDao<TbContentCategory> {




}
