package cn.lanhuhebi.elderly_group.service;

import cn.lanhuhebi.elderly_group.model.dto.allocation.AlcDistVO;
import cn.lanhuhebi.elderly_group.model.dto.allocation.AlcFamilyVO;
import cn.lanhuhebi.elderly_group.model.pojo.Family;
import cn.lanhuhebi.elderly_group.model.pojo.Personnel;

import java.util.List;

/**
 * @author FanWeichong
 * @date 2019-09-19 10:38
 */
public interface AllocationService {
    //根据组长ID获取本组已分配的户信息
    List<Family> getAllocationInfoByTeamLeaderId(int teamLeaderId,Integer areaId);
    //根据组长ID获取本组未分配的户信息
    List<Family> getUnAllocationInfoByTeamLeaderId(int teamLeaderId,Integer areaId);
    //根据户ID--获取分配页（查看页）户信息（户主姓名、家庭住址、电话、安装协议编号）
    AlcFamilyVO getAlcFamilyVOByfId(int fid);
    //根据户ID--获取未分配户所在小组的安装工（安装工id和姓名）
    List<Personnel> getUnAlcInstallerByfId(int fid);
    //根据户ID--获取已分配户的安装工姓名(string)
    String getAlcInstallersByFid(int fid);
    //根据户ID--获取已分配户的安装工部分信息（操作人姓名、时间）
    AlcDistVO getAlcInfo(int fid);
    //根据户ID--给户分配安装工
    int alloctionInstaller(int fid,String installers);
    //根据户ID--修改户已分配的安装工
    int updAlcInstaller(int fid,String installers);
}
