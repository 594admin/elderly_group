package cn.lanhuhebi.elderly_group.model.domain;


import java.util.List;

/**
 * @author dxq
 * @date 2019-08-22 - 23:51
 */
public class ReportVo {

    private String qvName;

    private List<FamilyVo> familys;

    @Override
    public String toString() {
        return "ReportVo{" +
                "qvName='" + qvName + '\'' +
                ", familys=" + familys +
                '}';
    }

    public String getQvName() {
        return qvName;
    }

    public void setQvName(String qvName) {
        this.qvName = qvName;
    }

    public List<FamilyVo> getFamilys() {
        return familys;
    }

    public void setFamilys(List<FamilyVo> familys) {
        this.familys = familys;
    }
}
