package cn.lanhuhebi.elderly_group.service;

import cn.lanhuhebi.elderly_group.model.pojo.TeamEpt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeamEptService {

    //    查询小组所有设备详情
    List<TeamEpt> queryAll();

    //    根据设备ID查询设备详情
    TeamEpt detailEquipment(Integer tem_ept_id);

    //    修改设备库存
    int updateStockByTemeptid(@Param("tem_ept_stock") Integer num, @Param("tem_ept_id") Integer tem_ept_id, Integer lib_operator);

    //    根据设备ID查询设备库存
    Integer detailStock(Integer tem_ept_id);

    //    添加设备出库记录
    boolean updateChuku(Integer purse_fly_id, List<Integer> tem_ept_id, List<Integer> num, List<Integer> purse_id, Integer lib_operator, List<Integer> kid);
}
