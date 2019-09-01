package cn.lanhuhebi.elderly_group.util;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dxq
 * @date 2019-09-01 - 19:32
 */
public class ScheduleUtils {

    @Autowired
    private Scheduler scheduler;

    public void buildJob(String corn) throws SchedulerException {
        CronScheduleBuilder scheduleBuilder =CronScheduleBuilder.cronSchedule(corn);

        //Job   withIdentity(String name, String group)
        JobDetail jobDetail = JobBuilder.newJob(SchedulerJob.class)
                .withIdentity(SchedulerJob.JOBNAME,SchedulerJob.JOBGROUP)
                .withDescription(SchedulerJob.JOBDESCRIPTION)
                .build();

        //Trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(SchedulerJob.JOBNAME,SchedulerJob.JOBGROUP)
                .withDescription(SchedulerJob.JOBDESCRIPTION)
                .build();

        scheduler.scheduleJob(jobDetail,trigger);
    }

    public boolean updateJob(String group,String name, String cron){
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        TriggerKey triggerKey = getTriggerKey(name,group);
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(triggerKey)
                .withSchedule(scheduleBuilder)
                .build();

        try {
            scheduler.rescheduleJob(triggerKey,trigger);
            return true;
        } catch (SchedulerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public TriggerKey getTriggerKey(String group,String name){
        return TriggerKey.triggerKey(name,group);
    }
}
