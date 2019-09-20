package cn.lanhuhebi.elderly_group.model.dto.allocation;

/**
 * @author FanWeichong
 * @date 2019-09-17 10:18
 */
public class AlcFamilyVO {
    //户主姓名，户主地址，户主电话，安装协议编号
    private String fName,fAddress,fPhone,fInsId;
    //户ID
    private int fId;

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfAddress() {
        return fAddress;
    }

    public void setfAddress(String fAddress) {
        this.fAddress = fAddress;
    }

    public String getfPhone() {
        return fPhone;
    }

    public void setfPhone(String fPhone) {
        this.fPhone = fPhone;
    }

    public String getfInsId() {
        return fInsId;
    }

    public void setfInsId(String fInsId) {
        this.fInsId = fInsId;
    }
}
