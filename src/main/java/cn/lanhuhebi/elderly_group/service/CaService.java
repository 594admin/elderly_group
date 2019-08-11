package cn.lanhuhebi.elderly_group.service;
import cn.lanhuhebi.elderly_group.model.pojo.Ca;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface CaService {

    Ca getCaById(String id);

    Integer addCa(Ca ca);

    Integer updateCa(Ca ca);

    Integer delCaById(String id);

}
