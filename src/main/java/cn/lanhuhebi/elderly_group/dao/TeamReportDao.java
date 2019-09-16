package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.dto.teamReport.*;

import java.util.List;

/**
 * @author FanWeichong
 * @date 2019-09-12 14:50
 */
public interface TeamReportDao {
    //登记量
    List<recordVO> getRecordCount(String start,String end);
    //缴费量
    List<payVO> getPayCount(String start, String end);
    //出库量
    List<outVO> getOutCount(String start, String end);
    //安装量
    List<insVO> getInstallCount(String start, String end);
}
