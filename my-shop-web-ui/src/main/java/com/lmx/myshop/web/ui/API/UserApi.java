package com.lmx.myshop.web.ui.API;

import com.lmx.myshop.commons.utils.HttpClienUtils;
import com.lmx.myshop.commons.utils.MapperUtils;
import com.lmx.myshop.domain.TbContent;

import com.lmx.myshop.web.ui.dto.TbUser;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LMX on 2019/8/1 10:47
 */
public class UserApi {
    /**
     * 登录
     * @return
     */
    public static TbUser login(TbUser tbUser) throws Exception {
        List<BasicNameValuePair> params=new ArrayList<>();
        params.add(new BasicNameValuePair("username",tbUser.getUsername()));
        params.add(new BasicNameValuePair("password",tbUser.getPassword()));
        String json= HttpClienUtils.doPost(api.API_USERS_LOGIN,params.toArray(new BasicNameValuePair[params.size()]));
        TbUser user= MapperUtils.json2pojoByTree(json,"data",TbUser.class);
        return user;
    }

    /**
     * 注册
     */
    public static TbUser register(TbUser tbUser)throws Exception{
        List<BasicNameValuePair> params=new ArrayList<>();
        params.add(new BasicNameValuePair("username",tbUser.getUsername()));
        params.add(new BasicNameValuePair("password",tbUser.getPassword()));
        params.add(new BasicNameValuePair("phone",tbUser.getPhone()));
        params.add(new BasicNameValuePair("email",tbUser.getEmail()));
        String json= HttpClienUtils.doPost(api.API_USERS_REGISTER,params.toArray(new BasicNameValuePair[params.size()]));
        TbUser user= MapperUtils.json2pojoByTree(json,"data",TbUser.class);
        return user;
    }

}
