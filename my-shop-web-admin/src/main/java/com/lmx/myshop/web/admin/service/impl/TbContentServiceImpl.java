package com.lmx.myshop.web.admin.service.impl;

import com.lmx.myshop.commons.dto.BaseResult;
import com.lmx.myshop.commons.validator.BeanValidator;
import com.lmx.myshop.domain.TbContent;
import com.lmx.myshop.web.admin.abstracts.AbstractBaseServiceImpl;
import com.lmx.myshop.web.admin.dao.TbContentDao;
import com.lmx.myshop.web.admin.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
/**
 * Created by LMX on 2019/7/20 11:10
 */
    @Service

    public class TbContentServiceImpl extends AbstractBaseServiceImpl<TbContent, TbContentDao> implements TbContentService {

        @Autowired
        private  TbContentService tbContentService;

        @Override

        public BaseResult save(TbContent tbContent) {
            /**
             * 检验用户返回成功的状态码,通过验证
             */

            String validator= BeanValidator.validator(tbContent);
            //验证不通过
            if(validator!=null){
                return BaseResult.fail(validator);
            }else {
                //验证通过
                tbContent.setUpdate(new Date());
                //新增用户
                if(tbContent.getId()==null){

                    tbContent.setCreated(new Date());
                    insert(tbContent);
                    System.out.println("新增内容操作");

                }
                //编辑用户
                else {

                    update(tbContent);
                }
                //返回成功信息

                return BaseResult.success("保存内容信息成功");
            }
        }












    }





