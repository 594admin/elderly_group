package cn.lanhuhebi.elderly_group.util;

import cn.lanhuhebi.elderly_group.model.pojo.Smartequ;
import com.alibaba.fastjson.JSON;
import org.json.JSONObject;

import java.util.List;

/**
 * @author dxq
 * @date 2019-09-03 - 13:07
 */
public class JSONUtil {

    public static List<Smartequ> parseJSON(String json){
        JSONObject jsonObject = new JSONObject(json);
        Object message = jsonObject.get("message");
        System.out.println(message.toString());
        return JSON.parseArray(message.toString(), Smartequ.class);
    }

    public static String getJSONResult(String json){
        JSONObject jsonObject = new JSONObject(json);
        return jsonObject.get("RESULT").toString();
    }
}
