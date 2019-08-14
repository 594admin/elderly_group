package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 查询全部状态等于1 的员工
     * @return
     */
    List<Personnel> listPersonnel();

    /**
     * 新增员工信息
     * @param personnel
     * @return
     */
    int addPersonnel(Personnel personnel);
    /**
     * 修改员工信息
     * @param personnel
     * @return
     */
    int updatePersonnel(Personnel personnel);

    /**
     * 查询手机号是否重复
     * @param prePhone
     * @return
     */
    String checkPhone(@Param("prePhone")String prePhone);

    /**
     * 查询email是否重复
     * @param preEmail
     * @return
     */
    String checkEmail(@Param("preEmail")String preEmail);

    /**
     * 根据主键查询一条员工信息
     * @param preId
     * @return
     */
    Personnel getPersonnelOne(@Param("preId")Integer preId);

    /**
     * 查询除我以外的手机号是否重复，返回值为重复账号状态
     * 返回 0 重复并且账号已经注销
     * 返回 1 重复并且账号正在使用
     * 返回 2 不重复
     * @param prePhone
     * @param preId
     * @return
     */
    Integer checkPhoneByPreId(@Param("prePhone")String prePhone,@Param("preId")Integer preId);
    /**
     * 查询除我以外的邮箱是否重复，返回值为重复账号状态
     * 返回 0 重复并且账号已经注销
     * 返回 1 重复并且账号正在使用
     * 返回 2 不重复
     * @param preEmail
     * @param preId
     * @return
     */
    Integer checkEmailByPreId(@Param("preEmail")String preEmail,@Param("preId")Integer preId);
    /**
     * 给一个员工修改权限
     * @param roleId
     * @param preId
     * @return
     */
    int addPerRole(@Param("roleId") Integer roleId,@Param("preId")Integer preId );

}
