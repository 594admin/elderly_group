package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.dao.TeamReportDao;
import cn.lanhuhebi.elderly_group.model.domain.AreaReport;
import cn.lanhuhebi.elderly_group.model.domain.ValueName;
import cn.lanhuhebi.elderly_group.model.dto.teamReport.*;
import cn.lanhuhebi.elderly_group.service.TeamReportService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public List<teamReportVO> getTeamReport(String start, String end) {
        List<recordVO> rList=teamReportDao.getRecordCount(start,end);
        List<payVO> pList=teamReportDao.getPayCount(start, end);
        List<outVO> oList=teamReportDao.getOutCount(start, end);
        List<insVO> iList=teamReportDao.getInstallCount(start, end);

        List<teamReportVO> tList=new ArrayList<>();
        for (recordVO r:rList){
            teamReportVO t=new teamReportVO();
            t.setTeamId(r.getTeamId());
            t.setTeamName(r.getTeamName());
            t.setLeaderName(r.getLeaderName());
            t.setRecordCount(r.getRecordCount());
            tList.add(t);
        }
        for (int i = 0; i < pList.size(); i++) {
            tList.get(i).setOutCount(oList.get(i).getOutCount());
            tList.get(i).setPayCount(pList.get(i).getPayCount());
            tList.get(i).setInstallCount(iList.get(i).getInstallCount());
        }
        return tList;
    }

    @Override
    public String getTeamReportJSON(List<teamReportVO> list) {
        List<ValueName> vns = new ArrayList<>();
        for (teamReportVO t: list){
            ValueName vn = new ValueName();
            vn.setName(t.getTeamName());
            vn.setValue(t.getInstallCount());
            vns.add(vn);
        }
        return JSON.toJSONString(vns);
    }
}
