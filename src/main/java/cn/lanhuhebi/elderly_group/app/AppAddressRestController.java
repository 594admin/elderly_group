package cn.lanhuhebi.elderly_group.app;

import cn.lanhuhebi.elderly_group.model.pojo.Area;
import cn.lanhuhebi.elderly_group.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName AppAddressRestController
 * @Author Oblivion
 * @Date 2019/9/5
 * @Version 1.0
 **/
@RequestMapping("address")
@RestController
public class AppAddressRestController {

    @Autowired
    private AreaService areaService;

    @PostMapping("listArea")
    public ResponseEntity<List<Area>> listSunArea(@RequestParam("areaId") Integer areaId) {
        System.out.println("<<<<++++++== listArea ==+++++>>>>");
        List<Area> areas = areaService.queryAllXiaJiByShang(areaId);
        if (areas.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(areas);
    }
}
