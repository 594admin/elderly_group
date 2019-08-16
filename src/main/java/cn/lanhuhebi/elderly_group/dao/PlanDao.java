package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.dto.AnnPlan;
import cn.lanhuhebi.elderly_group.model.pojo.AnnualPlan;
import cn.lanhuhebi.elderly_group.model.pojo.Area;
import cn.lanhuhebi.elderly_group.model.pojo.MonthlyPlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlanDao {

    //查询所有的年度计划
    List<AnnPlan>  queryAllAnnPlan();

    //新增年度计划
    int addAnnPlan(AnnualPlan annualPlan);
    //新增年度计划的同时添加12个月份的月度计划，默认里面的是设备数量是0
    int addMonPlan(MonthlyPlan monthlyPlan);

    //根据年度计划id得到年度计划详情
    AnnPlan queryById(@Param("anpId") Integer anpId);

    //修改年度计划
    int updateAnnPlan(AnnualPlan annualPlan);

    //删除年度计划
    int delAnnPlan(@Param("anpYear") String annYear, @Param("anpAreaId") Integer anpAreId);
    //删除年度计划之后，对应年份的月度计划也删除
    int delMonPlan(@Param("monYear") String monYear, @Param("monAreaId") Integer monAreId);


    //点击月度计划需要查询对应年份的所有月计划
    List<MonthlyPlan> queryAllMonPlan(@Param("anpYear") String anpYear, @Param("monAreaId") Integer monAreaId);
    //点击月度计划的时候，逻辑上是修改原来的默认值
    int updateMonPlan(MonthlyPlan monthlyPlan);


    //查询所有的区域（本项目中锁定河南省鹤壁市）
    List<Area> queryAllArea();






}
