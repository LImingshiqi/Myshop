package com.lmx.myshop.web.admin.web.controller;

import com.lmx.myshop.commons.dto.BaseResult;
import com.lmx.myshop.commons.dto.PageInfo;
import com.lmx.myshop.domain.TbContent;
import com.lmx.myshop.domain.TbUser;
import com.lmx.myshop.web.admin.abstracts.AbstractBaseController;

import com.lmx.myshop.web.admin.service.TbContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LMX on 2019/7/20 14:53
 */

@Controller
@RequestMapping(value = "content")
public class TbContentController extends AbstractBaseController<TbContent,TbContentService> {


    @ModelAttribute
    public TbContent getTbContent(Long id){
        TbContent tbContent=null;
        //id不为空从数据库获取
        if(id!=null){
            tbContent = service.getById(id);
        }else {
            tbContent=new TbContent();
        }
        return tbContent;
    }

    /**
     * 显示所有用户
     * @param
     * @return
     */
    @Override
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
    System.out.println("list");
        return "content_list";
    }
    /**
     * 跳转用户
     *
     * @param
     * @return
     */
    @Override
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(){

        return "content_form";

    }
    /**
     * 保存用户信息
     *
     * @param tbContent
     * @param redirectAttributes
     * @return
     */
    @Override
    @RequestMapping(value ="save",method = RequestMethod.POST)
    public String save(TbContent tbContent, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult=service.save(tbContent);
        //保存成功
        if(baseResult.getStatus()==200){
            //重定向使用redirectAttributes将信息存储到session中
            redirectAttributes.addFlashAttribute("baseResult",baseResult);

            return "redirect:/content/list";
        }else {
            //保存失败

            model.addAttribute("baseResult",baseResult);
            return "content_form";
        }
    }
    /**
     *
     *删除内容
     *
     * @param ids
     * @return
     */
    @Override
    @ResponseBody//返回到是json数据RequsetMapping返回的是跳转路径
    @RequestMapping(value = "delete" ,method = RequestMethod.POST)
    public BaseResult delete(String ids){
        System.out.println("zhxiing1");
        BaseResult baseResult=null;
        if(StringUtils.isNotBlank(ids)){
            String[] idArray=ids.split(",");
            service.deleteMulti(idArray);
            baseResult=BaseResult.success("删除内容成功");
        }else {
            baseResult=BaseResult.fail("删除内容失败");
        }
//       BaseResult baseResult=BaseResult.success("成功");
        System.out.println(ids);

        return baseResult;
    }

    /**
     * 用户分页功能
     * @param request
     * @param tbContent
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<TbContent> page(HttpServletRequest request, TbContent tbContent){

        Map<String,Object> result=new HashMap<>();
        String strdraw=request.getParameter("draw");
        String strstart=request.getParameter("start");
        String strlength=request.getParameter("length");
        System.out.println("分页");

        int draw=strdraw==null?0:Integer.parseInt(strdraw);
        int start=strstart==null?0:Integer.parseInt(strstart);
        int length=strlength==null?0:Integer.parseInt(strlength);
        //封装TableUser需要的结果





        //封装DataTabes需要的结果
        PageInfo<TbContent> pageInfo=service.page(start,length,draw,tbContent);
//        //图片路径修改
//        List<TbContent> data=pageInfo.getData();
//        for(TbContent tbContents:data){
//            tbContents.setPic("/static/upload/"+tbContents.getPic());
//        }

        return pageInfo;
    }


    @Override
    @RequestMapping(value = "deliter",method = RequestMethod.GET)
    public String detail() {

        return "content_deliter";
    }

}
