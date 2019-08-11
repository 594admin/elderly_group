package cn.lanhuhebi.elderly_group.service;
import cn.lanhuhebi.elderly_group.model.pojo.Family;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface FamilyService {

    Family getFamilyById(String id);

    Integer addFamily(Family family);

    Integer updateFamily(Family family);

    Integer delFamilyById(String id);

}
