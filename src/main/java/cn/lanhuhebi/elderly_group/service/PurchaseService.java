package cn.lanhuhebi.elderly_group.service;

import cn.lanhuhebi.elderly_group.model.dto.PurchaseVo;
import cn.lanhuhebi.elderly_group.model.pojo.Purchase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurchaseService {

    int addOnePurchase(Purchase purchase);

    Purchase queryOneByFlyId(@Param("fly_id")Integer fly_id);

    //    查询所有出库管理
    List<PurchaseVo> queryAll(Integer fly_id);

    //    添加出库管理
    int addPurchaseVo(Purchase purchase);

    //    查询个人名下的未安装详情
    List<PurchaseVo> detailPurchaseVo0(Integer fly_id);

    //    查询个人名下的已安装详情
    List<PurchaseVo> detailPurchaseVo1(Integer fly_id);

    //    查询出库状态为1
    List<PurchaseVo> queryAll1();

    //    统计出库状态为1的户总数量
    int searchCountByStatus1();

    //    查询出库状态为0
    List<PurchaseVo> queryAll0();

    //    统计出库状态为1的户总数量
    int searchCountByStatus0();

}
