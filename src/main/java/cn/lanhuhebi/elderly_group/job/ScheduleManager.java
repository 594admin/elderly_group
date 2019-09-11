package cn.lanhuhebi.elderly_group.job;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @author dxq
 * @date 2019-09-01 - 19:32
 */

@Component
public class ScheduleManager {

    @Autowired
    private Scheduler scheduler;

    public void buildJob(String corn) throws SchedulerException {
        CronScheduleBuilder scheduleBuilder =CronScheduleBuilder.cronSchedule(corn);

        JobDetail jobDetail = JobBuilder.newJob(SchedulerJob.class)
                .withIdentity(SchedulerJob.JOBNAME,SchedulerJob.JOBGROUP)
                .withDescription(SchedulerJob.JOBDESCRIPTION)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(SchedulerJob.JOBNAME,SchedulerJob.JOBGROUP)
                .withDescription(SchedulerJob.JOBDESCRIPTION)
                .withSchedule(scheduleBuilder)
                .build();

        Date date = scheduler.scheduleJob(jobDetail, trigger);
        System.out.println(date);
        scheduler.start();
    }

    public void updateJob(String cron) throws SchedulerException {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(SchedulerJob.JOBNAME, SchedulerJob.JOBGROUP);
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (SchedulerException e) {
            throw new RuntimeException("更新定时任务失败");
        }
    }

    public void jobPause(String jobClassName, String jobGroupName) throws Exception {
        scheduler.pauseJob(JobKey.jobKey(jobClassName, jobGroupName));
    }

    public void jobdelete(String jobClassName, String jobGroupName) throws Exception {
        scheduler.pauseTrigger(TriggerKey.triggerKey(jobClassName, jobGroupName));
        scheduler.unscheduleJob(TriggerKey.triggerKey(jobClassName, jobGroupName));
        scheduler.deleteJob(JobKey.jobKey(jobClassName, jobGroupName));
    }


}
