package cn.lanhuhebi.elderly_group.job.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * @author dxq
 * @date 2019-09-02 - 23:20
 */
public class DefaultTriggerListener implements JobListener {

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {

    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {

    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {

    }
}
