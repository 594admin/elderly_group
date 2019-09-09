package cn.lanhuhebi.elderly_group.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dxq
 * @date 2019-09-03 - 8:17
 */
@Controller
public class EquController {

    @RequestMapping("/toEquList")
    public String toEquList(){
        return "DataCollect/EquList";
    }
}
