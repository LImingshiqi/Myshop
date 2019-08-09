package com.lmx.myshop.web.api.service.impl;

import com.lmx.myshop.commons.dto.BaseResult;
import com.lmx.myshop.commons.validator.BeanValidator;
import com.lmx.myshop.domain.TbUser;
import com.lmx.myshop.web.api.dao.TbUserDao;
import com.lmx.myshop.web.api.service.TbUserService;
import com.lmx.myshop.web.api.web.dto.TbUserDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

/**
 * Created by LMX on 2019/8/1 10:24
 */

@Service
public class TbUserServiceImpl implements TbUserService {

        @Autowired
        private TbUserDao tbUserDao;

    @Override
    public TbUser Login(TbUserDto tbUserDto) {
       TbUser user= tbUserDao.login(tbUserDto);

       if(user!=null){
           String password= DigestUtils.md5DigestAsHex(tbUserDto.getPassword().getBytes());
        if(password.equals(user.getPassword())){
            return user;
        }
       }

        return null;
    }

    @Override
    public BaseResult register(TbUserDto tbUserDto) {
        String validator = BeanValidator.validator(tbUserDto);
        if(validator!=null){
            return BaseResult.fail("验证不通过");
        }
        //通过验证
        else if(tbUserDto.getId()==null){
            tbUserDto.setPassword(DigestUtils.md5DigestAsHex(tbUserDto.getPassword().getBytes()));
            tbUserDto.setCreated(new Date());
            tbUserDto.setUpdate(new Date());
            tbUserDao.register(tbUserDto);
            return BaseResult.success("保存用户信息成功");
        }
        return  null;
    }
}