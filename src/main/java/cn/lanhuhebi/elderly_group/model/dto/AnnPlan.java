package cn.lanhuhebi.elderly_group.model.dto;

public class AnnPlan {

    private Integer anp_id;
    private Integer anp_area_id;
    private String anp_area;
    private String anp_year;
    private Integer anp_Sept_num;
    private Integer anp_Rept_num;

    public Integer getAnp_area_id() {
        return anp_area_id;
    }

    public void setAnp_area_id(Integer anp_area_id) {
        this.anp_area_id = anp_area_id;
    }

    public Integer getAnp_id() {
        return anp_id;
    }

    public void setAnp_id(Integer anp_id) {
        this.anp_id = anp_id;
    }

    public String getAnp_area() {
        return anp_area;
    }

    public void setAnp_area(String anp_area) {
        this.anp_area = anp_area;
    }

    public String getAnp_year() {
        return anp_year;
    }

    public void setAnp_year(String anp_year) {
        this.anp_year = anp_year;
    }

    public Integer getAnp_Sept_num() {
        return anp_Sept_num;
    }

    public void setAnp_Sept_num(Integer anp_Sept_num) {
        this.anp_Sept_num = anp_Sept_num;
    }

    public Integer getAnp_Rept_num() {
        return anp_Rept_num;
    }

    public void setAnp_Rept_num(Integer anp_Rept_num) {
        this.anp_Rept_num = anp_Rept_num;
    }
}
