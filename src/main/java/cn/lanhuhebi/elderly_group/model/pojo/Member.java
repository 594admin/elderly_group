package cn.lanhuhebi.elderly_group.model.pojo;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Member {

    //组员ID
    private Integer memId;

    //组员(员工ID)
    private Integer memMem;

    //小组ID
    private Integer memTemId;

    //get set 方法
    public Member setMemId (Integer memId){
        this.memId=memId;
        return this;
    }

    public Integer getMemId(){
        return this.memId;
    }

    public Member setMemMem (Integer memMem){
        this.memMem=memMem;
        return this;
    }

    public Integer getMemMem(){
        return this.memMem;
    }

    public Member setMemTemId (Integer memTemId){
        this.memTemId=memTemId;
        return this;
    }

    public Integer getMemTemId(){
        return this.memTemId;
    }

}
