package cn.lanhuhebi.elderly_group.dao;
import cn.lanhuhebi.elderly_group.model.pojo.Ca;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface CaDao {

	Ca getCaById(@Param(value = "id") String id);

	Integer addCa(Ca ca);

	Integer updateCa(Ca ca);

	Integer delCaById(@Param(value = "id") String id);

}
