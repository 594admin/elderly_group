package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.pojo.TeamEpt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeameptDao {

//    查询小组所有设备详情
    List<TeamEpt> queryAll();

    //    根据设备ID查询设备详情
    TeamEpt detailEquipment(Integer tem_ept_id);

    //    修改设备库存
    int updateStockByTemeptid(@Param("tem_ept_stock") Integer num, @Param("tem_ept_id") Integer temEptId);

    //    根据设备ID查询设备库存
    Integer detailStock(Integer tem_ept_id);

    //    添加出库管理
    int updChuKu(@Param("tem_ept_stock") Integer tem_ept_stock, @Param("tem_ept_id") Integer temEptId);
}
