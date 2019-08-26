package cn.lanhuhebi.elderly_group.controller;

import cn.lanhuhebi.elderly_group.model.dto.AnnPlan;
import cn.lanhuhebi.elderly_group.model.pojo.AnnualPlan;
import cn.lanhuhebi.elderly_group.model.pojo.Area;
import cn.lanhuhebi.elderly_group.model.pojo.MonthlyPlan;
import cn.lanhuhebi.elderly_group.service.PlanService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class PlanController {

    @Resource
    private PlanService planService;

    @RequestMapping("/toAnpList")
    public String toAnpList(Model model ){

        List<AnnPlan> annPlanList=planService.queryAllAnnPlan();
        model.addAttribute("annPlanList",annPlanList);

        List<Area> areaList=planService.queryAllArea();
        model.addAttribute("arealist",areaList);

        return "/plans/Annplans";
    }
    @RequestMapping(value="/checkIsExistsAnnPlan",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String checkIsExistsAnnPlan(@RequestParam("anp_area_id")Integer anp_area_id,@RequestParam("anp_year")String anp_year){
        System.out.println("ddddddddddddddddddddddddddddddd");
        int n =planService.isExistsAnnplan(anp_area_id,anp_year);
        System.out.println(n+"条");
        String str=JSON.toJSONString(n, SerializerFeature.PrettyFormat);
        return str;
    }

    @RequestMapping("/doAddAnnPlan")
    public String toAddAnnpaln(AnnualPlan a, RedirectAttributes ra){
        int n =planService.addAnnPlan(a);
        if(n<1){
            ra.addFlashAttribute("addmsg","新增失败");
        }else{
            ra.addFlashAttribute("addmsg","新增成功");
        }
        return "redirect:/toAnpList";
    }

    @RequestMapping("/delAnnPlan")
    public String delAnnPlan(@RequestParam("nian")String nian,@RequestParam("qu")Integer qu,RedirectAttributes ra){
        int n =planService.delAnnPlan(nian,qu);
        if(n<1){
            ra.addFlashAttribute("addmsg","删除失败");
        }else{
            ra.addFlashAttribute("addmsg","删除成功");
        }
        return "redirect:/toAnpList";
    }

    @RequestMapping(value = "/toUpdateMonPlan",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String toUpdateMonPlan(@RequestParam("anp_year")String anp_year,@RequestParam("mon_area_id")Integer mon_area_id,Model model ){
        List<MonthlyPlan> monthlyPlanList =planService.queryAllMonPlan(anp_year,mon_area_id);
        //model.addAttribute("monthlyPlanList",monthlyPlanList);
        String str=JSON.toJSONString(monthlyPlanList, SerializerFeature.PrettyFormat);
        return str;//修改月度计划的页面
    }

    @RequestMapping(value = "/toUpdateAnnPlan",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String toUpdateAnnPlan(@RequestParam("anp_id")Integer anp_id){
        AnnPlan annualPlan =planService.queryById(anp_id);
        //model.addAttribute("annualPlan",annualPlan);
        String str=JSON.toJSONString(annualPlan, SerializerFeature.PrettyFormat);
        return str;//编辑年度计划的页面
    }

    @RequestMapping("/UpdateMonPlan")//页面传回一个月度计划的编号id的数组
    /*public String UpdateMonPlan(@RequestParam("anp_year")String anp_year,@RequestParam("mon_area_id")Integer mon_area_id,Model model ){
        List<MonthlyPlan> monthlyPlanList =planService.queryAllMonPlan(anp_year,mon_area_id);
        model.addAttribute("monthlyPlanList",monthlyPlanList);
        return "";//修改月度计划的页面
    }*/
    public String UpdateMonPlan(
                                @RequestParam("mon_id1")Integer mon_id1 ,
                                @RequestParam("mon_Sept_num1")Integer mon_Sept_num1 ,@RequestParam("mon_Rept_num1")Integer mon_Rept_num1 ,
                                @RequestParam("mon_id2")Integer mon_id2 ,
                                @RequestParam("mon_Sept_num2")Integer mon_Sept_num2 ,@RequestParam("mon_Rept_num2")Integer mon_Rept_num2 ,
                                @RequestParam("mon_id3")Integer mon_id3 ,
                                @RequestParam("mon_Sept_num3")Integer mon_Sept_num3 ,@RequestParam("mon_Rept_num3")Integer mon_Rept_num3,
                                @RequestParam("mon_id4")Integer mon_id4 ,
                                @RequestParam("mon_Sept_num4")Integer mon_Sept_num4 ,@RequestParam("mon_Rept_num4")Integer mon_Rept_num4 ,
                                @RequestParam("mon_id5")Integer mon_id5 ,
                                @RequestParam("mon_Sept_num5")Integer mon_Sept_num5 ,@RequestParam("mon_Rept_num5")Integer mon_Rept_num5 ,
                                @RequestParam("mon_id6")Integer mon_id6 ,
                                @RequestParam("mon_Sept_num6")Integer mon_Sept_num6 ,@RequestParam("mon_Rept_num3")Integer mon_Rept_num6,
                                @RequestParam("mon_id7")Integer mon_id7 ,
                                @RequestParam("mon_Sept_num7")Integer mon_Sept_num7 ,@RequestParam("mon_Rept_num7")Integer mon_Rept_num7 ,
                                @RequestParam("mon_id8")Integer mon_id8 ,
                                @RequestParam("mon_Sept_num8")Integer mon_Sept_num8 ,@RequestParam("mon_Rept_num8")Integer mon_Rept_num8 ,
                                @RequestParam("mon_id9")Integer mon_id9 ,
                                @RequestParam("mon_Sept_num9")Integer mon_Sept_num9 ,@RequestParam("mon_Rept_num9")Integer mon_Rept_num9,
                                @RequestParam("mon_id10")Integer mon_id10 ,
                                @RequestParam("mon_Sept_num10")Integer mon_Sept_num10 ,@RequestParam("mon_Rept_num10")Integer mon_Rept_num10 ,
                                @RequestParam("mon_id11")Integer mon_id11 ,
                                @RequestParam("mon_Sept_num11")Integer mon_Sept_num11 ,@RequestParam("mon_Rept_num11")Integer mon_Rept_num11 ,
                                @RequestParam("mon_id12")Integer mon_id12 ,
                                @RequestParam("mon_Sept_num12")Integer mon_Sept_num12 ,@RequestParam("mon_Rept_num12")Integer mon_Rept_num12,

                                RedirectAttributes ra ){
        List<MonthlyPlan> list =new ArrayList<>();
        MonthlyPlan mon1=new MonthlyPlan();
        mon1.setMon_id(mon_id1);
        mon1.setMon_Rept_num(mon_Rept_num1);
        mon1.setMon_Sept_num(mon_Sept_num1);
        list.add(mon1);
        MonthlyPlan mon2=new MonthlyPlan();
        mon2.setMon_id(mon_id2);
        mon2.setMon_Rept_num(mon_Rept_num2);
        mon2.setMon_Sept_num(mon_Sept_num2);
        list.add(mon2);
        MonthlyPlan mon3=new MonthlyPlan();
        mon3.setMon_id(mon_id3);
        mon3.setMon_Rept_num(mon_Rept_num3);
        mon3.setMon_Sept_num(mon_Sept_num3);
        list.add(mon3);
        MonthlyPlan mon4=new MonthlyPlan();
        mon4.setMon_id(mon_id4);
        mon4.setMon_Rept_num(mon_Rept_num4);
        mon4.setMon_Sept_num(mon_Sept_num4);
        list.add(mon4);
        MonthlyPlan mon5=new MonthlyPlan();
        mon5.setMon_id(mon_id5);
        mon5.setMon_Rept_num(mon_Rept_num5);
        mon5.setMon_Sept_num(mon_Sept_num5);
        list.add(mon5);
        MonthlyPlan mon6=new MonthlyPlan();
        mon6.setMon_id(mon_id6);
        mon6.setMon_Rept_num(mon_Rept_num6);
        mon6.setMon_Sept_num(mon_Sept_num6);
        list.add(mon6);
        MonthlyPlan mon7=new MonthlyPlan();
        mon7.setMon_id(mon_id7);
        mon7.setMon_Rept_num(mon_Rept_num7);
        mon7.setMon_Sept_num(mon_Sept_num7);
        list.add(mon7);
        MonthlyPlan mon8=new MonthlyPlan();
        mon8.setMon_id(mon_id8);
        mon8.setMon_Rept_num(mon_Rept_num8);
        mon8.setMon_Sept_num(mon_Sept_num8);
        list.add(mon8);
        MonthlyPlan mon9=new MonthlyPlan();
        mon9.setMon_id(mon_id9);
        mon9.setMon_Rept_num(mon_Rept_num9);
        mon9.setMon_Sept_num(mon_Sept_num9);
        list.add(mon9);
        MonthlyPlan mon10=new MonthlyPlan();
        mon10.setMon_id(mon_id10);
        mon10.setMon_Rept_num(mon_Rept_num10);
        mon10.setMon_Sept_num(mon_Sept_num10);
        list.add(mon10);
        MonthlyPlan mon11=new MonthlyPlan();
        mon11.setMon_id(mon_id11);
        mon11.setMon_Rept_num(mon_Rept_num11);
        mon11.setMon_Sept_num(mon_Sept_num11);
        list.add(mon11);
        MonthlyPlan mon12=new MonthlyPlan();
        mon12.setMon_id(mon_id12);
        mon12.setMon_Rept_num(mon_Rept_num12);
        mon12.setMon_Sept_num(mon_Sept_num12);
        list.add(mon12);

        Iterator<MonthlyPlan> it =list.iterator();
        while(it.hasNext()){
            MonthlyPlan m=(MonthlyPlan)it.next();
            int n=planService.updateMonPlan(m);
        }
        ra.addFlashAttribute("addmsg","设置成功");
        return  "redirect:/toAnpList";
    }

    @RequestMapping("/UpdateAnnPlan")
    public String UpdateAnnPlan(@RequestParam("xanp_area_id")Integer xanp_area_id,@RequestParam("xanp_year")String xanp_year,
                                @RequestParam("xanp_Sept_num")Integer xanp_Sept_num,
                                @RequestParam("xanp_Rept_num")Integer xanp_Rept_num,
                                @RequestParam("xanp_id")Integer xanp_id,
                                @RequestParam("oldareaid")Integer oldareaid,
                                @RequestParam("oldyear")String oldyear,
                                RedirectAttributes ra){
        AnnualPlan annualPlan=new AnnualPlan();
        annualPlan.setAnp_area_id(xanp_area_id);
        annualPlan.setAnp_Sept_num(xanp_Sept_num);
        annualPlan.setAnp_Rept_num(xanp_Rept_num);
        annualPlan.setAnp_id(xanp_id);
        annualPlan.setAnp_year(xanp_year);
        //xanp_area_id
        //        xanp_year
       // xanp_Sept_num
          //      xanp_Rept_num
        //xanp_id
        int n =planService.updateAnnPlan(annualPlan,oldyear,oldareaid);
        if(n<1){
            ra.addFlashAttribute("addmsg","修改年度计划失败");
        }else{
            ra.addFlashAttribute("addmsg","修改年度计划成功");
        }
        return "redirect:/toAnpList";
    }
}
