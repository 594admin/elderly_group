package cn.lanhuhebi.elderly_group.controller;

import cn.lanhuhebi.elderly_group.model.dto.Family_team_area;
import cn.lanhuhebi.elderly_group.model.pojo.Area;
import cn.lanhuhebi.elderly_group.model.pojo.Equipment;
import cn.lanhuhebi.elderly_group.model.pojo.Family;
import cn.lanhuhebi.elderly_group.service.AreaService;
import cn.lanhuhebi.elderly_group.service.FamilyService;
import cn.lanhuhebi.elderly_group.service.TeamService;
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
    private TeamService teamService;



    //初始化list页面
    @RequestMapping("/initfamilylist")
    public String initfamilylist(Model model){
        List<Family_team_area> family_teams = familyService.queryAllFamily();
        model.addAttribute("flist",family_teams);
        return "family/familylist";
    }
    //到查询所有户信息页面
    @RequestMapping("/tofamilylist")
    public String tofamilylist(Model model){
        return "redirect:/initfamilylist";
    }
    //去添加户信息第一步，添加户基础信息
    @RequestMapping("/toaddfamily")
    public String toaddfamily(Model model){
        model.addAttribute("teams",this.teamService.queryAllTeam());
        model.addAttribute("areas",areaService.queryAllXiaJiByShang(386910));
        return "family/familyadd";
    }
    //继续录入信息或者编辑已经完成录入信息
    @RequestMapping("/tosecond")
    public String tosecond(@RequestParam("fly_status")Integer fly_status){
        if(fly_status==2){
            return "family/familyadd_equiment";
        }else if(fly_status==3){
            return "family/familyadd_img";
        }else{
            return "";
        }
    }
    //添加户基础信息
    @RequestMapping(value = "/doaddfamilyfirst",method = RequestMethod.POST)
    public String doaddfamilyfirst(Family family, Model model,RedirectAttributes redirectAttributes){
        System.out.println(family.getFly_ispoor());
        if(familyService.addFamFirst(family)>0){
            model.addAttribute("addmsg","添加户基础信息成功");
            return "family/familyadd_equiment";
        }else{
            redirectAttributes.addFlashAttribute("addmsg","添加户基础信息失败");
            return "redirect:/toaddfamily";
        }
    }
    //添加资料
    @RequestMapping("/dofamilyadd_img")
    public String dofamilyadd_img(){

        return "family/familyadd_img";
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
    @RequestMapping(value = "/ajax",method = RequestMethod.POST)
    public void ajax( @RequestParam(value = "ept_type",required = false)String ept_type,
                      @RequestParam(value = "ept_facty",required = false)String ept_facty,
                      @RequestParam(value = "ept_model",required = false)String ept_model,
                      @RequestParam(value = "area_id",required = false)Integer area_id,
                      @RequestParam(value = "fly_name",required = false)String fly_name,
                      HttpServletResponse response){
        if(area_id!=null){
           List<Area> areas = areaService.queryAllXiaJiByShang(area_id);
           AjaxUtils.jsonforward(areas,response);
       }
       if(fly_name!=null){
           Family family = this.familyService.queryOneByName(fly_name);
           boolean flag;
           if(family!=null){
               flag=true;
           }else{
               flag=false;
           }
           AjaxUtils.jsonforward(flag,response);
       }
       if(ept_type!=null && ept_facty!=null && ept_model!=null){
           Equipment equipment=new Equipment();
           equipment.setEptType(ept_type);
           equipment.setEptFacty(ept_facty);
           equipment.setEptModel(ept_model);
           System.out.println(this.familyService.getEptPrice(equipment)+"************************");
           AjaxUtils.jsonforward(this.familyService.getEptPrice(equipment),response);
       }

    }


}
