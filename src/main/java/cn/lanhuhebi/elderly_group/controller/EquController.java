package cn.lanhuhebi.elderly_group.controller;

import cn.lanhuhebi.elderly_group.job.ScheduleManager;
import cn.lanhuhebi.elderly_group.job.SchedulerJob;
import cn.lanhuhebi.elderly_group.job.domain.SchedulerCron;
import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import cn.lanhuhebi.elderly_group.model.pojo.Rateupdalog;
import cn.lanhuhebi.elderly_group.service.CollectService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author dxq
 * @date 2019-09-03 - 8:17
 */
@Controller
public class EquController {

    @Autowired
    private SchedulerCron schedulerCron;

    @Autowired
    private CollectService collectService;

    @Autowired
    private ScheduleManager scheduleManager;

    @RequestMapping("/toEquList")
    public String toEquList(){
        return "dataCollect/EquList";
    }

    @RequestMapping("/toCronList")
    public String toCronList(Model model){
        model.addAttribute("crons",schedulerCron.getCrons());
        List<Rateupdalog> rateupdalogs = collectService.selectAllRateupdalog();
        model.addAttribute("rateupdalogs",rateupdalogs);
        return "dataCollect/cronList";
    }

    @RequestMapping("/setPinCi")
    public String pinci(@RequestParam(value = "pinci")String pinci, HttpServletRequest request){
        String uplogAfter = collectService.selectMaxUplogAfter();
        HttpSession session = request.getSession();
        Personnel personnel = (Personnel) session.getAttribute("personnel");
        Rateupdalog rateupdalog = new Rateupdalog();
        rateupdalog.setUplogBefore(uplogAfter);
        rateupdalog.setUplogAfter(pinci);
        rateupdalog.setUplogOperaDate(new Date());
        rateupdalog.setUplogPreId(personnel.getPrePhone());
        collectService.insertRateupdalog(rateupdalog);
        try {
            scheduleManager.updateJob( schedulerCron.getCrons().get(pinci));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        request.setAttribute("crons",schedulerCron.getCrons());
        List<Rateupdalog> rateupdalogs = collectService.selectAllRateupdalog();
        request.setAttribute("rateupdalogs",rateupdalogs);
        return "dataCollect/cronList";
    }
}
