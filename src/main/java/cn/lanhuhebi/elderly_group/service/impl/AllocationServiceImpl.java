package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.dao.AllocationDao;
import cn.lanhuhebi.elderly_group.model.dto.allocation.AlcDistVO;
import cn.lanhuhebi.elderly_group.model.dto.allocation.AlcFamilyVO;
import cn.lanhuhebi.elderly_group.model.pojo.Family;
import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import cn.lanhuhebi.elderly_group.service.AllocationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author FanWeichong
 * @date 2019-09-19 10:46
 */
@Service
public class AllocationServiceImpl implements AllocationService {
    @Resource
    private AllocationDao allocationDao;

    @Override
    public List<Family> getAllocationInfoByTeamLeaderId(int teamLeaderId,Integer areaId) {
        return allocationDao.getAllocationInfoByTeamLeaderId(teamLeaderId,areaId);
    }

    @Override
    public List<Family> getUnAllocationInfoByTeamLeaderId(int teamLeaderId,Integer areaId) {
        return allocationDao.getUnAllocationInfoByTeamLeaderId(teamLeaderId,areaId);
    }

    @Override
    public AlcFamilyVO getAlcFamilyVOByfId(int fid) {
        return allocationDao.getAlcFamilyVOByfId(fid);
    }

    @Override
    public List<Personnel> getUnAlcInstallerByfId(int fid) {
        return allocationDao.getUnAlcInstallerByfId(fid);
    }

    @Override
    public String getAlcInstallersByFid(int fid) {
        //将获取的安装工id数组（1,2,3）转成安装工姓名数组(张三,李四,王五)
        String installers=allocationDao.getAlcInstallers(fid);
        String[] pids=installers.split(",");
        int[] npids=new int[pids.length];
        for (int i = 0; i < pids.length; i++) {
            npids[i]=Integer.parseInt(pids[i]);
        }
        String[] pName=new String[npids.length];
        for (int i = 0; i < npids.length; i++) {
            Personnel p=allocationDao.getInstallerNameByPid(npids[i]);
            pName[i]=p.getPreName();
        }
        String str= StringUtils.join(pName,",");
        return str;
    }

    @Override
    public AlcDistVO getAlcInfo(int fid) {
        return allocationDao.getAlcInfo(fid);
    }

    @Override
    public int alloctionInstaller(int fid, String installers) {
        return allocationDao.alloctionInstaller(fid,installers);
    }

    @Override
    public int updAlcInstaller(int fid, String installers) {
        return allocationDao.updAlcInstaller(fid,installers);
    }
}
