package cn.lanhuhebi.elderly_group.model.pojo;
import java.util.Date;

/**
 * @ClassName Team
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Team {

    //工程小组ID
    private Integer temId;

    //组名
    private String temName;

    //组长(员工ID)
    private Integer temLead;

    //创建时间
    private Date temCreaDate;

    //创建者(员工ID)
    private Integer temCreator;

    //get set 方法
    public Team setTemId (Integer temId){
        this.temId=temId;
        return this;
    }

    public Integer getTemId(){
        return this.temId;
    }

    public Team setTemName (String temName){
        this.temName=temName;
        return this;
    }

    public String getTemName(){
        return this.temName;
    }

    public Team setTemLead (Integer temLead){
        this.temLead=temLead;
        return this;
    }

    public Integer getTemLead(){
        return this.temLead;
    }

    public Team setTemCreaDate (Date temCreaDate){
        this.temCreaDate=temCreaDate;
        return this;
    }

    public Date getTemCreaDate(){
        return this.temCreaDate;
    }

    public Team setTemCreator (Integer temCreator){
        this.temCreator=temCreator;
        return this;
    }

    public Integer getTemCreator(){
        return this.temCreator;
    }

}
