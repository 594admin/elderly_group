package cn.lanhuhebi.elderly_group.service;

import cn.lanhuhebi.elderly_group.model.dto.InstallVo;
import cn.lanhuhebi.elderly_group.model.dto.OrderDetailVo;

import java.util.List;

public interface InstallService {

    /**
     * 根据地址查出来已经安装的
     * @param areaId
     * @return
     */
    List<InstallVo> getAlreadyInstalls(Integer areaId,Integer perId);

    /**
     * 根据地址查出来未安装的
     * @param areaId
     * @return
     */
    List<InstallVo> getNotInstalls(Integer areaId,Integer perId);
    /**
     * 查询用户的地址资料信息
     * @param flyId
     * @return
     */
    InstallVo getInstallOne(Integer flyId);

    /**
     * 安装时查询当前采购单的订单明细
     * @param purId
     * @return
     */
    List<OrderDetailVo> getOrderDetailVo(Integer purId);

    /**
     *修改安装状态
     * @param pureId
     * @return
     */
    boolean installEmp(Integer pureId);

}
