package cn.lanhuhebi.elderly_group.service;
import cn.lanhuhebi.elderly_group.model.pojo.Switches;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface SwitchesService {

    Switches getSwitchesById(String id);

    Integer addSwitches(Switches switches);

    Integer updateSwitches(Switches switches);

    Integer delSwitchesById(String id);

}
