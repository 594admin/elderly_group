package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.dao.TeamReportDao;
import cn.lanhuhebi.elderly_group.model.dto.teamReport.*;
import cn.lanhuhebi.elderly_group.service.TeamReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author FanWeichong
 * @date 2019-09-12 15:18
 */
@Service
public class TeamReportServiceImpl implements TeamReportService{
    @Resource
    private TeamReportDao teamReportDao;

    @Override
    public List<recordVO> getRecordCount(String start, String end) {
        return teamReportDao.getRecordCount(start, end);
    }

    @Override
    public List<payVO> getPayCount(String start, String end) {
        return teamReportDao.getPayCount(start, end);
    }

    @Override
    public List<outVO> getOutCount(String start, String end) {
        return teamReportDao.getOutCount(start, end);
    }

    @Override
    public List<insVO> getInstallCount(String start, String end) {
        return teamReportDao.getInstallCount(start, end);
    }

}
