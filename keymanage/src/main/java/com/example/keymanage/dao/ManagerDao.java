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
public class ManagerDao {
    public static String getList(String param)
    {
        String url= Url.apiUrl;
        url=url+"manager/getlist";
        return HttpUtil.HttpGet(url+param);
    }
    public static String edit(String param)
    {
        String url=Url.apiUrl;
        url=url+"manager/edit";
        return HttpUtil.HttpPost(url,param);
    }
    public static String add(String param)
    {
        String url=Url.apiUrl;
        url=url+"manager/add";
        return HttpUtil.HttpPost(url,param);
    }
    public static String del(String param)
    {
        String url=Url.apiUrl;
        url=url+"manager/del";
        return HttpUtil.HttpPost(url,param);
    }
}
