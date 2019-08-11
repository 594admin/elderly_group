package cn.lanhuhebi.elderly_group.dao;
import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface PersonnelDao {

	Personnel getPersonnelById(@Param(value = "id") String id);

	Integer addPersonnel(Personnel personnel);

	Integer updatePersonnel(Personnel personnel);

	Integer delPersonnelById(@Param(value = "id") String id);

}
