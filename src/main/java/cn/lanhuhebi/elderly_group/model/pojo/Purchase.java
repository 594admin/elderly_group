package cn.lanhuhebi.elderly_group.model.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

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
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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


    public Integer getPurseId() {
        return purseId;
    }

    public void setPurseId(Integer purseId) {
        this.purseId = purseId;
    }

    public String getPurseNum() {
        return purseNum;
    }

    public void setPurseNum(String purseNum) {
        this.purseNum = purseNum;
    }

    public Date getPursePurseDate() {
        return pursePurseDate;
    }

    public void setPursePurseDate(Date pursePurseDate) {
        this.pursePurseDate = pursePurseDate;
    }

    public Integer getPursePayMethod() {
        return pursePayMethod;
    }

    public void setPursePayMethod(Integer pursePayMethod) {
        this.pursePayMethod = pursePayMethod;
    }

    public Date getPursePayDate() {
        return pursePayDate;
    }

    public void setPursePayDate(Date pursePayDate) {
        this.pursePayDate = pursePayDate;
    }

    public String getPurseReceipt() {
        return purseReceipt;
    }

    public void setPurseReceipt(String purseReceipt) {
        this.purseReceipt = purseReceipt;
    }

    public String getPurseInstPtl() {
        return purseInstPtl;
    }

    public void setPurseInstPtl(String purseInstPtl) {
        this.purseInstPtl = purseInstPtl;
    }

    public Date getPurseOutlibDate() {
        return purseOutlibDate;
    }

    public void setPurseOutlibDate(Date purseOutlibDate) {
        this.purseOutlibDate = purseOutlibDate;
    }

    public Integer getPurseDistId() {
        return purseDistId;
    }

    public void setPurseDistId(Integer purseDistId) {
        this.purseDistId = purseDistId;
    }

    public Date getPurseInstDate() {
        return purseInstDate;
    }

    public void setPurseInstDate(Date purseInstDate) {
        this.purseInstDate = purseInstDate;
    }

    public String getPurseEptNo() {
        return purseEptNo;
    }

    public void setPurseEptNo(String purseEptNo) {
        this.purseEptNo = purseEptNo;
    }

    public Integer getPurseFlyId() {
        return purseFlyId;
    }

    public void setPurseFlyId(Integer purseFlyId) {
        this.purseFlyId = purseFlyId;
    }

    public Integer getPurseStatus() {
        return purseStatus;
    }

    public void setPurseStatus(Integer purseStatus) {
        this.purseStatus = purseStatus;
    }

    public String getPursePhoto() {
        return pursePhoto;
    }

    public void setPursePhoto(String pursePhoto) {
        this.pursePhoto = pursePhoto;
    }
}
