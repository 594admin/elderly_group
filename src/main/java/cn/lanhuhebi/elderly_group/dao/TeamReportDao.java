package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.dto.teamReport.*;

import java.util.Date;
import java.util.List;

/**
 * @author FanWeichong
 * @date 2019-09-12 14:50
 */
public interface TeamReportDao {
    //登记量
    List<recordVO> getRecordCount(Date start,Date end);
    //缴费量
    List<payVO> getPayCount(Date start, Date end);
    //出库量
    List<outVO> getOutCount(Date start, Date end);
    //安装量
    List<installVO> getInstallCount(Date start, Date end);
}
