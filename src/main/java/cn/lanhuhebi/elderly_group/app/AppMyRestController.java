package cn.lanhuhebi.elderly_group.app;

/**
 * @ClassName AppMyRestController
 * @Author Oblivion
 * @Date 2019/9/9
 * @Version 1.0
 **/
import cn.lanhuhebi.elderly_group.model.dto.PersonnelVo;
import cn.lanhuhebi.elderly_group.model.pojo.Feedback;
import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import cn.lanhuhebi.elderly_group.service.PersonnelService;
import cn.lanhuhebi.elderly_group.util.RedisUtils;
import cn.lanhuhebi.elderly_group.util.TencentAppCOS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RequestMapping("/my")
@RestController()
public class AppMyRestController {

    @Autowired
    private PersonnelService personnelService;

    @Autowired
    private RedisUtils redisUtils;

    private String purl = "https://lxw-1258988357.cos.ap-beijing.myqcloud.com/elderlyImages/";

    @RequestMapping("/upLoadImg")
    public synchronized String testUploadFile(@RequestParam("images") MultipartFile images,
                                 @RequestParam("length") int length,
                                 @RequestParam("content") String content,
                                 @RequestParam("phone") String phone,
                                 @RequestAttribute("personnelVo") PersonnelVo personnelVo) throws IOException {

        System.out.println("==============*********=================");

        System.out.println("i exist: " + redisUtils.get("i"));
        System.out.println("pic exist: " + redisUtils.get("pic"));

        String i = redisUtils.get("i") == null ? "1" : redisUtils.get("i") + "1";
        String pic = redisUtils.get("pic") == null ? "" : (String) redisUtils.get("pic");

        StringBuffer sb = new StringBuffer(pic);
        File excelFile = null;
        if (images != null && !images.isEmpty()) {
            System.out.println("===== 上传 =====");
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
            sb.append(purl).append(fileName).append(",");
        }
        pic = sb.toString();
        redisUtils.set("i", i);
        redisUtils.set("pic", pic);

        System.out.println("length: " + length);
        System.out.println("i: " + i);
        System.out.println("pic: " + pic);

        if (i.length() == length) {
            redisUtils.delete("i");
            redisUtils.delete("pic");
            System.out.println("redis pic i 还原");
            pic = pic.substring(0, pic.length() - 1);
            Feedback feedback = new Feedback();
            feedback.setFbk_person(personnelVo.getPreId());
            feedback.setFbk_name(personnelVo.getPreName());
            feedback.setFbk_phone(phone);
            feedback.setFbk_data(content);
            feedback.setFbk_pic(pic);
            System.out.println(feedback);

            System.out.println("==================持久化===================");
        }
        return "success";
    }

    @RequestMapping("/myinfo")
    public ResponseEntity<Personnel> getMyInfo(@RequestAttribute("personnelVo") PersonnelVo personnelVo) {
        Personnel personnel = new Personnel();
        personnel.setPreName(personnelVo.getPreName());
        personnel.setPrePhone(personnelVo.getPrePhone());
        return ResponseEntity.ok(personnel);
    }

}