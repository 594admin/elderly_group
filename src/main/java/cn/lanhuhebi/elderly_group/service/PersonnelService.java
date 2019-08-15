package cn.lanhuhebi.elderly_group.service;

import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName PersonnelService
 * @Author Oblivion
 * @Date 2019/8/12
 * @Version 1.0
 **/
public interface PersonnelService {
    /**
     * 登录方法， 根据员工手机号或邮箱查询一条信息，手机号是唯一不重复的
     * @param account
     * @return
     */
    Personnel login(String account);

    /**
     * 查询全部状态等于1 的员工
     * @return
     */
    List<Personnel> listPersonnel();
    //查询所属小组id
    int queryTeamId(@Param("pre_id")Integer pre_id);
}
