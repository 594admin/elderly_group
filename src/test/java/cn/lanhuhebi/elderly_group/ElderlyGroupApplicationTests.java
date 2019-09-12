package cn.lanhuhebi.elderly_group;

import cn.lanhuhebi.elderly_group.service.InstallService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElderlyGroupApplicationTests {
    @Autowired
    private InstallService installService;
    @Test
    public void aaa(){
        //List<InstallVo> alreadyInstalls = installService.getAlreadyInstalls(null, 20);
        // System.out.println("已安装"+alreadyInstalls.size());
      // List<InstallVo> notInstalls = installService.getNotInstalls(null, 20);

      // System.out.println("未安装"+notInstalls.size());
        boolean b = installService.installEmp(38);
        System.out.println("修改成功 = " + b);
    }
}
