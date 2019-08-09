package com.lmx.myshop.web.admin.web.controller;

import com.lmx.myshop.commons.dto.BaseResult;
import com.lmx.myshop.commons.dto.PageInfo;
import com.lmx.myshop.domain.TbContentCategory;
import com.lmx.myshop.domain.TbUser;
import com.lmx.myshop.web.admin.abstracts.AbstractBaseController;

import com.lmx.myshop.web.admin.service.TbContentCategoryService;
import com.lmx.myshop.web.admin.service.TbUserService;
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

@Controller
@RequestMapping(value = "user")
public class UserController  extends AbstractBaseController<TbUser, TbUserService> {



    @ModelAttribute
    public TbUser getTbUser(Long id){
        TbUser tbUser=null;
        //id不为空从数据库获取
        if(id!=null){
            tbUser = service.getById(id);
        }else {
            tbUser=new TbUser();
        }
        return tbUser;
    }

    /**
     * 显示所有用户
     * @param
     * @return
     */
    @Override
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){

        return "user_list";
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

        return "user_form";

    }

    /**
     * 保存用户信息
     *
     * @param tbUser
     * @param redirectAttributes
     * @return
     */
    @Override
    @RequestMapping(value ="save",method = RequestMethod.POST)
    public String save(TbUser tbUser,Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult=service.save(tbUser);
        //保存成功
        if(baseResult.getStatus()==200){
            //重定向使用redirectAttributes将信息存储到session中
            redirectAttributes.addFlashAttribute("baseResult",baseResult);

            return "redirect:/user/list";
        }else {
            //保存失败

            model.addAttribute("baseResult",baseResult);
            return "user_form";
        }


    }


    /**
     *
     *删除用户
     *
     * @param ids
     * @return
     */

    @ResponseBody//返回到是json数据RequsetMapping返回的是跳转路径
    @RequestMapping(value = "delete" ,method = RequestMethod.POST)
    public BaseResult delete(String ids){
        System.out.println("zhxiing1");
        BaseResult baseResult=null;
        if(StringUtils.isNotBlank(ids)){
            String[] idArray=ids.split(",");
            service.deleteMulti(idArray);
           baseResult=BaseResult.success("删除用户成功");
        }else {
           baseResult=BaseResult.fail("删除用户失败");
        }
//       BaseResult baseResult=BaseResult.success("成功");
        System.out.println(ids);

        return baseResult;
    }




    @RequestMapping(value = "deliter",method = RequestMethod.GET)
    public String detail(){

        return "user_deliter";
    }




}
