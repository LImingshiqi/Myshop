package com.lmx.myshop.web.ui.API;

import com.lmx.myshop.commons.utils.HttpClienUtils;
import com.lmx.myshop.commons.utils.MapperUtils;
import com.lmx.myshop.domain.TbContent;
import com.lmx.myshop.web.ui.API.api;

import java.util.List;



/**
 * 内容管理接口
 * Created by LMX on 2019/7/31 20:06
 */
public class ContentsApi {

    public static List<TbContent> ppt() {
        List<TbContent> tbContents = null;
        String result = HttpClienUtils.doGet(api.API_CONTENTS_PPT);
        try {
            tbContents = MapperUtils.json2listByTree(result, "data", TbContent.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbContents;
    }
}