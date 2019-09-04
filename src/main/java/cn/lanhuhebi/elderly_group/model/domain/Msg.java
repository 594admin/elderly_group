package cn.lanhuhebi.elderly_group.model.domain;

import cn.lanhuhebi.elderly_group.model.pojo.Smartequ;

import java.util.List;

/**
 * @author dxq
 * @date 2019-09-03 - 11:54
 */
public class Msg {
    @Override
    public String toString() {
        return "Msg{" +
                "message=" + message +
                ", result='" + result + '\'' +
                '}';
    }

    private List<Smartequ> message;

    private String result;

    public List<Smartequ> getMessage() {
        return message;
    }

    public void setMessage(List<Smartequ> message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
