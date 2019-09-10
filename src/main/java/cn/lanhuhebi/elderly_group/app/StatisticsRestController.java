package cn.lanhuhebi.elderly_group.app;


import cn.lanhuhebi.elderly_group.model.dto.app.annPlan.AnnPlanVo;
import cn.lanhuhebi.elderly_group.model.dto.app.annPlan.Series;
import cn.lanhuhebi.elderly_group.model.pojo.AnnualPlan;
import cn.lanhuhebi.elderly_group.model.pojo.MonthlyPlan;
import cn.lanhuhebi.elderly_group.service.PlanService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.*;

@RestController
@RequestMapping("statistics")
public class StatisticsRestController {

    @Autowired
    private PlanService planService;

    @RequestMapping(value="/ecAnnMonPlans")
    public ResponseEntity<AnnPlanVo> ecAnnMonPlans(){
        System.out.println("进入了后台");
        //根据年份做出各月份时间
        String cann_year="2019";
        List<String> yues =new LinkedList<>();
        yues.add(cann_year+"-01-01");yues.add(cann_year+"-02-01");
        yues.add(cann_year+"-03-01");yues.add(cann_year+"-04-01");
        yues.add(cann_year+"-05-01");yues.add(cann_year+"-06-01");
        yues.add(cann_year+"-07-01");yues.add(cann_year+"-08-01");
        yues.add(cann_year+"-09-01");yues.add(cann_year+"-10-01");
        yues.add(cann_year+"-11-01");yues.add(cann_year+"-12-01");
        yues.add((Integer.parseInt(cann_year)+1)+"-01-01");
        //返回一个map集合
        Map<String,List<Double>> map= new HashMap<>();
        //控制double的小数位数
        DecimalFormat df = new DecimalFormat( "0.00");
        //第一步：由年份得到所有的年度的计划
        List<AnnualPlan> alist= planService.queryByAnnYear(cann_year);

        for (int i = alist.size()-1; i >=0; i--) {
            int c=0;
            List<MonthlyPlan> mlist=planService.queryAllMonPlan(alist.get(i).getAnp_year(),alist.get(i).getAnp_area_id());
            for (int j = 0; j <mlist.size() ; j++) {
                if (mlist.get(j).getMon_Rept_num()==0 && mlist.get(j).getMon_Sept_num()==0){
                    c++;
                }
            }
            if(c==12){
                alist.remove(i);
            }
        }
        System.out.println("年度计划有："+alist.size()+"个");
        for (int i = 0; i <alist.size() ; i++) {
            List<MonthlyPlan> mlist=planService.queryAllMonPlan(alist.get(i).getAnp_year(),alist.get(i).getAnp_area_id());

            //map集合的value的集合 比率Double类型
            List<Double> rateList=new LinkedList<>();
            for (int z = 0; z <12 ; z++) {
                Integer monInstall=planService.queryMonInstall(yues.get(z),yues.get(z+1),alist.get(i).getAnp_area_id());
                if (mlist.get(z).getMon_Rept_num()+mlist.get(z).getMon_Sept_num()==0){
                    rateList.add(((double)monInstall)/1);
                }else{
                    rateList.add(Double.parseDouble(df.format(((double)monInstall)/(mlist.get(z).getMon_Rept_num()+mlist.get(z).getMon_Sept_num()))));
                }
            }

            map.put(planService.queryAreaNameByareaId(alist.get(i).getAnp_area_id()),rateList);
        }

        //把所有信息装配进入一个echars主体类；
        AnnPlanVo annPlanVo =new AnnPlanVo();
        yues.remove(12);
        Iterator<String> strIt=yues.iterator();
        for (int i = 0; i < yues.size(); i++) {
            String yue=yues.get(i);
            yue=yue.substring(0,7);
            yues.set(i,yue);
        }
        annPlanVo.setCategories(yues);
        Iterator<String> it =map.keySet().iterator();
        List<Series> series =new LinkedList<Series>();
        while(it.hasNext()){
            String str=it.next();
            Series series1=new Series();
            series1.setData(map.get(str));
            series1.setName(str);
            series.add(series1);
        }
        annPlanVo.setSeries(series);

        System.out.println(JSON.toJSONString(annPlanVo, SerializerFeature.PrettyFormat));

        return ResponseEntity.ok(annPlanVo);

    }
}
