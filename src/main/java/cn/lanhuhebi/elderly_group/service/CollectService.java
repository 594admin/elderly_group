package cn.lanhuhebi.elderly_group.service;

import cn.lanhuhebi.elderly_group.model.pojo.Rateupdalog;

import java.util.List;

/**
 * webservice数据处理
 * @author dxq
 * @date 2019-09-01 - 19:30
 */
public interface CollectService {

    Integer insertequFromservice();

    int insertRateupdalog(Rateupdalog rateupdalog);

    String selectMaxUplogAfter();

    List<Rateupdalog> selectAllRateupdalog();
}
