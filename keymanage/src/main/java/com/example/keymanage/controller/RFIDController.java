package com.example.keymanage.controller;

import com.alibaba.fastjson.JSON;
import com.example.keymanage.dao.CabinetRepository;
import com.example.keymanage.dao.GoodsManageRepository;
import com.example.keymanage.dao.RfidDao;
import com.example.keymanage.model.Cabinet;
import com.example.keymanage.model.GoodsManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @Description: $
 * @Param: $
 * @return: $
 * @Author: your name
 * @date: 2018.8.18$
 */
@RestController
@RequestMapping("/rfid")
public class RFIDController {
    @Autowired
    private GoodsManageRepository goodsManageRepository;
    @Autowired
    private CabinetRepository cabinetRepository;
    @GetMapping("/getlist")
    public String getlist(HttpServletRequest request)
    {
        String id=request.getParameter("id");
        try {
            id= URLEncoder.encode(id,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String param="?id="+id;
        return RfidDao.getList(param);

    }
    @PostMapping("/edit")
    public String edit(HttpServletRequest request)
    {
        String oper=request.getParameter("oper");
        if(oper.equals("add"))
        {

        }
        else if(oper.equals("edit"))
        {
            String id=request.getParameter("id");
            String rfid=request.getParameter("rfid");
            String param1="id="+id+"&rfid="+rfid;
            RfidDao.edit(param1);
        }
        else if(oper.equals("del"))
        {

        }
        return "ok";
    }
}
