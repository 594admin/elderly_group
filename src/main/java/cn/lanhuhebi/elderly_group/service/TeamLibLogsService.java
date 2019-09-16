package cn.lanhuhebi.elderly_group.service;

import cn.lanhuhebi.elderly_group.model.pojo.TeamLiblog;
import org.apache.ibatis.annotations.Param;

public interface TeamLibLogsService {

    int addLogs(Integer temLibType, Integer temLibOperator, Integer temLibEptId, Integer temLibPurseId, Integer temLibNum);
}
