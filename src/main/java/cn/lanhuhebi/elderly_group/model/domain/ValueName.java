package cn.lanhuhebi.elderly_group.model.domain;

import java.io.Serializable;

/**
 * @author dxq
 * @date 2019-08-25 - 21:33
 */
public class ValueName implements Serializable {

    private Integer value;

    private String name;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
