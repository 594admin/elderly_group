package cn.lanhuhebi.elderly_group.model.pojo;


import java.io.Serializable;
import java.util.Date;

public class MonthlyPlan  {

  private Integer mon_id;
  private String mon_year;
  private Integer mon_count;
  private Integer mon_Sept_num;
  private Integer mon_Rept_num;
  private Date mon_updateDate;
  private Integer mon_status;
  private Integer mon_area_id;

  public Integer getMon_id() {
    return mon_id;
  }

  public void setMon_id(Integer mon_id) {
    this.mon_id = mon_id;
  }

  public String getMon_year() {
    return mon_year;
  }

  public void setMon_year(String mon_year) {
    this.mon_year = mon_year;
  }

  public Integer getMon_count() {
    return mon_count;
  }

  public void setMon_count(Integer mon_count) {
    this.mon_count = mon_count;
  }

  public Integer getMon_Sept_num() {
    return mon_Sept_num;
  }

  public void setMon_Sept_num(Integer mon_Sept_num) {
    this.mon_Sept_num = mon_Sept_num;
  }

  public Integer getMon_Rept_num() {
    return mon_Rept_num;
  }

  public void setMon_Rept_num(Integer mon_Rept_num) {
    this.mon_Rept_num = mon_Rept_num;
  }

  public Date getMon_updateDate() {
    return mon_updateDate;
  }

  public void setMon_updateDate(Date mon_updateDate) {
    this.mon_updateDate = mon_updateDate;
  }

  public Integer getMon_status() {
    return mon_status;
  }

  public void setMon_status(Integer mon_status) {
    this.mon_status = mon_status;
  }

  public Integer getMon_area_id() {
    return mon_area_id;
  }

  public void setMon_area_id(Integer mon_area_id) {
    this.mon_area_id = mon_area_id;
  }
}
