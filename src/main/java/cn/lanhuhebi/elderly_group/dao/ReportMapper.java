package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.domain.ReportVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author dxq
 * @date 2019-08-18 - 16:31
 */
public interface ReportMapper {

    /**
     * 1、统计条件，取开始日期的0点开始，结束日期的24点
     *
     * 2、统计区域下拉列表调取省、市、区县、乡镇/街道四级行政区域
     *
     * 3、范围为 区县、乡镇/街道、村
     *
     * （1）按区县统计时，市 下拉框为必选项；
     *
     * （2）选择乡镇/街道时， 区 下拉框为必选项；
     *
     * （3）选择 村 时， 乡镇/街道 下拉框为必选项；
     */

    /**
     * 安装户数
     * @param id
     * @param start
     * @param end
     * @return
     */
    Integer aCount(@Param("area_id")Integer id, @Param("start")Date start,@Param("end")Date end);

    /**
     * 查询区级以下乡镇/街道统计
     * @param start
     * @param end
     * @param id
     * @return
     */
    List<ReportVo> selectFamilyByDate1(@Param("start")Date start, @Param("end")Date end,
                                      @Param("areaid")Integer id);

    List<ReportVo> selectFamilyByDate2(@Param("start")Date start, @Param("end")Date end,
                                      @Param("areaid")Integer id);

    List<ReportVo> selectFamilyByDate3(@Param("start")Date start, @Param("end")Date end,
                                      @Param("areaid")Integer id);



}
