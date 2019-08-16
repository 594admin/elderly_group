package cn.lanhuhebi.elderly_group.model.pojo;


import java.io.Serializable;
import java.util.Date;

public class AnnualPlan  {

  private Integer anpId;
  private Integer anpAreaId;
  private String anpYear;
  private Integer anpSeptNum;
  private Integer anpReptNum;
  private Date anpUpdateDate;
  private Integer anpStatus;


  public Integer getAnpId() {
    return anpId;
  }

  public void setAnpId(Integer anpId) {
    this.anpId = anpId;
  }

  public Integer getAnpAreaId() {
    return anpAreaId;
  }

  public void setAnpAreaId(Integer anpAreaId) {
    this.anpAreaId = anpAreaId;
  }

  public String getAnpYear() {
    return anpYear;
  }

  public void setAnpYear(String anpYear) {
    this.anpYear = anpYear;
  }

  public Integer getAnpSeptNum() {
    return anpSeptNum;
  }

  public void setAnpSeptNum(Integer anpSeptNum) {
    this.anpSeptNum = anpSeptNum;
  }

  public Integer getAnpReptNum() {
    return anpReptNum;
  }

  public void setAnpReptNum(Integer anpReptNum) {
    this.anpReptNum = anpReptNum;
  }

  public Date getAnpUpdateDate() {
    return anpUpdateDate;
  }

  public void setAnpUpdateDate(Date anpUpdateDate) {
    this.anpUpdateDate = anpUpdateDate;
  }

  public Integer getAnpStatus() {
    return anpStatus;
  }

  public void setAnpStatus(Integer anpStatus) {
    this.anpStatus = anpStatus;
  }
}
