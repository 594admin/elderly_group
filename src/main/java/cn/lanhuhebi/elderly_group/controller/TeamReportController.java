package cn.lanhuhebi.elderly_group.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author FanWeichong
 * @date 2019-09-02 8:33
 */
@Controller
public class TeamReportController {


    @RequestMapping("/toTeamReport")
    public String toTeamReport(){
        return "report/teamReport";
    }



}
