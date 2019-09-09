package cn.lanhuhebi.elderly_group.app;

import cn.lanhuhebi.elderly_group.service.InstallService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppInstallRestController {

    @Autowired
    private InstallService installService;

    //安装登录后的显示
    @GetMapping(value = "/iii")
    public String doInstallList(Integer areaId,Integer perId){
        System.out.println("请求进来了吗");
        System.out.println("aredId===>"+areaId);
        System.out.println("perId===>"+perId);
        Object[] data = new Object[2];
        data[0] = installService.getAlreadyInstalls(areaId, perId);
        data[1] = installService.getNotInstalls(areaId, perId);
        return JSON.toJSONString(data);
    }

    //用户地址
    @GetMapping(value = "/eee")
    public String toAddress(Integer flyId){
        return JSON.toJSONString(installService.getInstallOne(flyId));
    }

    //设备明细
    @GetMapping(value = "/ppp")
    public String toEmp(Integer purId){
        System.out.println("执行方法pppp"+purId);
        return JSON.toJSONString(installService.getOrderDetailVo(purId));
    }

}
