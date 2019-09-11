package cn.lanhuhebi.elderly_group.job.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author dxq
 * @date 2019-09-09 - 20:06
 */
@Component
@ConfigurationProperties(prefix = "scheduler")
public class SchedulerCron {

    private Map<String,String> crons;

    public Map<String, String> getCrons() {
        return crons;
    }

    public void setCrons(Map<String, String> crons) {
        this.crons = crons;
    }

    @Override
    public String toString() {
        return "SchedulerCron{" +
                "crons=" + crons +
                '}';
    }
}
