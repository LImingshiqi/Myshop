package com.lmx.myshop.web.admin.service.test;

import com.lmx.myshop.domain.TbUser;
import com.lmx.myshop.web.admin.dao.TbUserDao;
import com.lmx.myshop.web.admin.service.TbUserService;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {
    @Autowired
    private TbUserService tbUserService;


    @Test
    public void testSelectAll(){
        List<TbUser> tbUsers= tbUserService.selectAll();
        for(TbUser tbUser:tbUsers){
        System.out.println(tbUser);
        }
    }

    @Test
    public void inserttest(){
        TbUser tbUser = new TbUser();
        tbUser.setEmail("admin@admin.com");
        tbUser.setPassword("admin");
        tbUser.setPhone("15888888888");
        tbUser.setUsername("Lusifer");
        tbUser.setCreated(new Date());
        tbUser.setUpdate(new Date());

        tbUserService.save(tbUser);
    }

    @Test
    public void testGetById() {
        TbUser tbUser = tbUserService.getById(36L);
        System.out.println(tbUser.getUsername());
    }
    @Test
    public void testUpdate() {
        TbUser tbUser = tbUserService.getById(36L);
        tbUser.setUsername("Lusifer");

        tbUserService.update(tbUser);
    }

    @Test
    public void testMD5(){
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));
    }
    @Test
    public void testpage(){
        TbUser tbUsers = new TbUser();

                tbUserService.page(1,0,1,tbUsers);

    }

    public static  String converMD5(String str){
        char[] a=str.toCharArray();
        for(int i=0;i<a.length;i++){
            a[i]=(char)(a[i]^ 't');
        }
        String s=new String(a);
        return s;
    }



}
