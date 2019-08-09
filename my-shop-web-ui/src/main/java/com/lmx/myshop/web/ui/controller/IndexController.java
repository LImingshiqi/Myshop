package com.lmx.myshop.web.ui.controller;




import com.lmx.myshop.commons.utils.MapperUtils;
import com.lmx.myshop.domain.TbContent;
import com.lmx.myshop.web.ui.API.ContentsApi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by LMX on 2019/7/29 23:20
 */
@Controller
public class IndexController {

    /**
     * 跳转首页
     *
     * @return
     */
    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public String index(Model model) {
        // 请求幻灯片
        requestContentsPPT(model);
        return "index";
    }

    /**
     * 请求幻灯片
     *
     * @param model
     */
    private void requestContentsPPT(Model model) {
        List<TbContent> tbContents =ContentsApi.ppt();
        model.addAttribute("ppt", tbContents);
    }
}
