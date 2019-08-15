package cn.lanhuhebi.elderly_group.controller;

import cn.lanhuhebi.elderly_group.model.dto.Family_team_area;
import cn.lanhuhebi.elderly_group.model.pojo.Area;
import cn.lanhuhebi.elderly_group.model.pojo.Family;
import cn.lanhuhebi.elderly_group.service.AreaService;
import cn.lanhuhebi.elderly_group.service.EquipmentService;
import cn.lanhuhebi.elderly_group.service.FamilyService;
import cn.lanhuhebi.elderly_group.util.AjaxUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class FamilyController {
    @Resource
    private FamilyService familyService;
    @Resource
    private AreaService areaService;
    @Resource
    private EquipmentService equipmentService;


    //初始化list页面
    @RequestMapping("/initfamilylist")
    public String initfamilylist(Model model){
        List<Family_team_area> family_teams = familyService.queryAllFamily();
        model.addAttribute("flist",family_teams);
        return "familylist";
    }
    //到查询所有户信息页面
    @RequestMapping("/tofamilylist")
    public String tofamilylist(Model model){
        return "redirect:/initfamilylist";
    }
    //去添加户信息第一步，添加户基础信息
    @RequestMapping("/toaddfamily")
    public String toaddfamily(Model model){
        model.addAttribute("areas",areaService.queryAllXiaJiByShang(386910));
        return "familyadd";
    }
    //添加户基础信息
    @RequestMapping(value = "/doaddfamilyfirst",method = RequestMethod.POST)
    public String doaddfamilyfirst(Family family,Model model,RedirectAttributes redirectAttributes){
        if(familyService.addFamFirst(family)>0){
            model.addAttribute("addmsg","添加户基础信息成功");
            return "familyadd_equiment";
        }else{
            redirectAttributes.addFlashAttribute("addmsg","添加户基础信息失败");
            return "redirect:/toaddfamily";
        }


    }



    //删除一条户信息
    @RequestMapping("/deletefamily")
    public String deletefamily(@RequestParam("fly_id")Integer fly_id, RedirectAttributes model){
        if(familyService.updateFamilyStatus(fly_id)){
            model.addFlashAttribute("deletemsg","删除成功");
        }else{
            model.addFlashAttribute("deletemsg","删除失败");
        }
        return "redirect:/tofamilylist";
    }
    //ajax动态返回区域
    @RequestMapping(value = "/ajaxArea",method = RequestMethod.POST)
    public void ajax(@RequestParam("area_id")Integer area_id, HttpServletResponse response){
        List<Area> areas = areaService.queryAllXiaJiByShang(area_id);
        AjaxUtils.jsonforward(areas,response);
    }
    //ajax查询户名是否已经添加
    @RequestMapping(value ="/ajaxflyname",method = RequestMethod.POST)
    public void ajaxflyname(@RequestParam("fly_name")String fly_name,HttpServletResponse response){
        Family family = this.familyService.queryOneByName(fly_name);
        System.out.println(family+"*******************");
        boolean flag;
        if(family!=null){
            flag=true;
        }else{
            flag=false;
        }
        AjaxUtils.jsonforward(flag,response);


    }








}
