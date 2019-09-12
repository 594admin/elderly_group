package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.dto.PurchaseVo;
import cn.lanhuhebi.elderly_group.model.pojo.Purchase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurchaseDao {

    int addOnePurchase(Purchase purchase);

    //查询一条数据
    Purchase queryOneByPurchaseFlyId(@Param("fly_id")Integer fly_id);

    //根据fly_id删除一条记录
    int deletePurchaseByFlyId(@Param("fly_id")Integer fly_id);

    //    查询所有出库管理
    List<PurchaseVo> queryAll(Integer fly_id);

    //    查询出库状态为1
    List<PurchaseVo> queryAll1();

    //    统计出库状态为1的户总数量
    int searchCountByStatus1();

    //    查询出库状态为0
    List<PurchaseVo> queryAll0();

    //    统计出库状态为1的户总数量
    int searchCountByStatus0();

    //    添加入库管理
    int addPurchaseVo(Purchase purchase);

    //    查询个人名下的未安装详情
    List<PurchaseVo> detailPurchaseVo0(Integer fly_id);

    //    查询个人名下的已安装详情
    List<PurchaseVo> detailPurchaseVo1(Integer fly_id);

    //    修改采购表户下的设备状态
    int updateStatus(@Param("purse_fly_id") Integer purse_fly_id, @Param("purse_id") Integer purse_id);

}
