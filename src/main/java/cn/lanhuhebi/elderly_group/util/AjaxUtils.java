package cn.lanhuhebi.elderly_group.util;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AjaxUtils {
	
	public static  void jsonforward(Object obj, HttpServletResponse response) {
		String result = JSON.toJSONString(obj);
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(result);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
