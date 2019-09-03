package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.model.domain.SmartequVo;
import cn.lanhuhebi.elderly_group.model.pojo.Smartequ;
import cn.lanhuhebi.elderly_group.service.CollectService;
import cn.lanhuhebi.elderly_group.util.JSONUtil;
import cn.lanhuhebi.elderly_group.webservice.generator.Smartdatatransmission_PortType;
import cn.lanhuhebi.elderly_group.webservice.utils.SequenceUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.rmi.RemoteException;
import java.util.List;

/**
 * @author dxq
 * @date 2019-09-01 - 19:30
 */
public class CollectServiceImpl implements CollectService {

    @Autowired
    private Smartdatatransmission_PortType smartdatatransmission;

    @Override
    public Integer insertequFromservice() {

        try {
            String smartequlistdata = smartdatatransmission.getsmartequlistdata(SequenceUtils.ORGID, SequenceUtils.sequence(), SequenceUtils.md5());
            if (JSONUtil.getJSONResult(smartequlistdata).equals("OK")){
                List<Smartequ> smartequs = JSONUtil.parseJSON(smartequlistdata);

            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

}
