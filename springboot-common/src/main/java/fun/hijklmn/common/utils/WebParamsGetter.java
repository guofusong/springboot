package fun.hijklmn.common.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;


public class WebParamsGetter {

	public static String getString(String name, HttpServletRequest request) {
		return request.getParameter(name);
	}
	
	public static String getString(String name, HttpServletRequest request, String def) {
		String val = getString(name, request);
		return StringUtils.isBlank(val) ? def : val;
	}
	
	public static Integer getInteger(String name, HttpServletRequest request) {
		return Integer.parseInt(request.getParameter(name));
	}
	
	public static Integer getInteger(String name, HttpServletRequest request, Integer def) {
		Integer in = Integer.parseInt(request.getParameter(name));
		return in == null ? def : in;
	}
	
	public static Long getLong(String name, HttpServletRequest request) {
		return Long.parseLong(request.getParameter(name));
	}
	
	public static Long getLong(String name, HttpServletRequest request, Long def) {
		Long l = Long.parseLong(request.getParameter(name));
		return l == null ? def : l;
	}
	
	public static Double getDouble(String name, HttpServletRequest request) {
		return Double.parseDouble(request.getParameter(name));
	}
	
	public static Double getDouble(String name, HttpServletRequest request, Double def) {
		Double d = Double.parseDouble(request.getParameter(name));
		return d == null ? def : d;
	}
	
	public static Boolean getBoolean(String name, HttpServletRequest request) {
		return Boolean.parseBoolean(request.getParameter(name));
	}
	
	public static Boolean getBoolean(String name, HttpServletRequest request, boolean def) {
		Boolean bo = getBoolean(name, request);
		return bo == null ? def : bo;
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getRequestDataMap(HttpServletRequest request) {
		
		Enumeration<String> enumeration = request.getParameterNames();

		Map<String, Object> map = new HashMap<>();
		
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement();
			map.put(key, request.getParameter(key));
		}
		
		return map;
	}
	
}
