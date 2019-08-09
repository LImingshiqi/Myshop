package com.lmx.myshop.web.ui.API;

/**
 * Created by LMX on 2019/7/31 10:19
 */
public class api {        // 主机地址
    public static final String HOST = "http://localhost:8081/api/v1";

    // 内容查询接口 - 幻灯片
    public static final String API_CONTENTS_PPT = HOST + "/contents/ppt";

    // 会员管理接口 - 登录
    public static final String API_USERS_LOGIN = HOST + "/users/login";

    // 会员管理接口 - 注册
    public static final String API_USERS_REGISTER = HOST + "/users/register";
}
