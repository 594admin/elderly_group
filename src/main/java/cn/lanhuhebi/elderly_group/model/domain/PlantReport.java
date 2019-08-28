package cn.lanhuhebi.elderly_group.model.domain;

/**
 * 厂家统计
 * @author dxq
 * @date 2019-08-19 - 11:46
 */
public class PlantReport {

    /**
     * 厂家
     */
    private String plant;

    /**
     * 设备型号
     */
    private Integer eptModel;

    /**
     * 设备类型
     */
    private String eptType;

    /**
     * 缴费量
     */
    private Integer jCount;

    /**
     * 安装量
     */
    private Integer aCount;

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public Integer getEptModel() {
        return eptModel;
    }

    public void setEptModel(Integer eptModel) {
        this.eptModel = eptModel;
    }

    public String getEptType() {
        return eptType;
    }

    public void setEptType(String eptType) {
        this.eptType = eptType;
    }

    public Integer getjCount() {
        return jCount;
    }

    public void setjCount(Integer jCount) {
        this.jCount = jCount;
    }

    public Integer getaCount() {
        return aCount;
    }

    public void setaCount(Integer aCount) {
        this.aCount = aCount;
    }

    @Override
    public String toString() {
        return "PlantReport{" +
                "plant='" + plant + '\'' +
                ", eptModel=" + eptModel +
                ", eptType='" + eptType + '\'' +
                ", jCount=" + jCount +
                ", aCount=" + aCount +
                '}';
    }
}
