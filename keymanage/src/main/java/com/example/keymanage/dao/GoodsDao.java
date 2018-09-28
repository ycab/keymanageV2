package com.example.keymanage.dao;

import com.example.keymanage.Util.HttpUtil;
import com.example.keymanage.model.Url;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;

/**
 * @Description: $
 * @Param: $
 * @return: $
 * @Author: your name
 * @date: $
 */
public class GoodsDao {
    public static String getCabinetList(String param)
    {
        String url= Url.apiUrl;
        url=url+"goods/cabinetforgoods/getlist";
        return HttpUtil.HttpGet(url+param);
    }
    public static String editCabinet(String param)
    {
        String url=Url.apiUrl;
        url=url+"goods/cabinetforgoods/edit";
        return HttpUtil.HttpPost(url,param);
    }
    public static String getGoodsList(String param)
    {
        String url= Url.apiUrl;
        url=url+"goods/goods/getlist";
        return HttpUtil.HttpGet(url+param);
    }
    public static String editGoods(String param)
    {
        String url=Url.apiUrl;
        url=url+"goods/goods/edit";
        return HttpUtil.HttpPost(url,param);
    }
    public static String getApplyList(String param)
    {
        String url= Url.apiUrl;
        url=url+"goods/getapplylist";
        return HttpUtil.HttpGet(url+param);
    }
    public static String pass(String param)
    {
        String url= Url.apiUrl;
        url=url+"goods/pass";
        return HttpUtil.HttpPost(url,param);
    }
    public static String notPass(String param)
    {
        String url= Url.apiUrl;
        url=url+"goods/notpass";
        return HttpUtil.HttpPost(url,param);
    }
    public static String getApplyRecord(String param)
    {
        String url= Url.apiUrl;
        url=url+"goods/getapplyrecord";
        return HttpUtil.HttpGet(url+param);
    }
}
