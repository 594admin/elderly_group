package cn.lanhuhebi.elderly_group.model.domain;

/**
 * @author dxq
 * @date 2019-08-22 - 16:50
 */
public class OrderVo {


    //数量
    private Integer orEptNum;

    //类型
    private String eptType;


    public Integer getOrEptNum() {
        return orEptNum;
    }

    public void setOrEptNum(Integer orEptNum) {
        this.orEptNum = orEptNum;
    }

    public String getEptType() {
        return eptType;
    }

    public void setEptType(String eptType) {
        this.eptType = eptType;
    }

    @Override
    public String toString() {
        return "OrderVo{" +
                ", orEptNum=" + orEptNum +
                ", eptType='" + eptType + '\'' +
                '}';
    }
}
