package cn.lanhuhebi.elderly_group.service;

import cn.lanhuhebi.elderly_group.model.dto.teamReport.*;

import java.util.List;

/**
 * @author FanWeichong
 * @date 2019-09-12 15:08
 */
public interface TeamReportService {

    List<teamReportVO> getTeamReport(String start,String end);

    String getTeamReportJSON(List<teamReportVO> list);

}
