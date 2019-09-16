package cn.lanhuhebi.elderly_group.dao;

import org.apache.ibatis.annotations.Param;

public interface DistDao {

    int addDist(@Param("dist_fly_id") Integer purse_fly_id);
}
