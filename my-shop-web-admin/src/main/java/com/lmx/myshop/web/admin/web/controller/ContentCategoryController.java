package com.lmx.myshop.web.admin.web.controller;

import com.lmx.myshop.commons.dto.BaseResult;
import com.lmx.myshop.domain.TbContentCategory;
import com.lmx.myshop.web.admin.abstracts.AbstractBaseTreeController;
import com.lmx.myshop.web.admin.service.TbContentCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LMX on 2019/7/31 19:19
 */
    @Controller
    @RequestMapping(value = "content/category")
    public class ContentCategoryController extends AbstractBaseTreeController<TbContentCategory, TbContentCategoryService> {




        @ModelAttribute
        public TbContentCategory getTbContentCategory(Long id){
            TbContentCategory tbContentCategory=null;
            //id不为空 则从数据库获取
            if(id !=null){
                tbContentCategory=service.getById(id);
            }else {
                tbContentCategory=new TbContentCategory();
            }
            return tbContentCategory;
        }





        /**
         * 进行节点类目层级的排序
         * @param model
         * @return
         */
        @RequestMapping(value = "list",method = RequestMethod.GET)
        public String list(Model model){
            List<TbContentCategory> targetList=new ArrayList<>();
            List<TbContentCategory>  sourceList= service.selectAll();
            //排序
            sortList(sourceList,targetList,0L);

            model.addAttribute("tbContentCategories",targetList);
            System.out.println(targetList);
            return "content_category_list";
        }


        /**
         * 树形结构
         *
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "tree/data", method = RequestMethod.POST)
        public List<TbContentCategory> treeData(Long id) {
            if (id == null) {
                id = 0L;
            }
            return service.sellectByPId(id);
        }

        /**
         * 保存内容
         *
         * @return
         */
        @RequestMapping(value = "save", method = RequestMethod.POST)
        public String save(TbContentCategory tbContentCategory, Model model, RedirectAttributes redirectAttributes) {
            BaseResult baseResult=service.save(tbContentCategory);
            if(baseResult.getStatus() == 200){
                redirectAttributes.addFlashAttribute("baseResult", baseResult);
                return "redirect:/content/category/list";
            }else {
                model.addAttribute("baseResult", baseResult);
                return form(tbContentCategory);
            }

        }

        /**
         * 跳转表单页
         *
         * @return
         */
        @RequestMapping(value = "form", method = RequestMethod.GET)
        public String form(TbContentCategory tbContentCategory) {
            return "content_category_form";
        }

        /**
         *
         *删除方法
         */
        @RequestMapping(value = "delete",method = RequestMethod.POST)
        public BaseResult delete(String ids){
            BaseResult baseResult=null;
            if(StringUtils.isNotBlank(ids)){

                service.delete(Long.parseLong(ids));
                baseResult=BaseResult.success("删除分类及其子类及其全部内容成功");
            }else {
                baseResult=BaseResult.fail("删除分类失败");
            }


            return baseResult;
        }



        /**
         *
         * @param sourceList 数据源集合
         * @param targetList 排序后的集合
         * @param parentId  父节点的ID
         */

        private void sortList(List<TbContentCategory> sourceList,List<TbContentCategory> targetList,Long parentId){

            for (TbContentCategory tbContentCategory:sourceList){
                if( tbContentCategory.getParent().getId().equals(parentId)){
                    targetList.add(tbContentCategory);

                    //判断有没有子节点，如果有继续追加
                    if(tbContentCategory.getIsParent()){
                        for (TbContentCategory contentCategory :sourceList){
                            if(contentCategory.getParent().getId().equals(tbContentCategory.getId())){
                                sortList(sourceList,targetList,tbContentCategory.getId());
                                break;
                            }
                        }
                    }

                }

            }

        }




    }


