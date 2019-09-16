package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.dao.*;
import cn.lanhuhebi.elderly_group.model.pojo.TeamEpt;
import cn.lanhuhebi.elderly_group.service.EquipmentService;
import cn.lanhuhebi.elderly_group.service.TeamEptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeamEptServiceImpl implements TeamEptService {

    @Resource
    private TeameptDao teameptDao;
    @Resource
    private PurchaseDao purchaseDao;
    @Resource
    private TeamlLibLogsDao teamlLibLogsDao;
    @Resource
    private KeeperDao keeperDao;
    @Resource
    private EquipmentDao equipmentDao;
    @Resource
    private DistDao distDao;

    @Override
    public List<TeamEpt> queryAll() {
        return teameptDao.queryAll();
    }

    @Override
    public TeamEpt detailEquipment(Integer tem_ept_id) {
        return teameptDao.detailEquipment(tem_ept_id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int updateStockByTemeptid(Integer num, Integer temEptId,Integer lib_operator) {
        int a = teameptDao.updateStockByTemeptid(num, temEptId);
        int b = teamlLibLogsDao.addLogs(2, lib_operator,0,temEptId,num);
        int c = equipmentDao.updStock(num, temEptId);
        if (a > 0 && b > 0 && c > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public Integer detailStock(Integer tem_ept_id) {
        return teameptDao.detailStock(tem_ept_id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean updateChuku(Integer purse_fly_id, List<Integer> tem_ept_id, List<Integer> num,List<Integer>purse_id,Integer lib_operator,List<Integer>kid) {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
//        List<Integer> chuKu = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < tem_ept_id.size(); i++) {
            System.out.println("purse_fly_id======" + purse_fly_id);
//            System.out.println("temid======" + tem_ept_id.get(i)+",num======"+num.get(i));

            if (detailStock(tem_ept_id.get(i)) <= 0 && detailStock(tem_ept_id.get(i)) < num.get(i)) {
                flag = false;
                break;
            } else {
                System.out.println("还在继续执行？");
                if (detailStock(tem_ept_id.get(i)) > num.get(i)) {
                    b = teameptDao.updChuKu(num.get(i), tem_ept_id.get(i));
//                    a = purchaseDao.updateStatus(purse_fly_id,purse_id.get(i));
                    a = keeperDao.updateKeeper(1, kid.get(i));
                    c = teamlLibLogsDao.addLogs(1, lib_operator, purse_id.get(i),tem_ept_id.get(i),num.get(i));
//                    chuKu.add(detailStock(tem_ept_id.get(i)));
                    d = distDao.addDist(purse_fly_id);
                    flag = true;
                }
            }
        }
            if (a > 0 && b > 0 && c > 0 && d > 0) {
                flag = true;
        }
        return flag;
    }
}
