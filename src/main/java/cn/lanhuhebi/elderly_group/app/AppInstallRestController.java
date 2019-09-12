package cn.lanhuhebi.elderly_group.app;

import cn.lanhuhebi.elderly_group.model.dto.PersonnelVo;
import cn.lanhuhebi.elderly_group.service.InstallService;
import cn.lanhuhebi.elderly_group.service.OrderDetaliService;
import cn.lanhuhebi.elderly_group.util.TencentAppCOS;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/install")
public class AppInstallRestController {

    @Autowired
    private InstallService installService;

    @Autowired
    private OrderDetaliService orderDetaliService;

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
        //已安装
        data[1] = installService.getAlreadyInstalls(areaId, perId);
        //未安装
        data[0] = installService.getNotInstalls(areaId, perId);
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


    private String purl = "https://lxw-1258988357.cos.ap-beijing.myqcloud.com/elderlyImages/";

    @RequestMapping("/upLoadImgInstall")
    public synchronized String testUploadFile(@RequestParam("images") MultipartFile images,Integer odId,String odEmpNo,Integer purId) throws IOException {
        System.out.println("开始上传文件");
       // System.out.println("====== ===>>>> upLoadImg");
        System.out.println("=========>>>> name: " + images.getName());
      //  System.out.println("=========>>>> filename: " + images.getOriginalFilename());
       // System.out.println("=========>>>> contentType: " + images.getContentType());
        System.out.println("=========>>>> 订单明细: " + odId);
        System.out.println("=========>>>> 设备编号: " + odEmpNo);
        System.out.println("-----------华丽的分割线-------------------");
        StringBuffer sb = new StringBuffer();
        String pic = "";
        File excelFile = null;

        if (images != null && !images.isEmpty()) {
            System.out.println("==== =====>>>> exist");
            // 获取文件名
            String fileName = images.getOriginalFilename();
            // 获取文件后缀
            String prefix = fileName.substring(fileName.lastIndexOf("."));
            // 用uuid作为文件名，防止生成的临时文件重复
            excelFile = File.createTempFile(String.valueOf(System.currentTimeMillis()), prefix);
            // 将MultipartFile转为File
            images.transferTo(excelFile);
            //调用腾讯云工具上传文件
            fileName = TencentAppCOS.uploadImages(excelFile);
            sb.append(purl).append(fileName);
        }
        pic = sb.toString();
        if(orderDetaliService.updateOrderDetail(odId,odEmpNo,pic)){
            System.out.println("我的Id是啥"+purId);
            installService.installEmp(purId);
            return "success";
        }
        return "error";
    }

}
