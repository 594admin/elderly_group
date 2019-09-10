package cn.lanhuhebi.elderly_group.model.dto.app.annPlan;

import java.util.List;

public class AnnPlanVo {

    private List<String> categories;
    private List<Series> series;

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<Series> getSeries() {
        return series;
    }

    public void setSeries(List<Series> series) {
        this.series = series;
    }
}
