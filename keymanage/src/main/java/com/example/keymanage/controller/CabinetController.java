package com.example.keymanage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.keymanage.Util.HttpUtil;
import com.example.keymanage.dao.CabinetDao;
import com.example.keymanage.dao.CabinetRepository;
import com.example.keymanage.dao.GoodsManageRepository;
import com.example.keymanage.dao.PeopleManageRepository;
import com.example.keymanage.model.Cabinet;
import com.example.keymanage.model.GoodsManage;
import com.example.keymanage.model.PeopleManage;
import com.example.keymanage.model.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description: $
 * @Param: $
 * @return: $
 * @Author: your name
 * @date: 2018.8.15$
 */
@RestController
@RequestMapping("/cabinet")
public class CabinetController {
    @Autowired
    private CabinetRepository cabinetRepository;
    @Autowired
    private GoodsManageRepository goodsManageRepository;
    @GetMapping("/getlist")
    public String getlist(HttpSession session)
    {
        return CabinetDao.getList();
    }
    @PostMapping("/edit")
    public String edit(HttpServletRequest request )
    {
        String oper=request.getParameter("oper");
        if(oper.equals("add"))
        {
            String mac=request.getParameter("mac");
            String company=request.getParameter("company");
            String cabinetName=request.getParameter("cabinetName");
            String location=request.getParameter("location");
            String numofdoor=request.getParameter("numofdoor");
            String param1="mac="+mac+"&company="+company+"&cabinetName="+cabinetName
                           + "&location="+location+"&numofdoor="+numofdoor;
            CabinetDao.add(param1);
        }
        else if(oper.equals("edit"))
        {
            String id=request.getParameter("id");
            String mac=request.getParameter("mac");
            String company=request.getParameter("company");
            String cabinetName=request.getParameter("cabinetName");
            String location=request.getParameter("location");
            String param1="id="+id+"&mac="+mac+"&company="+company+"&cabinetName="+cabinetName
                    + "&location="+location;
            CabinetDao.edit(param1);

        }
        else if(oper.equals("del"))
        {
            String id=request.getParameter("id");
            String param1="id="+id;
            CabinetDao.del(param1);

        }
        return "ok";
    }
}
