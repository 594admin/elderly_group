package cn.lanhuhebi.elderly_group.job;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author dxq
 * @date 2019-09-01 - 19:32
 */

@Component
public class ScheduleManager {

    @Autowired
    private Scheduler scheduler;


    public void buildJob(String corn) throws SchedulerException {
        System.out.println("scheduler++++++++++++++++++++++++++++++++++++++++++++++++++++++"+scheduler);
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

        scheduler.scheduleJob(jobDetail,trigger);
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

}
