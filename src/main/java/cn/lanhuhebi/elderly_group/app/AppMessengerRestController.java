package cn.lanhuhebi.elderly_group.app;

import cn.lanhuhebi.elderly_group.model.pojo.Family;
import cn.lanhuhebi.elderly_group.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName AppMessengerRestController
 * @Author Oblivion
 * @Date 2019/9/4
 * @Version 1.0
 **/
@RequestMapping("messenger")
@RestController
public class AppMessengerRestController {

    @Autowired
    private FamilyService familyService;

    @PostMapping("listFly")
    public ResponseEntity<List<Family>> listfamily(@RequestParam("per_id") int perId) {
        return ResponseEntity.ok(familyService.queryAllByPerId(perId));
    }

    @PostMapping("delFly")
    public String deleteFamily(@RequestParam("flyId") Integer flyId) {
        boolean b = familyService.updateFamilyStatus(flyId);
        return b ? "success" : "fail";
    }
}
