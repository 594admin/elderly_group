package cn.lanhuhebi.elderly_group.controller;

import cn.lanhuhebi.elderly_group.model.dto.TeamListVO;
import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import cn.lanhuhebi.elderly_group.model.pojo.Team;
import cn.lanhuhebi.elderly_group.service.TeamService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * @author FanWeichong
 * @date 2019-08-18 17:02
 */
@Controller
public class TeamController {

    @Resource
    private TeamService teamService;

    @RequestMapping("/showTeamList")
    public String showTeamList(Model model){
        model.addAttribute("leaderList",teamService.queryAllTeamLeader());
        model.addAttribute("Informationers",teamService.queryAllInformationer());
        model.addAttribute("WarehouseManagers",teamService.queryAllWarehouseManager());
        model.addAttribute("Installers",teamService.queryAllInstaller());
        model.addAttribute("TeamList",teamService.queryAllTeamVO());
        return "team/teamList";
    }

    @RequestMapping(value = "/addTeam",method = RequestMethod.POST)
    public String addTeam(String teamName, Integer teamLeader,
                          Integer[] informationer, Integer[] warehousemanager,
                          Integer[] installer, HttpServletRequest request){
        HttpSession session=request.getSession();
        Personnel personnel= (Personnel) session.getAttribute("personnel");
        Integer creatorId=personnel.getPreId();
        teamService.addTeam(teamName,teamLeader,informationer,warehousemanager,installer,creatorId);
        return "redirect:/showTeamList";
    }

    @RequestMapping(value = "/edtTeamById",method = RequestMethod.POST)
    public String edtTeam(Integer edt_teamId,String edt_teamName, Integer edt_teamLeader,
                          Integer[] edt_informationer, Integer[] edt_warehousemanger,
                          Integer[] edt_installer, HttpServletRequest request){
        HttpSession session=request.getSession();
        Personnel personnel= (Personnel) session.getAttribute("personnel");
        Integer creatorId=personnel.getPreId();
        teamService.updTeam(edt_teamId,edt_teamName,edt_teamLeader,edt_informationer,
                edt_warehousemanger,edt_installer,creatorId);
        return "redirect:/showTeamList";
    }


/*************编辑小组所需四个异步*************/
    @RequestMapping(value = "/getTeamById",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    //根据组ID查询组名、组长ID、组ID
    public String getTeamById(Integer tid) {
        Team team=teamService.getTeamById(tid);
        return JSON.toJSONString(team, SerializerFeature.PrettyFormat);
    }

    @RequestMapping(value = "/getInformationerByTeamId",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    //根据组ID查询本组信息员ID、姓名
    public String getInformationerByTeamId(Integer tid){
        return JSON.toJSONString(teamService.getInformationerByTeamId(tid),SerializerFeature.PrettyFormat);
    }

    @RequestMapping(value = "/getWarehouseManagerByTeamId",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    //根据组ID查询本组库管员ID、姓名
    public String getWarehouseManagerByTeamId(Integer tid){
        return JSON.toJSONString(teamService.getWarehouseManagerByTeamId(tid),SerializerFeature.PrettyFormat);
    }

    @RequestMapping(value = "/getInstallerByTeamId",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    //根据组ID查询本组安装工ID、姓名
    public String getInstallerByTeamId(Integer tid){
        return JSON.toJSONString(teamService.getInstallerByTeamId(tid),SerializerFeature.PrettyFormat);
    }


}
