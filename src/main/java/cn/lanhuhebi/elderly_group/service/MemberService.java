package cn.lanhuhebi.elderly_group.service;
import cn.lanhuhebi.elderly_group.model.pojo.Member;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface MemberService {

    Member getMemberById(String id);

    Integer addMember(Member member);

    Integer updateMember(Member member);

    Integer delMemberById(String id);

}
