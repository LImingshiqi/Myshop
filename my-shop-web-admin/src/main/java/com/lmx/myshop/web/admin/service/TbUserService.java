package com.lmx.myshop.web.admin.service;

import com.lmx.myshop.commons.dto.BaseResult;
import com.lmx.myshop.commons.dto.PageInfo;
import com.lmx.myshop.commons.persitence.BaseService;
import com.lmx.myshop.domain.TbUser;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface TbUserService extends BaseService<TbUser> {
    /**
     * 用户登录
     * @param email
     * @param password
     * @return
     */
    TbUser log(String email,String password);


}
