package cn.lanhuhebi.elderly_group.service;


import cn.lanhuhebi.elderly_group.model.domain.AreaReport;
import cn.lanhuhebi.elderly_group.model.domain.ReportData;

import java.util.Date;
import java.util.List;

/**
 * @author dxq
 * @date 2019-08-22 - 16:13
 */
public interface ReportService {

    List<AreaReport> selectAreaReportBy(ReportData reportData);

    AreaReport tongji(List<AreaReport> list);

    String getJSONData(List<AreaReport> list);
}
