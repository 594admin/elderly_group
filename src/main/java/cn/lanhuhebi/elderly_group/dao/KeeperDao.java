package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.pojo.Keeper;
import org.apache.ibatis.annotations.Param;

public interface KeeperDao {

//    添加设备库存信息
    int addKeeper(Keeper keeper);

    //    修改设备库存信息
    int updateKeeper(@Param("k_status") Integer k_status, @Param("kid") Integer kid);


}
