package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.dto.InstallVo;
import cn.lanhuhebi.elderly_group.model.pojo.Dist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InstallDao {
    /**
     * 查询所有的分配单
     * @return
     */
    List<Dist> getDists();

    /**
     * 根据地址查出来已经安装的
     * @param areaId
     * @return
     */
    List<InstallVo> getAlreadyInstalls(@Param("areaId")Integer areaId);

    /**
     * 根据地址查出来未安装的
     * @param areaId
     * @return
     */
    List<InstallVo> getNotInstalls(@Param("areaId")Integer areaId);

    /**
     * 查询用户的地址资料信息
     * @param flyId
     * @return
     */
    InstallVo getInstallOne(@Param("flyId") Integer flyId);
}
