package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.dao.InstallDao;
import cn.lanhuhebi.elderly_group.dao.OrderDetaillDao;
import cn.lanhuhebi.elderly_group.model.dto.InstallVo;
import cn.lanhuhebi.elderly_group.model.dto.OrderDetailVo;
import cn.lanhuhebi.elderly_group.service.InstallService;
import cn.lanhuhebi.elderly_group.util.EmptyUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service(value = "installserviceimpl")
public class InstallServiceImpl implements InstallService {
    @Resource
    private InstallDao installDao;

    @Resource
    private OrderDetaillDao orderDetaillDao;

    @Override
    public List<InstallVo> getAlreadyInstalls(Integer areaId, Integer perId) {
        List<InstallVo> i = new ArrayList<>();
        List<InstallVo> alreadyInstalls = installDao.getAlreadyInstalls(areaId);
        if(EmptyUtils.isNotEmpty(alreadyInstalls)) {
            for (InstallVo a : alreadyInstalls) {
                if (a.getDistInstaller().contains(String.valueOf(perId))) {
                    i.add(a);
                }
            }
        }
        return i;
    }

    @Override
    public List<InstallVo> getNotInstalls(Integer areaId, Integer perId) {
        List<InstallVo> i = new ArrayList<>();
        List<InstallVo> alreadyInstalls = installDao.getNotInstalls((areaId));
        if(EmptyUtils.isNotEmpty(alreadyInstalls)) {
            for (InstallVo a : alreadyInstalls) {
                if (a.getDistInstaller().contains(String.valueOf(perId))) {
                    i.add(a);
                }
            }
        }
        return i;
    }

    @Override
    public InstallVo getInstallOne(Integer flyId) {
        return installDao.getInstallOne(flyId);
    }

    @Override
    public List<OrderDetailVo> getOrderDetailVo(Integer purId) {
        return orderDetaillDao.getOrderDetailVo(purId);
    }

    @Override
    public boolean installEmp(Integer pureId) {
        Integer pId = installDao.getPId(pureId);
        System.out.println("采购单号:"+pId);
        return installDao.installEmp(pId)>0;
    }
}
