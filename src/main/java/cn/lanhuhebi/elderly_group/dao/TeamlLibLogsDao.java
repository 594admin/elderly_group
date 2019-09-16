package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.pojo.TeamLiblog;
import org.apache.ibatis.annotations.Param;

public interface TeamlLibLogsDao {

    //    添加出入库日志
    int addLogs(@Param("tem_lib_type") Integer temLibType, @Param("tem_lib_operator") Integer temLibOperator, @Param("tem_lib_pur_id") Integer temLibPurseId,@Param("tem_lib_ept_id")Integer temLibEptId,@Param("tem_lib_num") Integer temLibNum);
//    int addLogs(TeamLiblog teamLiblog);
}
