package cn.lanhuhebi.elderly_group.app;

import cn.lanhuhebi.elderly_group.model.dto.PersonnelVo;
import cn.lanhuhebi.elderly_group.service.InstallService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/install")
public class AppInstallRestController {

    @Autowired
    private InstallService installService;

    //安装登录后的显示
    @PostMapping(value = "/iii")
    public String doInstallList(@RequestParam(value = "areaId", required = false) Integer areaId,
                                @RequestAttribute("personnelVo") PersonnelVo personnelVo) {
        System.out.println("请求进来了吗");
        System.out.println("aredId===>" + areaId);
        System.out.println("perId===>" + personnelVo.getPreId());
        Object[] data = new Object[2];
        data[0] = installService.getAlreadyInstalls(areaId, personnelVo.getPreId());
        data[1] = installService.getNotInstalls(areaId, personnelVo.getPreId());
        return JSON.toJSONString(data);
    }

    //用户地址
    @PostMapping(value = "/eee")
    public String toAddress(Integer flyId) {
        return JSON.toJSONString(installService.getInstallOne(flyId));
    }

    //设备明细
    @PostMapping(value = "/ppp")
    public String toEmp(Integer purId) {
        System.out.println("执行方法pppp" + purId);
        return JSON.toJSONString(installService.getOrderDetailVo(purId));
    }

}
