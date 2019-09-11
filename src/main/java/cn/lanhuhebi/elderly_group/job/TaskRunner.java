package cn.lanhuhebi.elderly_group.job;

import cn.lanhuhebi.elderly_group.job.domain.SchedulerCron;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author dxq
 * @date 2019-09-02 - 8:57
 */
@Component
public class TaskRunner implements ApplicationRunner {

    @Autowired
    private ScheduleManager scheduleManager;

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private SchedulerCron schedulerCron;

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("----------------------------------------------------系统启动----------------------------------------------------");
        JobKey jobKey = new JobKey(SchedulerJob.JOBNAME,SchedulerJob.JOBGROUP);
        try {
            if (!scheduler.checkExists(jobKey)){
                System.out.println("加载定时任务--------------------------------");
                scheduleManager.buildJob(schedulerCron.getCrons().get("30"));
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
