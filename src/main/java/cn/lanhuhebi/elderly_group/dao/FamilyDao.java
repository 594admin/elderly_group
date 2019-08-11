package cn.lanhuhebi.elderly_group.dao;
import cn.lanhuhebi.elderly_group.model.pojo.Family;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface FamilyDao {

	Family getFamilyById(@Param(value = "id") String id);

	Integer addFamily(Family family);

	Integer updateFamily(Family family);

	Integer delFamilyById(@Param(value = "id") String id);

}
