package cn.lanhuhebi.elderly_group.model.pojo;
import java.util.Date;

/**
 * @ClassName Dist
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Dist {

    //分配记录ID
    private Integer dist_id;

    //户信息ID
    private Integer dist_fly_id;

    //分配时间
    private Date dist_distDate;

    //分配状态
    private Integer dist_status;

    //安装工(员工ID数组)
    private String dist_installer;

    //get set 方法

    public Integer getDist_id() {
        return dist_id;
    }

    public void setDist_id(Integer dist_id) {
        this.dist_id = dist_id;
    }

    public Integer getDist_fly_id() {
        return dist_fly_id;
    }

    public void setDist_fly_id(Integer dist_fly_id) {
        this.dist_fly_id = dist_fly_id;
    }

    public Date getDist_distDate() {
        return dist_distDate;
    }

    public void setDist_distDate(Date dist_distDate) {
        this.dist_distDate = dist_distDate;
    }

    public Integer getDist_status() {
        return dist_status;
    }

    public void setDist_status(Integer dist_status) {
        this.dist_status = dist_status;
    }

    public String getDist_installer() {
        return dist_installer;
    }

    public void setDist_installer(String dist_installer) {
        this.dist_installer = dist_installer;
    }
}
