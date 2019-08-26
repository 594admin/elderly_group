package cn.lanhuhebi.elderly_group.model.domain;

/**
 * 区域统计实体类
 * @author dxq
 * @date 2019-08-19 - 11:38
 */
public class AreaReport {

    /**
     * 统计地址
     */
    private String area;

    /**
     * 安装户数
     */
    private Integer hCount;

    /**
     * 安装台数
     */
    private Integer tCount;

    /**
     * 热风机户数
     */
    private Integer rhCount;

    /**
     * 热风机台数
     */
    private Integer rtCount;

    /**
     * 生物质炉具户数
     */
    private Integer shCount;

    /**
     * 生物质炉具台数
     */
    private Integer stCount;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer gethCount() {
        return hCount;
    }

    public void sethCount(Integer hCount) {
        this.hCount = hCount;
    }

    public Integer gettCount() {
        return tCount;
    }

    public void settCount(Integer tCount) {
        this.tCount = tCount;
    }

    public Integer getRhCount() {
        return rhCount;
    }

    public void setRhCount(Integer rhCount) {
        this.rhCount = rhCount;
    }

    public Integer getRtCount() {
        return rtCount;
    }

    public void setRtCount(Integer rtCount) {
        this.rtCount = rtCount;
    }

    public Integer getShCount() {
        return shCount;
    }

    public void setShCount(Integer shCount) {
        this.shCount = shCount;
    }

    public Integer getStCount() {
        return stCount;
    }

    public void setStCount(Integer stCount) {
        this.stCount = stCount;
    }

    @Override
    public String toString() {
        return "Report{" +
                "area='" + area + '\'' +
                ", hCount=" + hCount +
                ", tCount=" + tCount +
                ", rhCount=" + rhCount +
                ", rtCount=" + rtCount +
                ", shCount=" + shCount +
                ", stCount=" + stCount +
                '}';
    }
}
