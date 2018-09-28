package com.example.keymanage.controller;

import com.example.keymanage.dao.CheckInfo;
import com.example.keymanage.dao.PeopleManageRepository;
import com.example.keymanage.model.PeopleManage;
import com.example.keymanage.service.TemplateMsgService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/Login")
public class LoginController {
    @Autowired
    private PeopleManageRepository peopleManageRepository;
    @Autowired
    private TemplateMsgService templateMsgService;

    /**
     * @Description: 验证登录信息$
     * @Param: $
     * @return: 正确返回ok，错误返回error$
     * @Author: yu peng
     * @date: 2018.8.14$
     */
    @PostMapping(value="/checkinfo")
    public String Login(HttpServletRequest request, HttpSession session, Model model)
    {
        String phone=request.getParameter("username");
        String pwd=request.getParameter("pwd");
        String jsonString= CheckInfo.checkinfo(phone,pwd);
        JSONObject jsonObject=JSONObject.fromObject(jsonString);
        String info=jsonObject.getString("info");
        String msg=jsonObject.getString("msg");
        if(msg.equals("error"))return "error";
        if(msg.equals("ok"))
        {
            JSONObject infoObject=jsonObject.fromObject(info);
            PeopleManage a=(PeopleManage) JSONObject.toBean(infoObject,PeopleManage.class);
            session.setAttribute("phone",phone);
            session.setAttribute("authority",infoObject.getString("authority"));
            session.setAttribute("name",infoObject.getString("userName"));
            session.setAttribute("company",infoObject.get("company"));
            model.addAttribute("authority",infoObject.getString("authority"));
             return "ok";
        }

        return "error";

    }
}
