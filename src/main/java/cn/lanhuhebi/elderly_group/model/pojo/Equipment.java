package cn.lanhuhebi.elderly_group.model.pojo;

/**
 * @ClassName Equipment
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Equipment {

    //设备ID
    private Integer eptId;

    //类型
    private String eptType;

    //厂家
    private String eptFacty;

    //型号
    private String eptModel;

    //单价
    private Double eptPrice;

    //库存
    private Integer eptStock;

    //编号
    private String eptNum;

    //get set 方法
    public Equipment setEptId(Integer eptId) {
        this.eptId = eptId;
        return this;
    }

    public Integer getEptId() {
        return this.eptId;
    }

    public Equipment setEptType(String eptType) {
        this.eptType = eptType;
        return this;
    }

    public String getEptType() {
        return this.eptType;
    }

    public Equipment setEptFacty(String eptFacty) {
        this.eptFacty = eptFacty;
        return this;
    }

    public String getEptFacty() {
        return this.eptFacty;
    }

    public Equipment setEptModel(String eptModel) {
        this.eptModel = eptModel;
        return this;
    }

    public String getEptModel() {
        return this.eptModel;
    }

    public Equipment setEptPrice(Double eptPrice) {
        this.eptPrice = eptPrice;
        return this;
    }

    public Double getEptPrice() {
        return this.eptPrice;
    }

    public Equipment setEptStock(Integer eptStock) {
        this.eptStock = eptStock;
        return this;
    }

    public Integer getEptStock() {
        return this.eptStock;
    }

    public Equipment setEptNum(String eptNum) {
        this.eptNum = eptNum;
        return this;
    }

    public String getEptNum() {
        return this.eptNum;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "eptId=" + eptId +
                ", eptType='" + eptType + '\'' +
                ", eptFacty='" + eptFacty + '\'' +
                ", eptModel='" + eptModel + '\'' +
                ", eptPrice=" + eptPrice +
                ", eptStock=" + eptStock +
                ", eptNum='" + eptNum + '\'' +
                '}';
    }
}
