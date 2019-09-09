package cn.lanhuhebi.elderly_group.service;

import cn.lanhuhebi.elderly_group.model.dto.InstallVo;

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
}
