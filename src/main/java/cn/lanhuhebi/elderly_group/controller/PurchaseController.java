package cn.lanhuhebi.elderly_group.controller;

import cn.lanhuhebi.elderly_group.model.pojo.Order;
import cn.lanhuhebi.elderly_group.model.pojo.Purchase;
import cn.lanhuhebi.elderly_group.service.FamilyService;
import cn.lanhuhebi.elderly_group.service.OrderService;
import cn.lanhuhebi.elderly_group.service.PurchaseService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class PurchaseController {

    @Resource
    private PurchaseService purchaseService;
    @Resource
    private FamilyService familyService;
    @Resource
    private OrderService orderService;


    @RequestMapping(value = "/doAddPurchase",method = RequestMethod.POST)
    @Transactional
    public String doAddPurchase(Purchase purchase, @RequestParam("orEptId") List<Integer> orEptId, @RequestParam("orEptNum")List<Integer> orEptNum, @RequestParam("orEptPrice")List<Double> orEptPrice , @RequestParam("purseFlyId")Integer purseFlyId , RedirectAttributes model){
        System.out.println(orEptId+"*****************8");
        int i1 = this.purchaseService.addOnePurchase(purchase);
        Integer or_purse_id=purchase.getPurseId();
        Order order=new Order();
        for(int i=0;i<orEptId.size();i++){
            order.setOrEptId(orEptId.get(i));
            order.setOrEptNum(orEptNum.get(i));
            order.setOrEptPrice((orEptPrice.get(i)*orEptNum.get(i)));
            order.setOrPurseId(or_purse_id);
            this.orderService.addOrder(order);
        }
        if(i1>0){
            this.familyService.updateFamilyAddStatus(3,purseFlyId);
            model.addAttribute("fly_status",3);
            model.addAttribute("fly_id",purseFlyId);
            return "redirect:/tosecond";
        }else{
            model.addAttribute("addmsg","添加失败");
            return "family/familyadd_equiment";
        }


    }

}
