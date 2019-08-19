package cn.lanhuhebi.elderly_group.controller;

import cn.lanhuhebi.elderly_group.model.dto.Family_team_area;
import cn.lanhuhebi.elderly_group.model.pojo.Area;
import cn.lanhuhebi.elderly_group.model.pojo.Equipment;
import cn.lanhuhebi.elderly_group.model.pojo.Family;
import cn.lanhuhebi.elderly_group.service.AreaService;
import cn.lanhuhebi.elderly_group.service.FamilyService;
import cn.lanhuhebi.elderly_group.service.TeamService;
import cn.lanhuhebi.elderly_group.util.AjaxUtils;
import cn.lanhuhebi.elderly_group.util.TencentFanmilyCOS;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class FamilyController {
    @Resource
    private FamilyService familyService;
    @Resource
    private AreaService areaService;
    @Resource
    private TeamService teamService;



    //初始化list页面
    @RequestMapping("/initfamilylist")
    public String initfamilylist(Model model){
        List<Family_team_area> family_teams = familyService.queryAllFamily();
        model.addAttribute("flist",family_teams);
        return "family/familylist";
    }
    //到查询所有户信息页面
    @RequestMapping("/tofamilylist")
    public String tofamilylist(Model model){
        return "redirect:/initfamilylist";
    }
    //去添加户信息第一步，添加户基础信息
    @RequestMapping("/toaddfamily")
    public String toaddfamily(Model model){
        model.addAttribute("teams",this.teamService.queryAllTeam());
        model.addAttribute("areas",areaService.queryAllXiaJiByShang(386910));
        return "family/familyadd";
    }
    //继续录入信息或者编辑已经完成录入信息
    @RequestMapping("/tosecond")
    public String tosecond(@RequestParam("fly_status")Integer fly_status,Model model,@RequestParam("fly_id")Integer fly_id){
        model.addAttribute("fly_id",fly_id);
        if(fly_status==2){
            return "family/familyadd_equiment";
        }else if(fly_status==3){
            return "family/familyadd_img";
        }else{
            return "";
        }
    }
    //添加户基础信息
    @RequestMapping(value = "/doaddfamilyfirst",method = RequestMethod.POST)
    public String doaddfamilyfirst(Family family, Model model,RedirectAttributes redirectAttributes){
        System.out.println(family.getFly_ispoor());
        if(familyService.addFamFirst(family)>0){
            model.addAttribute("addmsg","添加户基础信息成功");
            return "family/familyadd_equiment";
        }else{
            redirectAttributes.addFlashAttribute("addmsg","添加户基础信息失败");
            return "redirect:/toaddfamily";
        }
    }
    //添加资料
    //执行添加操作
    @RequestMapping("/dofamilyadd_img")
    public String doAddStaff( @RequestParam("fly_data1") MultipartFile fly_data1,
                              @RequestParam("fly_data2") MultipartFile fly_data2,
                              @RequestParam("fly_data3") MultipartFile fly_data3,
                              @RequestParam("fly_data4") MultipartFile fly_data4,
                              @RequestParam("fly_data5") MultipartFile fly_data5,
                              @RequestParam("fly_data6") MultipartFile fly_data6,
                              @RequestParam("fly_id")Integer fly_id,
                              Map<String, Object> map) throws Exception {
        List<MultipartFile> fly_datas=new ArrayList<>();
        List<String> returnfileName=new ArrayList<>();
        fly_datas.add(fly_data1);
        fly_datas.add(fly_data2);
        fly_datas.add(fly_data3);
        fly_datas.add(fly_data4);
        fly_datas.add(fly_data5);
        fly_datas.add(fly_data6);
        for(int i=0;i<fly_datas.size();i++){
            // 获取文件名
            String fileName = fly_datas.get(i).getOriginalFilename();
            if(fileName!=null&&!fileName.equals("")){
                // 获取文件后缀
                String prefix = fileName.substring(fileName.lastIndexOf("."));
                // 用uuid作为文件名，防止生成的临时文件重复
                final File excelFile = File.createTempFile("imagesFile-" + System.currentTimeMillis(), prefix);
                // 将MultipartFile转为File
                fly_datas.get(i).transferTo(excelFile);
                //调用腾讯云工具上传文件
                fileName = TencentFanmilyCOS.uploadfile(excelFile);
                fileName="https://five-1258991825.cos.ap-beijing.myqcloud.com/"+fileName;
                returnfileName.add(fileName);
                //程序结束时，删除临时文件
                deleteFile(excelFile);
                //存入图片名称，用于网页显示
                map.put("imageName", fileName); }
        }
        Family family=new Family();
        family.setFly_id(fly_id);
        family.setFly_data1(returnfileName.get(0));
        family.setFly_data2(returnfileName.get(1));
        family.setFly_data3(returnfileName.get(2));
        family.setFly_data4(returnfileName.get(3));
        family.setFly_data5(returnfileName.get(4));
        family.setFly_data6(returnfileName.get(5));
        this.familyService.updateFamilyData(family);
        return "redirect/initfamilylist";
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


    @RequestMapping("/tofamilyadd_img")
    public String dofamilyadd_img(){

        return "family/familyadd_img";
    }

    //删除一条户信息
    @RequestMapping("/deletefamily")
    public String deletefamily(@RequestParam("fly_id")Integer fly_id, RedirectAttributes model){
        if(familyService.updateFamilyStatus(fly_id)){
            model.addFlashAttribute("deletemsg","删除成功");
        }else{
            model.addFlashAttribute("deletemsg","删除失败");
        }
        return "redirect:/tofamilylist";
    }
    //ajax动态返回区域
    @RequestMapping(value = "/ajax",method = RequestMethod.POST)
    public void ajax( @RequestParam(value = "ept_type",required = false)String ept_type,
                      @RequestParam(value = "ept_facty",required = false)String ept_facty,
                      @RequestParam(value = "ept_model",required = false)String ept_model,
                      @RequestParam(value = "area_id",required = false)Integer area_id,
                      @RequestParam(value = "fly_name",required = false)String fly_name,
                      HttpServletResponse response){
        if(area_id!=null){
           List<Area> areas = areaService.queryAllXiaJiByShang(area_id);
           AjaxUtils.jsonforward(areas,response);
       }
       if(fly_name!=null){
           Family family = this.familyService.queryOneByName(fly_name);
           boolean flag;
           if(family!=null){
               flag=true;
           }else{
               flag=false;
           }
           AjaxUtils.jsonforward(flag,response);
       }
       if(ept_type!=null && ept_facty!=null && ept_model!=null){
           Equipment equipment=new Equipment();
           equipment.setEptType(ept_type);
           equipment.setEptFacty(ept_facty);
           equipment.setEptModel(ept_model);
           System.out.println(this.familyService.getEptPrice(equipment)+"************************");
           AjaxUtils.jsonforward(this.familyService.getEptPrice(equipment),response);
       }

    }


}
