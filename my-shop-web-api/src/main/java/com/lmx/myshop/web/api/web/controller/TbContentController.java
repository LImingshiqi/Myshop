package com.lmx.myshop.web.api.web.controller;

import com.lmx.myshop.commons.dto.BaseResult;
import com.lmx.myshop.domain.TbContent;
import com.lmx.myshop.web.api.service.TbContentService;
import com.lmx.myshop.web.api.web.dto.TbContentDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LMX on 2019/7/30 16:46
 */

@RestController
//Restfoul风格的API
@RequestMapping(value = "${api.path.v1}/contents")
public class TbContentController {

    @Autowired
    private TbContentService tbContentService;


    @ModelAttribute
    public TbContent tbContent(Long id){
        TbContent tbContent=null;
        if(id==null){
            tbContent=new TbContent();
        }
        return tbContent;
    }


    @RequestMapping(value = "ppt",method = RequestMethod.GET)
    public BaseResult finadppt(){
        List<TbContentDto> tbContentDtos=null;
        List<TbContent> tbContents=tbContentService.selectByCategoryId(89L);

            if(tbContents!=null && tbContents.size()>0){
                tbContentDtos =new ArrayList<>();
                for(TbContent tbContent:tbContents){
                    TbContentDto dto=new TbContentDto();
                    BeanUtils.copyProperties(tbContent,dto);
                    tbContentDtos.add(dto);
                }
            }

        return BaseResult.success("成功",tbContentDtos);
    }
}
