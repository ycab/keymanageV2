package com.example.keymanage.controller;

import com.alibaba.fastjson.JSON;
import com.example.keymanage.dao.ApplyRepository;
import com.example.keymanage.dao.CabinetRepository;
import com.example.keymanage.dao.GoodsDao;
import com.example.keymanage.dao.GoodsManageRepository;
import com.example.keymanage.model.Apply;
import com.example.keymanage.model.Cabinet;
import com.example.keymanage.model.GoodsManage;
import com.example.keymanage.Util.HttpUtil;
import com.example.keymanage.service.TemplateMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description: $
 * @Param: $
 * @return: $
 * @Author: your name
 * @date: $
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private CabinetRepository cabinetRepository;
    @Autowired
    private GoodsManageRepository goodsManageRepository;
    @Autowired
    private ApplyRepository applyRepository;
    @Autowired
    TemplateMsgService templateMsgService;
    @Autowired
    HttpUtil httpUtil;

    @GetMapping("/cabinetforgoods/getlist")
    public String getlist(HttpSession session)
    {
        String company=session.getAttribute("company").toString();
        try {
           company= URLEncoder.encode(company,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String param="?company="+company;
        return GoodsDao.getCabinetList(param);
    }
    @PostMapping("/cabinetforgoods/edit")
    public String edit(HttpServletRequest request )
    {
        String oper=request.getParameter("oper");
        if(oper.equals("add"))
        {

        }
        else if(oper.equals("edit"))
        {
            String id=request.getParameter("id");
            String cabinetName=request.getParameter("cabinetName");
            String location=request.getParameter("location");
            String param1="id="+id+"&cabinetName="+cabinetName
                    + "&location="+location;
            GoodsDao.editCabinet(param1);


        }
        else if(oper.equals("del"))
        {

        }
        return "ok";
    }

    @GetMapping("/goods/getlist")
    public String getgoodslist(HttpServletRequest request)
    {
        String id=request.getParameter("id");
        try {
            id= URLEncoder.encode(id,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String param="?id="+id;
        return GoodsDao.getGoodsList(param);
    }
    @PostMapping("/goods/edit")
    public String goodsedit(HttpServletRequest request)
    {
        String oper=request.getParameter("oper");
        if(oper.equals("add"))
        {

        }
        else if(oper.equals("edit"))
        {
            String id=request.getParameter("id");
            String goodName =request.getParameter("goodName");
            String needApproved=request.getParameter("needApproved");
            String param1="id="+id+"&goodName="+goodName
                    + "&needApproved="+needApproved;
            GoodsDao.editGoods(param1);
        }
        else if(oper.equals("del"))
        {

        }
        return "ok";
    }

    @PostMapping("/pass")
    public String pass(HttpServletRequest request)
    {
        String id=request.getParameter("id");
        String param1="id="+id;
        GoodsDao.pass(param1);
        return "ok";
    }
    @PostMapping("/notpass")
    public String notpass(HttpServletRequest request)
    {
        String id=request.getParameter("id");
        String param1="id="+id;
        GoodsDao.notPass(param1);
        return "ok";
    }
    @GetMapping("/getapplylist")
    public String getapplylist(HttpServletRequest request,HttpSession session)
    {
        String company=session.getAttribute("company").toString();
        try {
            company= URLEncoder.encode(company,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String param="?company="+company;
        return GoodsDao.getApplyList(param);
    }
    @GetMapping("/getapplyrecord")
    public String getapplyrecord(HttpServletRequest request,HttpSession session)
    {
        String company=session.getAttribute("company").toString();
        try {
            company= URLEncoder.encode(company,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String param="?company="+company;
        return GoodsDao.getApplyRecord(param);
    }


}
