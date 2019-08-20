package cn.lanhuhebi.elderly_group.controller;

import cn.lanhuhebi.elderly_group.constant.AreaConstant;
import cn.lanhuhebi.elderly_group.model.domain.ReportData;
import cn.lanhuhebi.elderly_group.model.pojo.Area;
import cn.lanhuhebi.elderly_group.service.AreaService;
import com.alibaba.fastjson.JSON;
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

    @GetMapping("/toAreaReport")
    public String toAreaReport(HttpServletRequest request){
        List<Area> areas = areaService.queryAllSheng();
        areas.forEach(System.out::println);
        request.setAttribute("areas",areas);
        return "report/areaReport";
    }

    @PostMapping("/getArea")
    @ResponseBody
    public String getArea(@RequestParam("areaId")Integer areaId){
        List<Area> areas = areaService.queryAllXiaJiByShang(areaId);
        areas.toString();
        return  JSON.toJSONString(areas);
    }

    @PostMapping("/report")
    public String report(ReportData reportData){
        System.out.println("--------------------------");

        Integer areaId = -1;

        if (AreaConstant.ZONE.equals(reportData.getAreatype())){
            areaId = reportData.getShi();
        } else if (AreaConstant.COUNTY.equals(reportData.getAreatype())){
            areaId = reportData.getQv();
        } else if (AreaConstant.VILLAGE.equals(reportData.getAreatype())){
            areaId = reportData.getJie();
        }




        return null;
    }
}
