package cn.lanhuhebi.elderly_group.service;

import cn.lanhuhebi.elderly_group.dao.PlanDao;
import cn.lanhuhebi.elderly_group.model.dto.AnnPlan;
import cn.lanhuhebi.elderly_group.model.pojo.AnnualPlan;
import cn.lanhuhebi.elderly_group.model.pojo.Area;
import cn.lanhuhebi.elderly_group.model.pojo.MonthlyPlan;

import javax.annotation.Resource;
import java.util.List;

public interface PlanService {

    //查询所有的年度计划
    List<AnnPlan> queryAllAnnPlan();

    //添加年度计划（事务处理），新增年度计划的同时添加12个月份的月度计划，默认里面的是设备数量是0
    int addAnnPlan(AnnualPlan annualPlan);

    //根据年度计划id得到年度计划详情
    AnnPlan queryById(Integer anp_id);

    //修改年度计划
    int updateAnnPlan(AnnualPlan annualPlan,String oleyear,Integer oldareaid);

    //删除年度计划(事务处理),删除年度计划之后，对应年份的月度计划也删除
    int delAnnPlan(String anp_year, Integer anp_area_id);

    //点击月度计划需要查询对应年份的所有月计划
    List<MonthlyPlan> queryAllMonPlan(String anp_year, Integer mon_area_id);
    //点击月度计划的时候，逻辑上是修改原来的默认值
    int updateMonPlan(MonthlyPlan monthlyPlan);

    //查询所有的区域（本项目中锁定河南省鹤壁市）
    List<Area> queryAllArea();
}
