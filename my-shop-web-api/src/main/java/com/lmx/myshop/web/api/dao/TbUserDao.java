package com.lmx.myshop.web.api.dao;

import com.lmx.myshop.domain.TbUser;
import com.lmx.myshop.web.api.web.dto.TbUserDto;
import org.springframework.stereotype.Repository;

/**
 * Created by LMX on 2019/8/1 10:22
 */
@Repository
public interface TbUserDao {

    /**
     * 用户登录
     */
     TbUser login(TbUserDto tbUserDto);


    /**
     * 注册
     * @param tbUserDto
     * @return
     */
    void register(TbUserDto tbUserDto);
}
