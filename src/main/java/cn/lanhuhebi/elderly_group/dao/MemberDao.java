package cn.lanhuhebi.elderly_group.dao;
import cn.lanhuhebi.elderly_group.model.pojo.Member;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface MemberDao {

	Member getMemberById(@Param(value = "id") String id);

	Integer addMember(Member member);

	Integer updateMember(Member member);

	Integer delMemberById(@Param(value = "id") String id);

}
