package com.lmx.myshop.web.admin.service.impl;


import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by LMX on 2019/7/25 10:05
 */
public class Test extends  Thread {

    public static BlockingQueue<String> queue=new LinkedBlockingQueue<String>(3);

    private int index;

    public Test(int i){
        this.index=i;
    }

    public void run(){
        try{
            queue.put(String.valueOf(this.index));
        }catch (Exception e){
        e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService service= Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            service.submit(new Test(i));

        }
        Thread thread=new Thread(){
            public void run(){
                try {
                while (true){
                    Thread.sleep((int)(Math.random()*1000));
                    System.out.println("================="+Test.queue.size());
                    if(Test.queue.isEmpty())
                        break;
                    String str=Test.queue.take();
                    System.out.println(str+"has take");
                }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
            service.submit(thread);
            service.shutdown();


    }
}
