package cn.lanhuhebi.elderly_group.controller;

import cn.lanhuhebi.elderly_group.model.dto.teamReport.installVO;
import cn.lanhuhebi.elderly_group.model.dto.teamReport.outVO;
import cn.lanhuhebi.elderly_group.model.dto.teamReport.payVO;
import cn.lanhuhebi.elderly_group.model.dto.teamReport.recordVO;
import cn.lanhuhebi.elderly_group.service.TeamReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        List<recordVO> rvList=teamReportService.getRecordCount(null,null);
        List<outVO> ovList=teamReportService.getOutCount(null,null);
        List<payVO> pvList=teamReportService.getPayCount(null,null);
        List<installVO> ivList=teamReportService.getInstallCount(null,null);
        model.addAttribute("rv",rvList);
        model.addAttribute("ov",ovList);
        model.addAttribute("pv",pvList);
        model.addAttribute("iv",ivList);

        return "report/teamReport";
    }



}
