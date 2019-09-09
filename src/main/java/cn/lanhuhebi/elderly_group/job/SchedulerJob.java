package cn.lanhuhebi.elderly_group.job;

import cn.lanhuhebi.elderly_group.service.CollectService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author dxq
 * @date 2019-09-01 - 19:25
 */
public class SchedulerJob extends QuartzJobBean {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerJob.class);

    public static final String JOBNAME = "数据采集定时任务";

    public static final String JOBGROUP = "数据采集分组";

    public static final String JOBDESCRIPTION = "数据采集";

    @Autowired
    private CollectService collectService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
       // logger.info("---------------------------------数据采集-----------------------------------");
    }
}
