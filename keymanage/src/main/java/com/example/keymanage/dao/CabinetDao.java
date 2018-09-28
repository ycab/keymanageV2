package com.example.keymanage.dao;

import com.example.keymanage.Util.HttpUtil;
import com.example.keymanage.model.Cabinet;
import com.example.keymanage.model.Url;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @Description: $
 * @Param: $
 * @return: $
 * @Author: your name
 * @date: $
 */
public class CabinetDao {
    public static String getList()
    {
        String url= Url.apiUrl;
        url=url+"Cabinet/getAll";
        return HttpUtil.HttpGet(url);
    }
    public static String add(String param)
    {
        String url=Url.apiUrl;
        url=url+"Cabinet/add";
        return HttpUtil.HttpPost(url,param);
    }
    public static String edit(String param)
    {
        String url=Url.apiUrl;
        url=url+"Cabinet/edit";
        return HttpUtil.HttpPost(url,param);
    }
    public static String del(String param)
    {
        String url=Url.apiUrl;
        url=url+"Cabinet/del";
        return HttpUtil.HttpPost(url,param);

    }
}
