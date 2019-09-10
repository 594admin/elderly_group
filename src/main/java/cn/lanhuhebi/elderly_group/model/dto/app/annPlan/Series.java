package cn.lanhuhebi.elderly_group.model.dto.app.annPlan;

import java.util.List;

/**
 * echars元素主体信息类
 */
public class Series {

    private String name;//ecahrs元素
    private List<Double> data; //比率集合

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getData() {
        return data;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }
}
