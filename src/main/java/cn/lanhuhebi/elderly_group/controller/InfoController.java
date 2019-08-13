package cn.lanhuhebi.elderly_group.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoController {
    //登录成功后去主页面
    @RequestMapping(value = "/info")
    public String info(){
        return "index";
    }
}
