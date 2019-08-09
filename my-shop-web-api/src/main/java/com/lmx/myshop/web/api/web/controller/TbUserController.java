package com.lmx.myshop.web.api.web.controller;

import com.lmx.myshop.commons.dto.BaseResult;
import com.lmx.myshop.domain.TbUser;
import com.lmx.myshop.web.api.service.TbUserService;
import com.lmx.myshop.web.api.web.dto.TbUserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LMX on 2019/8/1 10:34
 */
@RestController
@RequestMapping(value = "${api.path.v1}/users")
public class TbUserController {


    @Autowired
    private TbUserService tbUserService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public BaseResult Login(TbUserDto tbUserDto){
        TbUser user=tbUserService.Login(tbUserDto);
        if(user==null){
            return BaseResult.fail("登录失败");
        }else {
            TbUserDto dto=new TbUserDto();
            BeanUtils.copyProperties(user,dto);
            return BaseResult.success("成功",dto);
        }

    }
    /**
     * 注册用户
     * @param tbUserDto
     * @return
     */
    @RequestMapping(value = "register" ,method = RequestMethod.POST)
    public BaseResult register(TbUserDto tbUserDto){
        BaseResult baseResult=tbUserService.register(tbUserDto);
        if(baseResult.getStatus()==200){
            return BaseResult.success("保存成功");
        }else {
            BaseResult.fail("保存用户失败");
        }
        return null;

    }


}
