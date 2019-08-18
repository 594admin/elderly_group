package cn.lanhuhebi.elderly_group.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RoleListVo implements Serializable {
    //角色Id
    private Integer rlId;
    //角色名称
    private String rlName;
    //客户端菜单
    private List<String> clientMenu = new ArrayList<>();
    //移动端菜单
    private List<String> mobileMenu = new ArrayList<>();

    public Integer getRlId() {
        return rlId;
    }

    public RoleListVo setRlId(Integer rlId) {
        this.rlId = rlId;
        return this;
    }

    public String getRlName() {
        return rlName;
    }

    public RoleListVo setRlName(String rlName) {
        this.rlName = rlName;
        return this;
    }

    public List<String> getClientMenu() {
        return clientMenu;
    }

    public RoleListVo setClientMenu(List<String> clientMenu) {
        this.clientMenu = clientMenu;
        return this;
    }

    public List<String> getMobileMenu() {
        return mobileMenu;
    }

    public RoleListVo setMobileMenu(List<String> mobileMenu) {
        this.mobileMenu = mobileMenu;
        return this;
    }
}
