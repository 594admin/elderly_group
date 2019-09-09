package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.domain.SmartequVo;
import cn.lanhuhebi.elderly_group.model.pojo.Smartequ;

import java.util.List;

/**
 * @author dxq
 * @date 2019-09-03 - 9:00
 */
public interface CollectMapper {

    int insertequ(List<SmartequVo> smartequs);

    List<Integer> hasEqu(List<Smartequ> smartequs);

}
