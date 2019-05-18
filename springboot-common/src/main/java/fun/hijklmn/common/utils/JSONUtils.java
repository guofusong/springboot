package fun.hijklmn.common.utils;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONUtils {

	public static JSONObject toJson(Object object) {
		return JSONObject.fromObject(object);
	}
	
	public static String toJsonStr(Object object) {
		return JSONObject.fromObject(object).toString();
	}
	
	public static String toJsonStr(JSONObject jsonObject) {
		return jsonObject.toString();
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T toBean(JSONObject jsonObject, Class<T> clas) {
		return (T) JSONObject.toBean(jsonObject, clas);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T toBean(String str, Class<T> clas) {
		return (T) JSONObject.toBean(toJson(str), clas);
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static <T> List<T> toList(JSONArray jsonArray, Class<T> clas) {
		return JSONArray.toList(jsonArray, clas);
	}
	
}
