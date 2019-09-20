package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.dto.allocation.AlcDistVO;
import cn.lanhuhebi.elderly_group.model.dto.allocation.AlcFamilyVO;
import cn.lanhuhebi.elderly_group.model.pojo.Family;
import cn.lanhuhebi.elderly_group.model.pojo.Personnel;

import java.util.List;

/**
 * @author FanWeichong
 * @date 2019-09-17 8:03
 */
public interface AllocationDao {
    //根据组长ID获取本组已分配的户信息
    List<Family> getAllocationInfoByTeamLeaderId(int teamLeaderId,Integer areaId);
    //根据组长ID获取本组未分配的户信息
    List<Family> getUnAllocationInfoByTeamLeaderId(int teamLeaderId,Integer areaId);
    //根据户ID--获取分配页（查看页）户信息（户主姓名、家庭住址、电话、安装协议编号）
    AlcFamilyVO getAlcFamilyVOByfId(int fid);
    //根据户ID--获取未分配户所在小组的安装工（安装工姓名）
    List<Personnel> getUnAlcInstallerByfId(int fid);
    //根据户ID--获取已分配户的安装工ID数组
    String getAlcInstallers(int fid);
    //根据员工ID--获取员工姓名
    Personnel getInstallerNameByPid(int pid);
    //根据户ID--获取已分配户的安装工部分信息（操作人姓名、时间）
    AlcDistVO getAlcInfo(int fid);
    //根据户ID--给户分配安装工
    int alloctionInstaller(int fid,String installers);
    //根据户ID--修改户已分配的安装工
    int updAlcInstaller(int fid,String installers);
}
