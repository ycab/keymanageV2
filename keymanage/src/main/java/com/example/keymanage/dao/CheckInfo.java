package com.example.keymanage.dao;

import com.example.keymanage.model.Url;
import com.example.keymanage.Util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Description: $
 * @Param: $
 * @return: $
 * @Author: your name
 * @date: $
 */
public class CheckInfo {
    public static String checkinfo(String phone,String pwd)
    {
        try {
            phone= URLEncoder.encode(phone,"utf-8");
            pwd=URLEncoder.encode(pwd,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url= Url.apiUrl;
        url=url+"Login/checkinfo?phone="+phone+"&pwd="+pwd;
         return HttpUtil.HttpGet(url);
    }
}
