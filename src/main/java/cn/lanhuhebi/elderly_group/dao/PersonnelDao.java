package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName PersonnelDao
 * @Author Oblivion
 * @Date 2019/8/12
 * @Version 1.0
 **/
public interface PersonnelDao {
    /**
     * 登录方法， 根据员工手机号或邮箱查询一条信息，手机号是唯一不重复的
     * @param account
     * @return
     */
    Personnel login(@Param("account")String account);
}
