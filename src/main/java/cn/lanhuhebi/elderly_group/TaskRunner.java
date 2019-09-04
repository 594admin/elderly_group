package cn.lanhuhebi.elderly_group;

import cn.lanhuhebi.elderly_group.job.SchedulerJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/**
 * @author dxq
 * @date 2019-09-02 - 8:57
 */
//@Component
public class TaskRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("----------------------------------------------------系统启动----------------------------------------------------");
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(SchedulerJob.JOBNAME,SchedulerJob.JOBGROUP);
        System.out.println("triggerKey:------------------"+triggerKey);

        String cron = "0/2 * * * * ?";
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);

        JobDetail jobDetail = JobBuilder.newJob(SchedulerJob.class)
                .withIdentity(SchedulerJob.JOBNAME,SchedulerJob.JOBGROUP)
                .withDescription(SchedulerJob.JOBDESCRIPTION)
                .build();

        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(SchedulerJob.JOBNAME,SchedulerJob.JOBGROUP)
                .withIdentity(SchedulerJob.JOBDESCRIPTION)
                .withSchedule(cronScheduleBuilder)
                .build();

        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
    }
}
