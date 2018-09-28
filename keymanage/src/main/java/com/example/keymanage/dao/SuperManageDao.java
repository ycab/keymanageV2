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
public class SuperManageDao {
    public static String getList()
    {
        String url= Url.apiUrl;
        url=url+"supermanage/getlist";
        return HttpUtil.HttpGet(url);
    }
    public static String edit(String param)
    {
        String url=Url.apiUrl;
        url=url+"supermanage/edit";
        return HttpUtil.HttpPost(url,param);
    }
    public static String add(String param)
    {
        String url=Url.apiUrl;
        url=url+"supermanage/add";
        return HttpUtil.HttpPost(url,param);
    }
    public static String del(String param)
    {
        String url=Url.apiUrl;
        url=url+"supermanage/del";
        return HttpUtil.HttpPost(url,param);
    }
}
