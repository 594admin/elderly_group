package cn.lanhuhebi.elderly_group.model.pojo;
import java.util.Date;

/**
 * @ClassName Purchase
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Purchase {

    //采购ID
    private Integer purseId;

    //采购单号
    private String purseNum;

    //采购时间
    private Date pursePurseDate;

    //付款方式
    private Integer pursePayMethod;

    //付款时间
    private Date pursePayDate;

    //收据单号
    private String purseReceipt;

    //安装协议
    private String purseInstPtl;

    //出库时间
    private Date purseOutlibDate;

    //分配记录ID
    private Integer purseDistId;

    //安装时间
    private Date purseInstDate;

    //设备编码
    private String purseEptNo;

    //户ID
    private Integer purseFlyId;

    //状态
    private Integer purseStatus;

    //人机一体照片
    private String pursePhoto;

    //get set 方法
    public Purchase setPurseId (Integer purseId){
        this.purseId=purseId;
        return this;
    }

    public Integer getPurseId(){
        return this.purseId;
    }

    public Purchase setPurseNum (String purseNum){
        this.purseNum=purseNum;
        return this;
    }

    public String getPurseNum(){
        return this.purseNum;
    }

    public Purchase setPursePurseDate (Date pursePurseDate){
        this.pursePurseDate=pursePurseDate;
        return this;
    }

    public Date getPursePurseDate(){
        return this.pursePurseDate;
    }

    public Purchase setPursePayMethod (Integer pursePayMethod){
        this.pursePayMethod=pursePayMethod;
        return this;
    }

    public Integer getPursePayMethod(){
        return this.pursePayMethod;
    }

    public Purchase setPursePayDate (Date pursePayDate){
        this.pursePayDate=pursePayDate;
        return this;
    }

    public Date getPursePayDate(){
        return this.pursePayDate;
    }

    public Purchase setPurseReceipt (String purseReceipt){
        this.purseReceipt=purseReceipt;
        return this;
    }

    public String getPurseReceipt(){
        return this.purseReceipt;
    }

    public Purchase setPurseInstPtl (String purseInstPtl){
        this.purseInstPtl=purseInstPtl;
        return this;
    }

    public String getPurseInstPtl(){
        return this.purseInstPtl;
    }

    public Purchase setPurseOutlibDate (Date purseOutlibDate){
        this.purseOutlibDate=purseOutlibDate;
        return this;
    }

    public Date getPurseOutlibDate(){
        return this.purseOutlibDate;
    }

    public Purchase setPurseDistId (Integer purseDistId){
        this.purseDistId=purseDistId;
        return this;
    }

    public Integer getPurseDistId(){
        return this.purseDistId;
    }

    public Purchase setPurseInstDate (Date purseInstDate){
        this.purseInstDate=purseInstDate;
        return this;
    }

    public Date getPurseInstDate(){
        return this.purseInstDate;
    }

    public Purchase setPurseEptNo (String purseEptNo){
        this.purseEptNo=purseEptNo;
        return this;
    }

    public String getPurseEptNo(){
        return this.purseEptNo;
    }

    public Purchase setPurseFlyId (Integer purseFlyId){
        this.purseFlyId=purseFlyId;
        return this;
    }

    public Integer getPurseFlyId(){
        return this.purseFlyId;
    }

    public Purchase setPurseStatus (Integer purseStatus){
        this.purseStatus=purseStatus;
        return this;
    }

    public Integer getPurseStatus(){
        return this.purseStatus;
    }

    public Purchase setPursePhoto (String pursePhoto){
        this.pursePhoto=pursePhoto;
        return this;
    }

    public String getPursePhoto(){
        return this.pursePhoto;
    }

}
