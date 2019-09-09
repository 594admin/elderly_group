package cn.lanhuhebi.elderly_group;

import cn.lanhuhebi.elderly_group.dao.ReportMapper;
import cn.lanhuhebi.elderly_group.dao.RoleDao;
import cn.lanhuhebi.elderly_group.job.domain.SchedulerCron;
import cn.lanhuhebi.elderly_group.service.RoleService;
import cn.lanhuhebi.elderly_group.util.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElderlyGroupApplicationTests {
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ReportMapper reportMapper;
    @Test
    public void contextLoads() {

        int roleid = 9;
        Integer[] add = {3,7,8,9,52,20,21,32,17};
        Set<Integer> shu = roleDao.repeatSysRoleAuthByRoleId(9);
        Set<Integer> xin =   new HashSet<>(Arrays.asList(add));
        Set<Integer> qiu = new HashSet<>();

        qiu.clear();
        qiu.addAll(xin);
        qiu.removeAll(shu);
        System.out.println("需要添加的数据= " + qiu);
        if(qiu.size()>0){
            int i = roleDao.addAuthsByRoleId(qiu, roleid);
            if(i>0){
                System.out.println("添加成功"+i);
            }else{
                System.out.println("添加失败");
            }
        }

        qiu.clear();
        qiu.addAll(shu);
        qiu.removeAll(xin);
        System.out.println("需要删除的数据="+qiu);
        if(qiu.size()>0){
            int i1 = roleDao.deleteAuthsByRoleId(qiu, roleid);
            if(i1>0){
                System.out.println("删除成功"+i1);
            }else{
                System.out.println("删除失败");
            }
        }


    }

    @Test
    public void Test(){

       // boolean angang = redisUtils.set("angang", "5555");
        boolean angang = redisUtils.set("angang",60,"55555");
        System.out.println(angang);


    }

    @Autowired
    private SchedulerCron schedulerCron;

    @Test
    public void test001(){
        System.out.println(schedulerCron);
    }

}
