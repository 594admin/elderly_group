package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.dao.FeedbackDao;
import cn.lanhuhebi.elderly_group.model.dto.FeedbackVo;
import cn.lanhuhebi.elderly_group.model.pojo.Feedback;
import cn.lanhuhebi.elderly_group.service.FeedbackService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Resource
    private FeedbackDao feedbackDao;

    @Override
    public List<FeedbackVo> queryAllFeedback(Integer fbk_person) {
        return feedbackDao.queryAllFeedback(fbk_person);
    }

    @Override
    public Feedback detailFeedback(Integer fbk_phone) {
        return feedbackDao.detailFeedback(fbk_phone);
    }

    @Override
    public int addFeedback(Feedback feedback) {
        return feedbackDao.addFeedback(feedback);
    }

    @Override
    public int deleteFeedback(Integer fbk_id) {
        return feedbackDao.deleteFeedback(fbk_id);
    }

    @Override
    public int updateFeedback(Feedback feedback) {
        return feedbackDao.updateFeedback(feedback);
    }

    @Override
    public PageInfo<FeedbackVo> queryAllFeedbackByPage(Integer page, Integer size,Integer fbk_person) {
        PageHelper.startPage(page, size);
        List<FeedbackVo> fList = feedbackDao.queryAllFeedback(fbk_person);
        PageInfo<FeedbackVo> pageInfo = new PageInfo<>(fList);
        return pageInfo;
    }

    @Override
    public Feedback detailFeedbackById(Integer fbk_id) {
        return feedbackDao.detailFeedbackById(fbk_id);
    }
}
