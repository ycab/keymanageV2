package com.example.keymanage.controller;

import com.alibaba.fastjson.JSON;
import com.example.keymanage.dao.ManagerDao;
import com.example.keymanage.dao.PeopleManageRepository;
import com.example.keymanage.dao.UserDao;
import com.example.keymanage.model.PeopleManage;
import com.example.keymanage.service.TemplateMsgService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description: 人员管理$
 * @Param: $
 * @return: $
 * @Author: your name
 * @date: $
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private PeopleManageRepository peopleManageRepository;
    @Autowired
    TemplateMsgService templateMsgService;
    @PostMapping("/usercodeedit")
    public String usercodemanage(HttpServletRequest request,HttpSession session)
    {
        String result="";
       String phone=session.getAttribute("phone").toString();
       String oldpassword=request.getParameter("oldpassword");
       String newpassword=request.getParameter("newpassword");
        String param1="phone="+phone+"&oldpassword="+oldpassword+"&newpassword="+newpassword;
        String jsonString=UserDao.userCodeEdit(param1);
        JSONObject jsonObject=JSONObject.fromObject(jsonString);
        String info=jsonObject.getString("info");
        String msg=jsonObject.getString("msg");
        if(msg.equals("ok"))return "success";
        else return "error";
    }
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
        return UserDao.getList(param);
    }
    @PostMapping("/edit")
    public String edit(HttpServletRequest request,HttpSession session)
    {
        String oper=request.getParameter("oper");
        if(oper.equals("add"))
        {
            String userName=request.getParameter("userName");
            String password=request.getParameter("password");
            String department=request.getParameter("department");
            String phone=request.getParameter("phone");
            String company=session.getAttribute("company").toString();
            String authority="用户";
            String param1="userName="+userName+"&password="+password+"&department="+department
                    + "&phone="+phone+"&company="+company;
            String jsonString= UserDao.add(param1);
            JSONObject jsonObject=JSONObject.fromObject(jsonString);
            String msg=jsonObject.getString("msg");
            if(msg.equals("error"))return "phoneExists";
            return "ok";
        }
        else if(oper.equals("edit"))
        {
            String id=request.getParameter("id");
            String userName=request.getParameter("userName");
            String password=request.getParameter("password");
            String department=request.getParameter("department");
            String phone=request.getParameter("phone");
            String authority="用户";
            String param1="userName="+userName+"&password="+password+"&department="+department
                    + "&phone="+phone+"&id="+id;
            String jsonString= UserDao.edit(param1);
            JSONObject jsonObject=JSONObject.fromObject(jsonString);
            String msg=jsonObject.getString("msg");
            if(msg.equals("error"))return "phoneExists";
            return "ok";
        }
        else if(oper.equals("del"))
        {
            String id=request.getParameter("id");
            String param1="id="+id;
            UserDao.del(param1);
        }
        return "ok";
    }
    @PostMapping("/pass")
    public String pass(HttpServletRequest request)
    {
        String id=request.getParameter("id");
        String param1="id="+id;
        UserDao.pass(param1);
        return "ok";
    }
    @PostMapping("/notpass")
    public String notpass(HttpServletRequest request)
    {
        String id=request.getParameter("id");
        String param1="id="+id;
        UserDao.notPass(param1);
        return "ok";
    }
    @GetMapping("/getapplylist")
    public String getapplylist(HttpServletRequest request,HttpSession session)
    {
        String id=request.getParameter("id");
        String company=session.getAttribute("company").toString();
        try {
            id=URLEncoder.encode(company,"utf-8");
            company= URLEncoder.encode(company,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String param="?company="+company+"&id="+id;
        return UserDao.getApplyList(param);
    }

}
