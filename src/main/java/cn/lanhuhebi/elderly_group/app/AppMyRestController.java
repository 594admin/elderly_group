package cn.lanhuhebi.elderly_group.app;

import cn.lanhuhebi.elderly_group.util.TencentAppCOS;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class AppMyRestController {


    private String purl = "https://lxw-1258988357.cos.ap-beijing.myqcloud.com/elderlyImages/";

    @RequestMapping("/upLoadImg")
    public String testUploadFile(@RequestParam("images") MultipartFile images, @RequestParam("info") String info) throws IOException {
        System.out.println("=========>>>> upLoadImg");
        System.out.println("=========>>>> name: " + images.getName());
        System.out.println("=========>>>> filename: " + images.getOriginalFilename());
        System.out.println("=========>>>> contentType: " + images.getContentType());

        System.out.println("info=========>>>" + info);

        StringBuffer sb = new StringBuffer();
        String pic = "";
        File excelFile = null;

        if (images != null && !images.isEmpty()) {
            System.out.println("=========>>>> exist");
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
        return JSON.toJSONString(pic);
    }



}