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
public class RfidDao {
    public static String getList(String param)
    {
        String url= Url.apiUrl;
        url=url+"rfid/getlist";
        return HttpUtil.HttpGet(url+param);
    }
    public static String edit(String param)
    {
        String url=Url.apiUrl;
        url=url+"rfid/edit";
        return HttpUtil.HttpPost(url,param);
    }
}
