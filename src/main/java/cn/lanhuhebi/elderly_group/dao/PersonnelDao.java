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

    List<Personnel> getAllPersonnel(@Param("personnel") Personnel personnel, @Param("page") int page);
}
