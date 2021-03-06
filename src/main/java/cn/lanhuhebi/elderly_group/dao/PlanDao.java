package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.dto.AnnPlan;
import cn.lanhuhebi.elderly_group.model.pojo.AnnualPlan;
import cn.lanhuhebi.elderly_group.model.pojo.Area;
import cn.lanhuhebi.elderly_group.model.pojo.MonthlyPlan;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

public interface PlanDao {

    //查询所有的年度计划
    List<AnnPlan>  queryAllAnnPlan();

    //新增年度计划的时候，先查看有没有该区的该年的年度计划
    int isExistsAnnplan(@Param("anp_area_id")Integer anp_area_id,@Param("anp_year")String anp_year);

    //新增年度计划
    int addAnnPlan(AnnualPlan annualPlan);
    //新增年度计划的同时添加12个月份的月度计划，默认里面的是设备数量是0
    int addMonPlan(MonthlyPlan monthlyPlan);

    //根据年度计划id得到年度计划详情
    AnnPlan queryById(@Param("anp_id") Integer anpId);

    //修改年度计划
    int updateAnnPlan(AnnualPlan annualPlan);
    //修改年度计划的同时，同样的条件修改月度计划
    int updateMplans(@Param("oldyear")String oleyear,@Param("oldareaid")Integer oldareaid,
            @Param("year")String year,@Param("area_id")Integer area_id);

    //删除年度计划
    int delAnnPlan(@Param("anp_year") String annYear, @Param("anp_area_id") Integer anpAreId);
    //删除年度计划之后，对应年份的月度计划也删除
    int delMonPlan(@Param("mon_year") String monYear, @Param("mon_area_id") Integer monAreId);


    //点击月度计划需要查询对应年份的所有月计划
    List<MonthlyPlan> queryAllMonPlan(@Param("anp_year") String anpYear, @Param("mon_area_id") Integer monAreaId);
    //点击月度计划的时候，逻辑上是修改原来的默认值
    int updateMonPlan(MonthlyPlan monthlyPlan);


    //查询所有的区域（本项目中锁定河南省鹤壁市）
    List<Area> queryAllArea();

    /**
     * 自此开始查询统计模块
     * @param cann_year
     * @return  AnnualPlan的集合
     */
    //查询某一年各区的年度计划
    List<AnnualPlan> queryByAnnYear(@Param("cann_year")String cann_year);
    //由地区编号的得到地区名称
    String queryAreaNameByareaId(@Param("anp_area_id")Integer anp_area_id);
    //查询每个区的月度安装数量
    Integer queryMonInstall(@Param("beginTime")String beginTime,@Param("endTime")String endTime,@Param("area_id")Integer area_id);



}
