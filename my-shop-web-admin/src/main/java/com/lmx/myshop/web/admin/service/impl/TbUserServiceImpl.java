package com.lmx.myshop.web.admin.service.impl;

import com.lmx.myshop.commons.dto.BaseResult;
import com.lmx.myshop.commons.dto.PageInfo;
import com.lmx.myshop.commons.utils.RegexpUtils;
import com.lmx.myshop.commons.validator.BeanValidator;
import com.lmx.myshop.domain.TbUser;
import com.lmx.myshop.web.admin.abstracts.AbstractBaseServiceImpl;
import com.lmx.myshop.web.admin.dao.TbUserDao;
import com.lmx.myshop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class TbUserServiceImpl extends AbstractBaseServiceImpl<TbUser,TbUserDao> implements TbUserService {
    /**
     * 新增和修改用户
     * @param tbUser
     * @return
     */
   @Override

    public  BaseResult  save(TbUser tbUser) {
      String validator=BeanValidator.validator(tbUser);
       /**
        *
        * 检验用户返回成功的状态码,通过验证
        */
//       BaseResult baseResult=checkTbUser(tbUser);
      //验证不通过
       if(validator!=null) {
            return BaseResult.fail(validator);
       }else{
           //通过验证
           tbUser.setUpdate(new Date());
            //新增用户
           if(tbUser.getId()==null){
               //密码进行MD5加密
               tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
               tbUser.setCreated(new Date());
                insert(tbUser);
               System.out.println("新增用户操作");

           }
           //编辑用户
           else {

               update(tbUser);
           }
       }
       //返回成功信息
        return BaseResult.success("新增用户成功");
    }

    @Override
    public TbUser log(String email,String password) {
         TbUser tbUser=dao.selectByemail(email);
         if(tbUser!=null){
             String md5password= DigestUtils.md5DigestAsHex(password.getBytes());
             if(md5password.equals(tbUser.getPassword())){
                 return tbUser;
             }
         }

         return null;
    }











}

