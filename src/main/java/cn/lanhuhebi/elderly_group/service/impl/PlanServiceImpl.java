package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.dao.PlanDao;
import cn.lanhuhebi.elderly_group.model.dto.AnnPlan;
import cn.lanhuhebi.elderly_group.model.pojo.AnnualPlan;
import cn.lanhuhebi.elderly_group.model.pojo.Area;
import cn.lanhuhebi.elderly_group.model.pojo.MonthlyPlan;
import cn.lanhuhebi.elderly_group.service.PlanService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    @Resource
    private PlanDao planDao;

    @Override
    //查询所有的年度计划
    public List<AnnPlan> queryAllAnnPlan() {
        return planDao.queryAllAnnPlan();
    }


    //新增年度计划的时候，先查看有没有该区的该年的年度计划
    public int isExistsAnnplan(Integer anp_area_id,String anp_year){
        return planDao.isExistsAnnplan(anp_area_id,anp_year);
    }

    /**
     * 添加年度计划，并且添加12个月的默认月度计划（以防对比月度计划时，查不到某个月的数据）
     * @param annualPlan
     * @return
     */
    @Override
    @Transactional
    public int addAnnPlan(AnnualPlan annualPlan) {
        try{
            int n =planDao.addAnnPlan(annualPlan);
            if (n<1) {
                System.out.println("年度计划添加异常");
                throw  new Exception("年度计划添加异常");
            }
            for (int i = 1; i <13 ; i++) {
                MonthlyPlan monthlyPlan=new MonthlyPlan();
                monthlyPlan.setMon_year(annualPlan.getAnp_year());
                monthlyPlan.setMon_area_id(annualPlan.getAnp_area_id());
                monthlyPlan.setMon_count(i);
                int m=planDao.addMonPlan(monthlyPlan);
                if (m<1){
                    System.out.println("月度计划添加异常");
                    throw  new Exception("月度计划添加异常");
                }
            }
            return 1;
        }catch (Exception e){

            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return -1;
    }
    @Override
    //根据年度计划id得到年度计划详情,用于编辑修改
    public AnnPlan queryById(Integer anp_id){
        return planDao.queryById(anp_id);
    }
    @Override
    //修改年度计划
    @Transactional
    public int updateAnnPlan(AnnualPlan annualPlan,String oleyear,Integer oldareaid) {
        try{
            int n =planDao.updateAnnPlan(annualPlan);
            int m=planDao.updateMplans(oleyear,oldareaid,annualPlan.getAnp_year(),annualPlan.getAnp_area_id());
            if(n<1||m<1){
                throw new Exception("修改失败");
            }
            return 1;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 删除年度计划，并且删除月度计划里对应年份的部分
     * @param anp_year,anp_area_id
     * @return
     */
    @Override
    @Transactional
    public int delAnnPlan(String anp_year,Integer anp_area_id) {
        try{
            int n =planDao.delAnnPlan(anp_year,anp_area_id);
            int m=planDao.delMonPlan(anp_year,anp_area_id);
            if (n<1||m<1) {
                throw  new Exception("年度计划删除异常");
            }
            return 1;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return -1;
    }

    @Override
    //点击月度计划需要查询对应年份的所有月计划
    public List<MonthlyPlan> queryAllMonPlan(String ann_year,Integer mon_area_id){
        return planDao.queryAllMonPlan(ann_year, mon_area_id);
    }

    @Override
    //点击月度计划的时候，逻辑上是修改原来的默认值
    public int updateMonPlan(MonthlyPlan monthlyPlan) {
        return planDao.updateMonPlan(monthlyPlan);
    }

    @Override
    //查询所有的区域（本项目中锁定河南省鹤壁市）
   public List<Area> queryAllArea(){
        return planDao.queryAllArea();
    }
}
