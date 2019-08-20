package cn.lanhuhebi.elderly_group.model.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author dxq
 * @date 2019-08-19 - 21:02
 */
public class ReportData {

    /**
     * 开始日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date start;

    /**
     * 结束日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date end;


    /**
     * 省ID
     */
    private Integer sheng;

    /**
     * 市ID
     */
    private Integer shi;

    /**
     * 区ID
     */
    private Integer qv;

    /**
     * 街ID
     */
    private Integer jie;

    /**
     * 统计类型
     */
    private String areatype;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Integer getSheng() {
        return sheng;
    }

    public void setSheng(Integer sheng) {
        this.sheng = sheng;
    }

    public Integer getShi() {
        return shi;
    }

    public void setShi(Integer shi) {
        this.shi = shi;
    }

    public Integer getQv() {
        return qv;
    }

    public void setQv(Integer qv) {
        this.qv = qv;
    }

    public Integer getJie() {
        return jie;
    }

    public void setJie(Integer jie) {
        this.jie = jie;
    }

    public String getAreatype() {
        return areatype;
    }

    public void setAreatype(String areatype) {
        this.areatype = areatype;
    }

    @Override
    public String toString() {
        return "ReportData{" +
                "start=" + start +
                ", end=" + end +
                ", sheng=" + sheng +
                ", shi=" + shi +
                ", qv=" + qv +
                ", jie=" + jie +
                ", areatype='" + areatype + '\'' +
                '}';
    }
}
