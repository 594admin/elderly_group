package cn.lanhuhebi.elderly_group.controller;

import cn.lanhuhebi.elderly_group.model.dto.teamReport.*;
import cn.lanhuhebi.elderly_group.service.TeamReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author FanWeichong
 * @date 2019-09-02 8:33
 */
@Controller
public class TeamReportController {

    @Resource
    private TeamReportService teamReportService;

    @RequestMapping("/toTeamReport")
    public String toTeamReport(Model model){
        List<teamReportVO> t=teamReportService.getTeamReport(null,null);
        model.addAttribute("t",t);
        model.addAttribute("start","");
        model.addAttribute("end","");
        model.addAttribute("jd",teamReportService.getTeamReportJSON(t));
        return "report/teamReport";
    }

    @RequestMapping(value = "/getTeamReport")
    public String getTeamReport(String start,String end,Model model){
        if (start==null||start.equals("")||end==null||end.equals("")){
            model.addAttribute("start",null);
            model.addAttribute("end",null);
            List<teamReportVO> t=teamReportService.getTeamReport(null,null);
            model.addAttribute("t",t);
            model.addAttribute("jd",teamReportService.getTeamReportJSON(t));
        }else{
            List<teamReportVO> t=teamReportService.getTeamReport(start,end);
            model.addAttribute("t",t);
            String start1=start.substring(0,10);
            String end1=end.substring(0,10);
            model.addAttribute("start",start1);
            model.addAttribute("end",end1);
            model.addAttribute("jd",teamReportService.getTeamReportJSON(t));
        }
        return "report/teamReport";
    }



}
