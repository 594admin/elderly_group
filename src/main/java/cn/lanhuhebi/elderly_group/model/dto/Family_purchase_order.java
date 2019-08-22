package cn.lanhuhebi.elderly_group.model.dto;

public class Family_purchase_order {

   private Integer orid,oreptid,oreptnum,orpurseid;
   private  double oreptprice ,eptprice	;
   private String eptfacty,eptmodel,epttype;

    public double getEptprice() {
        return eptprice;
    }

    public void setEptprice(double eptprice) {
        this.eptprice = eptprice;
    }

    public Integer getOrid() {
        return orid;
    }

    public void setOrid(Integer orid) {
        this.orid = orid;
    }

    public Integer getOreptid() {
        return oreptid;
    }

    public void setOreptid(Integer oreptid) {
        this.oreptid = oreptid;
    }

    public Integer getOreptnum() {
        return oreptnum;
    }

    public void setOreptnum(Integer oreptnum) {
        this.oreptnum = oreptnum;
    }

    public Integer getOrpurseid() {
        return orpurseid;
    }

    public void setOrpurseid(Integer orpurseid) {
        this.orpurseid = orpurseid;
    }

    public double getOreptprice() {
        return oreptprice;
    }

    public void setOreptprice(double oreptprice) {
        this.oreptprice = oreptprice;
    }

    public String getEptfacty() {
        return eptfacty;
    }

    public void setEptfacty(String eptfacty) {
        this.eptfacty = eptfacty;
    }

    public String getEptmodel() {
        return eptmodel;
    }

    public void setEptmodel(String eptmodel) {
        this.eptmodel = eptmodel;
    }

    public String getEpttype() {
        return epttype;
    }

    public void setEpttype(String epttype) {
        this.epttype = epttype;
    }
}
