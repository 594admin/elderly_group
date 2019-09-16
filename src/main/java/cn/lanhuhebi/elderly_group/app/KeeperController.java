package cn.lanhuhebi.elderly_group.app;

import cn.lanhuhebi.elderly_group.model.dto.FamiliesVo;
import cn.lanhuhebi.elderly_group.model.dto.PersonnelVo;
import cn.lanhuhebi.elderly_group.model.dto.PurchaseVo;
import cn.lanhuhebi.elderly_group.model.pojo.Family;
import cn.lanhuhebi.elderly_group.model.pojo.Feedback;
import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import cn.lanhuhebi.elderly_group.model.pojo.TeamEpt;
import cn.lanhuhebi.elderly_group.service.*;
import cn.lanhuhebi.elderly_group.util.TencentCOS;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("keeper")
public class KeeperController {

    @Autowired
    private PersonnelService personnelService;
    @Autowired
    private FamilyService familyService;
    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private TeamEptService teamEptService;
    @Resource
    private FeedbackService feedbackService;
    private String purl = "https://sxd-1258987597.cos.ap-chengdu.myqcloud.com/";

    private String code = "111111";
    private String phone;

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    @RequestMapping("/getCode")
    public String code(@RequestParam("phone")String phone){
        System.out.println("获取验证码");
        if (!personnelService.checkPhone(phone)){
            return "error";
        }
        this.phone = phone;
        return code;
    }

    /**
     * 登录
     * @param uname
     * @param pwd
     * @return
     */
//    @RequestMapping("/login")
//    public String login(@RequestParam("uname")String uname, @RequestParam("pwd")String pwd){
//        if (!this.phone.equals(uname) || !this.code.equals(pwd)){
//            return "error";
//        }
//        Personnel personnel = this.personnelService.login(uname);
//        String p = JSON.toJSONString(personnel);
//        return p;
//    }
    @RequestMapping("/login")
    public ResponseEntity<Personnel> login(@RequestParam("uname")String uname, @RequestParam("pwd")String pwd){
        System.out.println("uname===="+uname+",pwd====="+pwd);
        Personnel personnel = this.personnelService.login(uname);
        if (personnel!=null && personnel.getPreRoleId() == 5 || personnel.getPreRoleId() == 1) {
            System.out.println("per====" + personnel.getPreRoleId() + ",====name" + personnel.getPreName());
//            if (personnel == null){
//                return ResponseEntity.notFound().build();
            System.out.println("8888888888888888888888");
            return ResponseEntity.ok(personnel);
//            return null;
        }else{
//            }
//        }
//        return ResponseEntity.notFound().build();
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//        return ResponseEntity.notFound().header("MyResponseHeader", "MyValue").build("Could't found by the username");
            return ResponseEntity.badRequest().body(null);
        }
    }

    /**
     * 查询当前组所有户信息
     * @param teamId
     * @return
     */
    /*@RequestMapping("/listFamily")
    public ResponseEntity<List<FamiliesVo>> queryFamilyByTeamId(@RequestParam("teamId")Integer teamId){
        List<Family> families = this.familyService.queryFamilyByTeamId(teamId);
        if (CollectionUtils.isEmpty(families)){
            return ResponseEntity.notFound().build();
        }
        List<FamiliesVo> familyVos = families.stream().map(family -> {
            FamiliesVo familyVo = new FamiliesVo();
            BeanUtils.copyProperties(family, familyVo);
            familyVo.setName(family.getFly_name());
            familyVo.setBirthday(family.getFly_birthday());
            familyVo.setCard(family.getFly_IDcard());
            familyVo.setPhone(family.getFly_phone());
            familyVo.setHouse(family.getFly_doorNum());
            return familyVo;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(familyVos);
    }*/

    @RequestMapping(value="listPurchase")
    public ResponseEntity<List<PurchaseVo>> listPurchase(@RequestParam(value = "fly_id",required = false)Integer fly_id){
//        System.out.println("=============================");
//        System.out.println("fly_id11111111======"+fly_id);
        List<PurchaseVo> pList = purchaseService.queryAll(fly_id);
        return ResponseEntity.ok(pList);
    }

    @RequestMapping(value="listPurchaseByStatus1")
    public ResponseEntity<List<PurchaseVo>> listPurchase1(@RequestParam(value = "fly_id",required = false)Integer fly_id){
//        System.out.println("=============================");
//        System.out.println("fly_id11111111======"+fly_id);
        List<PurchaseVo> pList1 = purchaseService.queryAll1();
        return ResponseEntity.ok(pList1);
    }

    @RequestMapping(value="listPurchaseByStatus0")
    public ResponseEntity<List<PurchaseVo>> listPurchase0(@RequestParam(value = "fly_id",required = false)Integer fly_id){
//        System.out.println("=============================");
//        System.out.println("fly_id000000000======"+fly_id);
        List<PurchaseVo> pList0 = purchaseService.queryAll0();
        return ResponseEntity.ok(pList0);
    }

    //    查询个人名下的未安装详情
    @RequestMapping(value="detailPurchaseVo0")
    public ResponseEntity<List<PurchaseVo>> detailPurchaseVo0(@RequestParam(value = "fly_id")Integer fly_id){
//        System.out.println("+++++++++++++++++++++++++++++++");
//        System.out.println("fly_id========"+fly_id);
        return ResponseEntity.ok(purchaseService.detailPurchaseVo0(fly_id));
    }

    //    查询个人名下的已安装详情
    @RequestMapping(value="detailPurchaseVo1")
    public ResponseEntity<List<PurchaseVo>> detailPurchaseVo1(@RequestParam(value = "fly_id")Integer fly_id){
//        System.out.println("+++++++++++++++++++++++++++++++");
//        System.out.println("fly_id========"+fly_id);
        List<PurchaseVo> pList = purchaseService.detailPurchaseVo1(fly_id);
//        for (PurchaseVo p : pList) {
//            System.out.println("p]]]]====="+p.getFly_name());
//        }
        return ResponseEntity.ok(pList);
    }

//    查询所有设备库存
    @RequestMapping(value="doListTeamEpt")
    public ResponseEntity<List<TeamEpt>> doListTeamEpt(){
        /*System.out.println("---------------------------");
        for(TeamEpt e:teamEptService.queryAll()){
            System.out.println("typw========"+e.getTem_ept_type());
        }*/
        return ResponseEntity.ok(teamEptService.queryAll());
    }

    //    根据设备ID查询设备详情
    @RequestMapping(value="detailTeamEpt")
    public ResponseEntity<TeamEpt> detailTeamEpt(@RequestParam(value = "tem_ept_id") Integer tem_ept_id){
//        System.out.println("tid====="+tem_ept_id);
        return ResponseEntity.ok(teamEptService.detailEquipment(tem_ept_id));
    }

//    修改设备库存
    @RequestMapping(value="updateStock")
    public Integer updateStock(@RequestParam(value = "num") Integer num, @RequestParam(value = "temEptId") Integer temEptId,@RequestAttribute("personnelVo") PersonnelVo personnelVo){
        System.out.println("id==="+temEptId+",num==="+num);
        System.out.println(",lib_opera===="+personnelVo.getPreId());
        return teamEptService.updateStockByTemeptid(num, temEptId,personnelVo.getPreId());
    }

//    根据ID查询库存记录
    @RequestMapping(value="detailStock")
    public List<Integer> detailStock(@RequestParam(value = "tem_ept_id") List<Integer> tem_ept_id){
//        System.out.println("temid====="+tem_ept_id);
        List<Integer> stock = new ArrayList<>();
        for (int i = 0; i < tem_ept_id.size(); i++) {
            Integer s = teamEptService.detailStock(tem_ept_id.get(i));
            stock.add(s);
        }
        return stock;
    }

//    添加出库记录
    @RequestMapping(value="addChuku")
    public Integer addChuku(@RequestParam(value = "purse_fly_id") Integer purse_fly_id, @RequestParam(value = "tem_ept_id") List<Integer> tem_ept_id,
                            @RequestParam(value = "num") List<Integer> num,@RequestParam(value = "purse_id") List<Integer> purse_id,@RequestAttribute("personnelVo") PersonnelVo personnelVo,
                            @RequestParam(value = "kid") List<Integer>kid){
        System.out.println("=============================");
        System.out.println("purCon====="+purse_fly_id);
        System.out.println("teamCon=====" + tem_ept_id);
        System.out.println("numCon======" + num);
        System.out.println("puridCon======" + purse_id);
        System.out.println("libCon======"+personnelVo.getPreId());
        if (teamEptService.updateChuku(purse_fly_id, tem_ept_id, num,purse_id,personnelVo.getPreId(),kid)) {
            return 1;
        }
        return 0;
    }

    //    统计出库状态为0的户总数量
    @RequestMapping(value="searchCountByStatus0")
    public Integer searchCountByStatus0(){
        return purchaseService.searchCountByStatus0();
    }

    //    统计出库状态为1的户总数量
    @RequestMapping(value="searchCountByStatus1")
    public Integer searchCountByStatus1(){
        return purchaseService.searchCountByStatus1();
    }

    //执行添加操作
    @RequestMapping(value = "doAddFeedback"/*,headers = "content-type=multipart/fom-data"*/)
    public int doAddStaff(Feedback feedback, @RequestParam("images") List<MultipartFile> url, Map<String, Object> map) throws Exception {
        System.out.println("========");
        StringBuffer sb = new StringBuffer();
        String pic = "";
        File excelFile = null;
        for (int i=0;i<url.size();i++) {
            if (url.get(i)!=null&&!url.get(i).isEmpty()) {
                // 获取文件名
                String fileName = url.get(i).getOriginalFilename();
                // 获取文件后缀
                String prefix = fileName.substring(fileName.lastIndexOf("."));
                // 用uuid作为文件名，防止生成的临时文件重复
                excelFile = File.createTempFile(String.valueOf(System.currentTimeMillis()),prefix);
                // 将MultipartFile转为File
                url.get(i).transferTo(excelFile);
                //调用腾讯云工具上传文件
                fileName = TencentCOS.uploadfile(excelFile);
                sb.append(purl).append(fileName).append(",");
            }
        }
        pic = sb.substring(0, sb.length() - 1);
        feedback.setFbk_pic(pic);
//        以下数据仅是测试使用
//        feedback.setFbk_person(16);
        int row = feedbackService.addFeedback(feedback);
        //程序结束时，删除临时文件
        deleteFile(excelFile);
        //存入图片名称，用于网页显示
        map.put("imageName", pic);
        //返回图片名称
        if (row > 0) {
            return 1;
        }
        return 0;
    }

    /**
     * 删除临时文件
     *
     * @param files
     */
    private void deleteFile(File... files) {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
