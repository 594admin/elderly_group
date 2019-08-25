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
     * 区域类型
     */
    private String areaType;

    /**
     * 区域ID
     */
    private Integer areaId;



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

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    @Override
    public String toString() {
        return "ReportData{" +
                "start=" + start +
                ", end=" + end +
                ", areaType='" + areaType + '\'' +
                ", areaId=" + areaId +
                '}';
    }
}
