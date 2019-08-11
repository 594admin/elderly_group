package cn.lanhuhebi.elderly_group.service.impl;
import cn.lanhuhebi.elderly_group.dao.FeedbackDao;
import cn.lanhuhebi.elderly_group.model.pojo.Feedback;
import cn.lanhuhebi.elderly_group.service.FeedbackService;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Resource
    private FeedbackDao feedbackDao;

    public Feedback getFeedbackById(String id){
        return feedbackDao.getFeedbackById(id);
    }

    public Integer addFeedback(Feedback feedback){
            return feedbackDao.addFeedback(feedback);
    }

    public Integer updateFeedback(Feedback feedback){
        return feedbackDao.updateFeedback(feedback);
    }

    public Integer delFeedbackById(String id){
        return feedbackDao.delFeedbackById(id);
    }

}
