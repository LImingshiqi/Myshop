package com.lmx.myshop.web.admin.service.test;

import com.lmx.myshop.domain.TbContent;
import com.lmx.myshop.domain.TbUser;
import com.lmx.myshop.web.admin.service.TbContentService;
import com.lmx.myshop.web.admin.service.TbUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by LMX on 2019/7/20 22:25
 */
public class TbContentTest {
    @Autowired
    private TbContentService tbContentService;

    @Test
    public void testpage(){
        TbContent tbContent = new TbContent();

        tbContentService.page(1,0,1,tbContent);

    }
}
