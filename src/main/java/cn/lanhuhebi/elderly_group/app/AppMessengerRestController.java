package cn.lanhuhebi.elderly_group.app;

import cn.lanhuhebi.elderly_group.model.dto.PersonnelVo;
import cn.lanhuhebi.elderly_group.model.pojo.Family;
import cn.lanhuhebi.elderly_group.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

/*    @PostMapping("listFly")
    public ResponseEntity<List<Family>> listfamily(@RequestAttribute("personnelVo") PersonnelVo personnelVo) {
        System.out.println(" <<<<<===personnelVo===>>>> " + personnelVo);
        return ResponseEntity.ok(familyService.queryAllByPerId(personnelVo.getPreId()));
    }*/

    @PostMapping("listFly")
    public ResponseEntity<List<Family>> listfamily(@RequestParam("per_id") Integer sss) {
        System.out.println(" <<<<<===personnelVo===>>>> " + sss);
        return ResponseEntity.ok(familyService.queryAllByPerId(sss));
    }

    @PostMapping("delFly")
    public String deleteFamily(@RequestParam("flyId") Integer flyId) {
        boolean b = familyService.updateFamilyStatus(flyId);
        return b ? "success" : "fail";
    }

    @PostMapping("/selectflybyId")
    public ResponseEntity<Family> selectflybyId(@RequestParam("fly_id")Integer flyid){
        Family family = familyService.queryOneById(flyid);
        return ResponseEntity.ok(family);
    }

}
