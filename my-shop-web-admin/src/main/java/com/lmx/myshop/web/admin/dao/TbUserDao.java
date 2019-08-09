package com.lmx.myshop.web.admin.dao;


import com.lmx.myshop.commons.persitence.BaseDao;
import com.lmx.myshop.commons.persitence.BaseEntity;
import com.lmx.myshop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TbUserDao extends BaseDao<TbUser> {
    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    TbUser selectByemail(String email);
}
