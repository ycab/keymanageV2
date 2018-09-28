package com.example.keymanage.controller;

import com.alibaba.fastjson.JSON;
import com.example.keymanage.dao.CabinetDao;
import com.example.keymanage.dao.PeopleManageRepository;
import com.example.keymanage.dao.SuperManageDao;
import com.example.keymanage.model.PeopleManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @Description: 超级管理员$
 * @Param: $
 * @return: $
 * @Author: your name
 * @date: $
 */
@RestController
@RequestMapping("/supermanage")
public class SuperManageController {
    @Autowired
    private PeopleManageRepository peopleManageRepository;
    @GetMapping("/getlist")
    public String getlist()
    {
       return SuperManageDao.getList();
    }
    @PostMapping("/edit")
    public String edit(HttpServletRequest request )
    {
        String oper=request.getParameter("oper");
        if(oper.equals("add"))
        {
            String name=request.getParameter("userName");
            String password=request.getParameter("password");
            String company=request.getParameter("company");
            String department=request.getParameter("department");
            String phone=request.getParameter("phone");
            String param1="userName="+name+"&password="+password+"&company="+company
                    + "&department="+department+"&phone="+phone;
            SuperManageDao.add(param1);
        }
        else if(oper.equals("edit"))
        {
            String id=request.getParameter("id");
            String name=request.getParameter("userName");
            String password=request.getParameter("password");
            String company=request.getParameter("company");
            String department=request.getParameter("department");
            String phone=request.getParameter("phone");
            String param1="userName="+name+"&password="+password+"&company="+company
                    + "&department="+department+"&phone="+phone+"&id="+id;
            SuperManageDao.edit(param1);
        }
        else if(oper.equals("del"))
        {
            String id=request.getParameter("id");
            String param1="id="+id;
            SuperManageDao.del(param1);
        }
        return "ok";
    }
}
