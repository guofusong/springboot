package fun.hijklmn.common.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

public class ResponseUtils {

	public static void outData(String content, HttpServletResponse response) {
		
		if (content == null || StringUtils.isBlank(content) || response == null) {
			return;
		}
		
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter printWriter = null;
		try {
			printWriter = response.getWriter();
			printWriter.write(content);
			printWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
		
	}
	
	public static void outData(Object object, HttpServletResponse response) {
		
		if (object == null) {
			return;
		}
		
		outData(JSONUtils.toJsonStr(object), response);
		
	}
	
}
