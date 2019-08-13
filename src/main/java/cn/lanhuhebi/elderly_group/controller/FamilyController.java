package cn.lanhuhebi.elderly_group.controller;

import cn.lanhuhebi.elderly_group.model.dto.Family_team_area;
import cn.lanhuhebi.elderly_group.service.FamilyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class FamilyController {
    @Resource
    private FamilyService familyService;

    @RequestMapping("/")
    public String init(){
        return "index";
    }
    //到查询所有户信息页面
    @RequestMapping("/tofamilylist")
    public String tofamilylist(Model model){
        List<Family_team_area> family_teams = familyService.queryAllFamily();
        model.addAttribute("flist",family_teams);
        return "familylist";
    }





}
