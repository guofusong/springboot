package fun.hijklmn.common.utils;

import java.util.UUID;

public class RandomUtils {

	public static String getOriginUUID() {
		return UUID.randomUUID().toString();
	}
	
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
}
