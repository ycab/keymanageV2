package com.example.keymanage.dao;

import com.example.keymanage.Util.HttpUtil;
import com.example.keymanage.model.Url;

/**
 * @Description: $
 * @Param: $
 * @return: $
 * @Author: your name
 * @date: $
 */
public class UserDao {
    public static String userCodeEdit(String param)
    {
        String url=Url.apiUrl;
        url=url+"user/usercodeedit";
        return HttpUtil.HttpPost(url,param);
    }
    public static String getList(String param)
    {
        String url= Url.apiUrl;
        url=url+"user/getlist";
        return HttpUtil.HttpGet(url+param);
    }
    public static String edit(String param)
    {
        String url=Url.apiUrl;
        url=url+"user/edit";
        return HttpUtil.HttpPost(url,param);
    }
    public static String add(String param)
    {
        String url=Url.apiUrl;
        url=url+"user/add";
        return HttpUtil.HttpPost(url,param);
    }
    public static String del(String param)
    {
        String url=Url.apiUrl;
        url=url+"user/del";
        return HttpUtil.HttpPost(url,param);
    }
    public static String getApplyList(String param)
    {
        String url= Url.apiUrl;
        url=url+"user/getapplylist";
        return HttpUtil.HttpGet(url+param);
    }
    public static String pass(String param)
    {
        String url= Url.apiUrl;
        url=url+"user/pass";
        return HttpUtil.HttpPost(url,param);
    }
    public static String notPass(String param)
    {
        String url= Url.apiUrl;
        url=url+"user/notpass";
        return HttpUtil.HttpPost(url,param);
    }
}
