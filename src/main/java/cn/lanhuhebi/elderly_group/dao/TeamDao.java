package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.dto.TeamListVO;
import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import cn.lanhuhebi.elderly_group.model.pojo.Team;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeamDao {

    //查询所有工程小组（仅组ID和组名）
    List<Team> queryAllTeam();
    //查询所有组长
    List<Personnel> queryAllTeamLeader();
    //查询所有信息员（未入组的）
    List<Personnel> queryAllInformationer();
    //查询所有库管员（未入组的）
    List<Personnel> queryAllWarehouseManager();
    //查询所有安装工（未入组的）
    List<Personnel> queryAllInstaller();
    //查询所有工程小组（TeamListVO中所有信息）
    List<TeamListVO> queryAllTeamVO();
    //查询单个工程小组实体（TeamListVO）
    TeamListVO getTeamVOById(@Param("tem_id")Integer tid);
    //新增工程小组第一步：插入工程小组信息team
    int addTeamTable(@Param("tem_name") String tname,@Param("tem_lead") Integer leaderId,@Param("tem_creator") Integer creatorId);
    //新增工程小组第二步：查询新添加工程小组
    Integer getTeamIdByCreateDate();
    //新增工程小组第三步：插入工程小组成员信息member
    int addMember(@Param("mem_mem") Integer memberId,@Param("mem_tem_id") Integer teamId);

    //根据组ID查询组名、组长ID、组ID
    Team getTeamById(@Param("tem_id") Integer id);
    //根据组ID查询本组信息员ID、姓名
    List<Personnel> getInformationerByTeamId(@Param("mem_tem_id") Integer id);
    //根据组ID查询本组库管员ID、姓名
    List<Personnel> getWarehouseManagerByTeamId(@Param("mem_tem_id") Integer id);
    //根据组ID查询本组安装工ID、姓名
    List<Personnel> getInstallerByTeamId(@Param("mem_tem_id") Integer id);

    //修改工程小组,更新team表
    int updTeamTable(@Param("tem_id") Integer teamId,@Param("tem_name") String tname,@Param("tem_lead") Integer leaderId,@Param("tem_creator") Integer creatorId);
    //根据组ID删除组员
    int delMember(@Param("mem_tem_id") Integer teamId);



}
