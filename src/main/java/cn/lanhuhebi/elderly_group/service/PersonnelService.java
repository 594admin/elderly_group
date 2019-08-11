package cn.lanhuhebi.elderly_group.service;
import cn.lanhuhebi.elderly_group.model.pojo.Personnel;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface PersonnelService {

    Personnel getPersonnelById(String id);

    Integer addPersonnel(Personnel personnel);

    Integer updatePersonnel(Personnel personnel);

    Integer delPersonnelById(String id);

}
