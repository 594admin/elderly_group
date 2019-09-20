package cn.lanhuhebi.elderly_group.app;

import cn.lanhuhebi.elderly_group.model.dto.PersonnelVo;
import cn.lanhuhebi.elderly_group.service.AllocationService;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author FanWeichong
 * @date 2019-09-16 22:56
 */
@RequestMapping("/allocation")
@RestController
public class AppAllocationRestController {

    @Resource
    private AllocationService allocationService;

    @PostMapping("/init")
    public String AlcInit(@RequestParam(value = "areaId", required = false) Integer areaId,
                          @RequestAttribute("personnelVo") PersonnelVo personnelVo){
        System.out.println("*****************进入allocation/list*******");
        int teamLeaderId=personnelVo.getPreId();
        System.out.println("===组长ID===>"+teamLeaderId);
        System.out.println("===区域编号===>"+areaId);
        Object[] data=new Object[2];
        data[0]=allocationService.getAllocationInfoByTeamLeaderId(teamLeaderId,areaId);
        data[1]=allocationService.getUnAllocationInfoByTeamLeaderId(teamLeaderId,areaId);
        System.out.println("=====安装分配=====>"+JSON.toJSONString(data));
        return JSON.toJSONString(data);
    }

}
