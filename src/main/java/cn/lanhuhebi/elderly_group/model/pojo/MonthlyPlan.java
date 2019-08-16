package cn.lanhuhebi.elderly_group.model.pojo;


import java.io.Serializable;
import java.util.Date;

public class MonthlyPlan  {

  private Integer monId;
  private String monYear;
  private Integer monCount;
  private Integer monSeptNum;
  private Integer monReptNum;
  private Date monUpdateDate;
  private Integer monStatus;
  private Integer monAreaId;

  public Integer getMonAreaId() {
    return monAreaId;
  }

  public void setMonAreaId(Integer monAreaId) {
    this.monAreaId = monAreaId;
  }

  public Integer getMonId() {
    return monId;
  }

  public void setMonId(Integer monId) {
    this.monId = monId;
  }

  public String getMonYear() {
    return monYear;
  }

  public void setMonYear(String monYear) {
    this.monYear = monYear;
  }

  public Integer getMonCount() {
    return monCount;
  }

  public void setMonCount(Integer monCount) {
    this.monCount = monCount;
  }

  public Integer getMonSeptNum() {
    return monSeptNum;
  }

  public void setMonSeptNum(Integer monSeptNum) {
    this.monSeptNum = monSeptNum;
  }

  public Integer getMonReptNum() {
    return monReptNum;
  }

  public void setMonReptNum(Integer monReptNum) {
    this.monReptNum = monReptNum;
  }

  public Date getMonUpdateDate() {
    return monUpdateDate;
  }

  public void setMonUpdateDate(Date monUpdateDate) {
    this.monUpdateDate = monUpdateDate;
  }

  public Integer getMonStatus() {
    return monStatus;
  }

  public void setMonStatus(Integer monStatus) {
    this.monStatus = monStatus;
  }
}
