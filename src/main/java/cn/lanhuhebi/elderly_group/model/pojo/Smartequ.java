package cn.lanhuhebi.elderly_group.model.pojo;

import java.util.Date;

/**
 * @author dxq
 * @date 2019-09-03 - 9:01
 */
public class Smartequ {

    private String EQU_CODE;

    private String EQU_NO;

    private String EQU_STATE;

    private String EQU_INSTALL_LOC;

    @Override
    public String toString() {
        return "Smartequ{" +
                "EQU_CODE='" + EQU_CODE + '\'' +
                ", EQU_NO='" + EQU_NO + '\'' +
                ", EQU_STATE='" + EQU_STATE + '\'' +
                ", EQU_INSTALL_LOC='" + EQU_INSTALL_LOC + '\'' +
                '}';
    }

    public String getEQU_CODE() {
        return EQU_CODE;
    }

    public void setEQU_CODE(String EQU_CODE) {
        this.EQU_CODE = EQU_CODE;
    }

    public String getEQU_NO() {
        return EQU_NO;
    }

    public void setEQU_NO(String EQU_NO) {
        this.EQU_NO = EQU_NO;
    }

    public String getEQU_STATE() {
        return EQU_STATE;
    }

    public void setEQU_STATE(String EQU_STATE) {
        this.EQU_STATE = EQU_STATE;
    }

    public String getEQU_INSTALL_LOC() {
        return EQU_INSTALL_LOC;
    }

    public void setEQU_INSTALL_LOC(String EQU_INSTALL_LOC) {
        this.EQU_INSTALL_LOC = EQU_INSTALL_LOC;
    }
}
