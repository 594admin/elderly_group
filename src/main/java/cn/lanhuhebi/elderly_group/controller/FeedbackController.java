package cn.lanhuhebi.elderly_group.controller;

import cn.lanhuhebi.elderly_group.model.pojo.Feedback;
import cn.lanhuhebi.elderly_group.service.FeedbackService;
import cn.lanhuhebi.elderly_group.util.TencentCOS;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.Map;

@Controller
public class FeedbackController {

    @Resource
    private FeedbackService feedbackService;
    private String purl = "https://sxd-1258987597.cos.ap-chengdu.myqcloud.com/";

    //    分页查看所有意见反馈
    @RequestMapping(value = "doListFeedback")
//    public String doListFeedback(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Integer fbk_person, Model model) {
    public String doListFeedback(Integer fbk_person, Model model) {
//        if (fbk_person != null) {
//            model.addAttribute("pageInfo", feedbackService.queryAllFeedbackByPage(pageNo, pageSize,fbk_person));
//        }
        model.addAttribute("pageInfo", feedbackService.queryAllFeedback(fbk_person));
        return "feedback/listFeedback";
    }

    //    去添加意见反馈页面
    @RequestMapping(value = "toAddFeedback")
    public String toAddFeedback() {
        return "feedback/addFeedback";
    }

    //执行添加操作
    @RequestMapping("doAddFeedback")
    public String doAddStaff(Feedback feedback, @RequestParam("url") List<MultipartFile> url, Map<String, Object> map) throws Exception {
        System.out.println("========");
        StringBuffer sb = new StringBuffer();
        String pic = "";
        File excelFile = null;
        for (int i = 0; i < url.size(); i++) {
            if (url.get(i) != null && !url.get(i).isEmpty()) {
                // 获取文件名
                String fileName = url.get(i).getOriginalFilename();
                // 获取文件后缀
                String prefix = fileName.substring(fileName.lastIndexOf("."));
                // 用uuid作为文件名，防止生成的临时文件重复
                excelFile = File.createTempFile(String.valueOf(System.currentTimeMillis()), prefix);
                // 将MultipartFile转为File
                url.get(i).transferTo(excelFile);
                //调用腾讯云工具上传文件
                fileName = TencentCOS.uploadfile(excelFile);
                sb.append(purl).append(fileName).append(",");
            }
        }
        pic = sb.substring(0, sb.length() - 1);
        feedback.setFbk_pic(pic);
//        以下数据仅是测试使用
        feedback.setFbk_person(16);
        feedbackService.addFeedback(feedback);
        //程序结束时，删除临时文件
        deleteFile(excelFile);
        //存入图片名称，用于网页显示
        map.put("imageName", pic);
        //返回图片名称
        return "redirect:doListFeedback";
    }

    //修改
    @RequestMapping("doUpdateStaff")
    public String doUpdateStaff(@ModelAttribute Feedback feedback, @RequestParam(value = "file") MultipartFile multfile, Map<String, Object> map) throws Exception {

        // 获取文件名
        String fileName = multfile.getOriginalFilename();
        if (fileName != null && !fileName.equals("")) {
            // 获取文件后缀
            String prefix = fileName.substring(fileName.lastIndexOf("."));
            // 用uuid作为文件名，防止生成的临时文件重复
            final File excelFile = File.createTempFile("imagesFile-" + System.currentTimeMillis(), prefix);
            // 将MultipartFile转为File
            multfile.transferTo(excelFile);

            //调用腾讯云工具上传文件
            fileName = TencentCOS.uploadfile(excelFile);
            feedback.setFbk_pic(fileName);

            //程序结束时，删除临时文件
            deleteFile(excelFile);
            //存入图片名称，用于网页显示
            map.put("imageName", fileName);
        }
        feedbackService.updateFeedback(feedback);
        //返回图片名称

        return "redirect:doListFeedback";
    }

    /**
     * 删除临时文件
     *
     * @param files
     */
    private void deleteFile(File... files) {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }


    //    去修改页面
    @RequestMapping(value = "toUpdateFeedback")
    public String toUpdateFeedback(Integer fbk_id, Model model) {
        model.addAttribute("info", feedbackService.detailFeedback(fbk_id));
        return "feedback/updateFeedback";
    }

    //    执行修改操作
    @RequestMapping(value = "doUpdateFeedback")
    public String doUpdateFeedback(Feedback feedback, RedirectAttributes attributes) {
        if (feedbackService.updateFeedback(feedback) > 0) {
            attributes.addFlashAttribute("msg", "修改反馈信息成功！");
        } else {
            attributes.addFlashAttribute("msg", "修改反馈信息失败！");
        }
        return "redirect:doListFeedback";
    }

    //    删除反馈信息
    @RequestMapping(value = "doDeleteFeedback")
    public String doDeleteFeedback(Integer fbk_id, RedirectAttributes attributes) {
        if (feedbackService.deleteFeedback(fbk_id) > 0) {
            attributes.addFlashAttribute("msg", "删除反馈信息成功！");
        } else {
            attributes.addFlashAttribute("msg", "删除反馈信息失败！");
        }
        return "redirect:doListFeedback";
    }

}
