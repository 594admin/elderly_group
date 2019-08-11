package cn.lanhuhebi.elderly_group.service.impl;
import cn.lanhuhebi.elderly_group.dao.MemberDao;
import cn.lanhuhebi.elderly_group.model.pojo.Member;
import cn.lanhuhebi.elderly_group.service.MemberService;
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
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberDao memberDao;

    public Member getMemberById(String id){
        return memberDao.getMemberById(id);
    }

    public Integer addMember(Member member){
            return memberDao.addMember(member);
    }

    public Integer updateMember(Member member){
        return memberDao.updateMember(member);
    }

    public Integer delMemberById(String id){
        return memberDao.delMemberById(id);
    }

}
