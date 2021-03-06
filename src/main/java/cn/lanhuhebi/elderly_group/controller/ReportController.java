package cn.lanhuhebi.elderly_group.controller;

import cn.lanhuhebi.elderly_group.annotation.DataLog;
import cn.lanhuhebi.elderly_group.enums.BusinessType;
import cn.lanhuhebi.elderly_group.job.ScheduleManager;
import cn.lanhuhebi.elderly_group.model.domain.AreaReport;
import cn.lanhuhebi.elderly_group.model.domain.ReportData;
import cn.lanhuhebi.elderly_group.model.pojo.Area;
import cn.lanhuhebi.elderly_group.service.AreaService;
import cn.lanhuhebi.elderly_group.service.ReportService;
import com.alibaba.fastjson.JSON;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author dxq
 * @date 2019-08-18 - 17:05
 */
@Controller
public class ReportController {

    @Resource
    private AreaService areaService;

    @Resource
    private ReportService reportService;


    @GetMapping("/toAreaReport")
    public String toAreaReport(HttpServletRequest request){
        List<Area> areas = areaService.queryAllSheng();
        request.setAttribute("areas",areas);
        return "report/areaReport";
    }

    @RequestMapping("/toChangjia")
    public String toChangjia(){


        return "report/cjReport";
    }

    @DataLog(businessType = BusinessType.GRANT,desc = "区域查询")
    @PostMapping("/getArea")
    @ResponseBody
    public String getArea(@RequestParam("areaId")Integer areaId){
        List<Area> areas = areaService.queryAllXiaJiByShang(areaId);
        areas.toString();
        return  JSON.toJSONString(areas);
    }

    @DataLog(businessType = BusinessType.GRANT,desc = "区域统计")
    @PostMapping("/report")
    public String report(ReportData reportData,HttpServletRequest request){
        request.setAttribute("reportData",reportData);
        List<AreaReport> areaReports = reportService.selectAreaReportBy(reportData);
        request.setAttribute("areaReports",areaReports);

        request.setAttribute("jsondata",reportService.getJSONData(areaReports));

        AreaReport tongji = reportService.tongji(areaReports);
        request.setAttribute("tongji",tongji);
        List<Area> areas = areaService.queryAllSheng();
        request.setAttribute("areas",areas);
        return "report/areaReport";
    }

}
