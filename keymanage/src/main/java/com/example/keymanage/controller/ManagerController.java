package com.example.keymanage.controller;

import com.alibaba.fastjson.JSON;
import com.example.keymanage.dao.GoodsDao;
import com.example.keymanage.dao.ManagerDao;
import com.example.keymanage.dao.PeopleManageRepository;
import com.example.keymanage.model.GoodsManage;
import com.example.keymanage.model.PeopleManage;
import com.example.keymanage.service.PhoneService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @Description: 管理员管理$
 * @Param: $
 * @return: $
 * @Author: your name
 * @date: $
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private PeopleManageRepository peopleManageRepository;
    @Autowired
    private PhoneService phoneService;
    @GetMapping("/getlist")
    public String getlist(HttpSession session)
    {
        String company=session.getAttribute("company").toString();
        try {
            company= URLEncoder.encode(company,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String param="?company="+company;
        return ManagerDao.getList(param);
    }
    @PostMapping("/edit")
    public String edit(HttpServletRequest request,HttpSession session )
    {
        String oper=request.getParameter("oper");
        if(oper.equals("add"))
        {
            String name=request.getParameter("userName");
            String password=request.getParameter("password");
            String department=request.getParameter("department");
            String phone=request.getParameter("phone");
            String company=session.getAttribute("company").toString();
            String param1="userName="+name+"&password="+password+"&department="+department
                    + "&phone="+phone+"&company="+company;
            String jsonString=ManagerDao.add(param1);
            JSONObject jsonObject=JSONObject.fromObject(jsonString);
            String msg=jsonObject.getString("msg");
            if(msg.equals("error"))return "phoneExists";
            return "ok";
        }
        else if(oper.equals("edit"))
        {
            String id=request.getParameter("id");
            String name=request.getParameter("userName");
            String password=request.getParameter("password");
            String department=request.getParameter("department");
            String phone=request.getParameter("phone");
            String authority="管理员";
            String param1="userName="+name+"&id="+id+"&password="+password+"&department="+department
                    + "&phone="+phone;
            String jsonString=ManagerDao.edit(param1);
            JSONObject jsonObject=JSONObject.fromObject(jsonString);
            String msg=jsonObject.getString("msg");
            if(msg.equals("error"))return "phoneExists";
            return "ok";

        }
        else if(oper.equals("del"))
        {
            String id=request.getParameter("id");
            String param1="id="+id;
            ManagerDao.del(param1);
        }
        return "ok";
    }
}
