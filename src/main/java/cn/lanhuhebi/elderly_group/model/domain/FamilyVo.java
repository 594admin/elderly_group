package cn.lanhuhebi.elderly_group.model.domain;

import java.util.List;

/**
 * @author dxq
 * @date 2019-08-23 - 0:21
 */
public class FamilyVo {

    private Integer flyId;

    private List<OrderVo> orders;

    public Integer getFlyId() {
        return flyId;
    }

    public void setFlyId(Integer flyId) {
        this.flyId = flyId;
    }

    public List<OrderVo> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderVo> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "FamilyVo{" +
                "flyId=" + flyId +
                ", orders=" + orders +
                '}';
    }
}
