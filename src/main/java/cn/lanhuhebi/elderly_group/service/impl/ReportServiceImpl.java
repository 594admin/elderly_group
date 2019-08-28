package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.constant.AreaConstant;
import cn.lanhuhebi.elderly_group.dao.ReportMapper;
import cn.lanhuhebi.elderly_group.model.domain.*;
import cn.lanhuhebi.elderly_group.service.ReportService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author dxq
 * @date 2019-08-22 - 22:09
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Resource
    private ReportMapper reportMapper;

    @Override
    public List<AreaReport> selectAreaReportBy(ReportData reportData) {
        List<AreaReport> areaReports = new ArrayList<>();
        List<ReportVo> reports = getReportVo(reportData);
        AreaReport report = null;

        for (ReportVo r : reports) {
            List<FamilyVo> familys = r.getFamilys();
            report = new AreaReport();

            report.setArea(r.getQvName());

            Set<Integer> h = new HashSet<>();
            Set<Integer> rh = new HashSet<>();
            Set<Integer> sh = new HashSet<>();
            int tCount = 0;
            int rtCount = 0;
            int stCount = 0;

            for (FamilyVo familyVo  : familys){
                h.add(familyVo.getFlyId());
                boolean rhb = false;
                boolean shb = false;
                List<OrderVo> orders = familyVo.getOrders();
                for (OrderVo o : orders){
                    tCount += o.getOrEptNum();
                    if (AreaConstant.EPT_TYPE_R.equals(o.getEptType())){
                        rhb = true;
                        rtCount += o.getOrEptNum();
                    } else if (AreaConstant.EPT_TYPE_S.equals(o.getEptType())){
                        shb = true;
                        stCount += o.getOrEptNum();
                    }
                }
                if (rhb){
                    rh.add(familyVo.getFlyId());
                }
                if (shb){
                    sh.add(familyVo.getFlyId());
                }
            }
            report.sethCount(h.size());
            report.settCount(tCount);
            report.setRtCount(rtCount);
            report.setStCount(stCount);
            report.setRhCount(rh.size());
            report.setShCount(sh.size());
            areaReports.add(report);
        }

        return areaReports;
    }

    @Override
    public AreaReport tongji(List<AreaReport> list) {
        AreaReport report = new AreaReport();
        Stream<AreaReport> stream = list.stream();
        int tcount = 0;
        int hcount = 0;
        int rtcount = 0;
        int rhcount = 0;
        int stcount = 0;
        int shcount = 0;
        for (AreaReport a : list){
            tcount += a.gettCount();
            hcount += a.gethCount();
            rtcount += a.getRtCount();
            rhcount += a.getRhCount();
            stcount += a.getStCount();
            shcount += a.getShCount();
        }
        report.settCount(tcount);
        report.sethCount(hcount);
        report.setRtCount(rtcount);
        report.setRhCount(rhcount);
        report.setStCount(stcount);
        report.setShCount(shcount);
        return report;
    }

    @Override
    public String getJSONData(List<AreaReport> list) {
        List<ValueName> vns = new ArrayList<>();
        for (AreaReport a : list){
            ValueName vn = new ValueName();
            vn.setName(a.getArea());
            vn.setValue(a.gettCount());
            vns.add(vn);
        }
        return JSON.toJSONString(vns);
    }

    private List<ReportVo> getReportVo(ReportData reportData){
        if (reportData.getAreaType().equals(AreaConstant.ZONE)){
            List<ReportVo> reportVos = reportMapper.selectFamilyByDate1(reportData.getStart(), reportData.getEnd(), reportData.getAreaId());
            return reportVos;
        } else if (reportData.getAreaType().equals(AreaConstant.COUNTY)){
            List<ReportVo> reportVos = reportMapper.selectFamilyByDate2(reportData.getStart(), reportData.getEnd(), reportData.getAreaId());
            return reportVos;
        } else if (reportData.getAreaType().equals(AreaConstant.VILLAGE)){
            List<ReportVo> reportVos = reportMapper.selectFamilyByDate3(reportData.getStart(), reportData.getEnd(), reportData.getAreaId());
            return reportVos;
        }
        return null;
    }
}
