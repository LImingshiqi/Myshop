package com.lmx.myshop.commons.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LMX on 2019/7/31 14:34
 */
public class test {
    public static void main(String[] args) {
        List a=new ArrayList<>();
        for(int i=1;i<9;i++){
                a.add(i);
        }

        a.remove(a.get(5));
        a.remove(a.get(5));
        System.out.println(a);

    }


    }



