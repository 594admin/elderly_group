package cn.lanhuhebi.elderly_group.service;
import cn.lanhuhebi.elderly_group.model.pojo.Feedback;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface FeedbackService {

    Feedback getFeedbackById(String id);

    Integer addFeedback(Feedback feedback);

    Integer updateFeedback(Feedback feedback);

    Integer delFeedbackById(String id);

}
