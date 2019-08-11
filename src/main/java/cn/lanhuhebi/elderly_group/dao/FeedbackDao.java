package cn.lanhuhebi.elderly_group.dao;
import cn.lanhuhebi.elderly_group.model.pojo.Feedback;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface FeedbackDao {

	Feedback getFeedbackById(@Param(value = "id") String id);

	Integer addFeedback(Feedback feedback);

	Integer updateFeedback(Feedback feedback);

	Integer delFeedbackById(@Param(value = "id") String id);

}
