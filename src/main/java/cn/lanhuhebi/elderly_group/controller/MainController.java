package cn.lanhuhebi.elderly_group.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dxq
 * @date 2019-08-13 - 8:11
 */
@Controller
@RequestMapping("/pub")
public class MainController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/")
    public String login1(){
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@RequestParam("prePhone")String prePhone,@RequestParam("prePassword")String prePassword){
        return null;
    }

    @RequestMapping("/not_permit")
    public String not_permit(){
        return null;
    }
}
