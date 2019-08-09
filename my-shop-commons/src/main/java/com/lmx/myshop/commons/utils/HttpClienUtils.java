package com.lmx.myshop.commons.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.EntityTemplate;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by LMX on 2019/7/30 9:45
 */
public class HttpClienUtils {


    private static final String GET="get";
    private static final String POST="post";


    public static final String REQUEST_HEADER_CONNECTION =  "keep-alive";
    public static final String REQUEST_HEADER_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.87 Safari/537.36";


    /**
     * GET请求
     * @return url请求地址
     */
    public static String doGet(String url){
        return createRequest(url,GET ,null);
    }

    /**
     * GET 请求
     *
     * @param url    请求地址
     * @param cookie cookie
     * @return
     */
    public static String doGet(String url, String cookie) {
        return createRequest(url, GET, cookie);
    }


    /**
     * POST请求
     * @return url请求地址
     * 请求参数可选()
     */
    public static  String doPost(String url, BasicNameValuePair... params){
        return createRequest(url,POST ,null,params);
    }

    /**
     * POST 请求
     *
     * @param url    请求地址
     * @param cookie cookie
     * @param params 请求参数（可选）
     * @return
     */
    public static String doPost(String url, String cookie, BasicNameValuePair... params) {
        return createRequest(url, POST, cookie, params);
    }


    /**
     * 创建请求
     * 请求地址
     * 请求方式
     * @param requestMethod
     * @param cookie
     * @param url
     * @param params
     * @return
     */
    public static String createRequest( String url,String requestMethod, String cookie, BasicNameValuePair... params){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //请求结果
        String result=null;
        try {
            //请求方式
            HttpPost httpPost=null;
            HttpGet httpGet=null;
            //响应
            CloseableHttpResponse httpResponse=null;
            //GET请求
            if(GET.equals(requestMethod)){
                httpGet=new HttpGet(url);
                httpGet.setHeader("Connection", REQUEST_HEADER_CONNECTION);
                httpGet.setHeader("Cookie","");
                httpGet.setHeader("User-Agent", REQUEST_HEADER_USER_AGENT);

                httpResponse=httpClient.execute(httpGet);
            }else
                //POST请求
                if(POST.equals(requestMethod)){
                    httpPost=new HttpPost(url);
                httpPost.setHeader("Connection", REQUEST_HEADER_CONNECTION);
                httpPost.setHeader("Cookie","");
                httpPost.setHeader("User-Agent", REQUEST_HEADER_USER_AGENT);
                    //有参数进来
                    if(params !=null&&params.length>0){
                        httpPost.setEntity(new UrlEncodedFormEntity(Arrays.asList(params),"utf-8"));

                    }
                    httpResponse = httpClient.execute(httpPost);


                    httpClient.execute(httpPost);
            }

            HttpEntity httpEntity=httpResponse.getEntity();
            result =EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(httpClient!=null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return  result;
    }

}
