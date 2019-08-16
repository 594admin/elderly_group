package cn.lanhuhebi.elderly_group.service;

import cn.lanhuhebi.elderly_group.model.dto.FeedbackVo;
import cn.lanhuhebi.elderly_group.model.pojo.Feedback;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface FeedbackService {

    //    查看所有意见反馈
    List<FeedbackVo> queryAllFeedback(Integer fbk_person);

    //    根据用户ID查询意见反馈
    Feedback detailFeedback(Integer fbk_phone);

    //    添加意见反馈
    int addFeedback(Feedback feedback);

    //    删除意见反馈
    int deleteFeedback(Integer fbk_id);

    //    修改意见反馈
    int updateFeedback(Feedback feedback);

    //    分页查看意见反馈
    PageInfo<FeedbackVo> queryAllFeedbackByPage(Integer page, Integer size,Integer fbk_person);

    //    根据编号查询意见反馈
    Feedback detailFeedbackById(Integer fbk_id);
}
