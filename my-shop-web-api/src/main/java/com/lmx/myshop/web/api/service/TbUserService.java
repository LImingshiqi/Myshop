package com.lmx.myshop.web.api.service;

import com.lmx.myshop.commons.dto.BaseResult;
import com.lmx.myshop.domain.TbUser;
import com.lmx.myshop.web.api.web.dto.TbUserDto;

/**
 * Created by LMX on 2019/8/1 10:23
 */
public interface TbUserService {
    /**
     * 用户登录
     */
    TbUser Login(TbUserDto tbUserDto);
    /**
     * 注册
     * @param tbUserDto
     */
    BaseResult register(TbUserDto tbUserDto);

}
