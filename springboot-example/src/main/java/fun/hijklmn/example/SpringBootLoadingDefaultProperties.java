package fun.hijklmn.example;

import java.util.ArrayList;
import java.util.List;

public class SpringBootLoadingDefaultProperties {
	
	private StringBuilder stringBuilder = new StringBuilder();
	
	private List<String> propList = new ArrayList<>();
	
	public SpringBootLoadingDefaultProperties() {}
	
	public SpringBootLoadingDefaultProperties setConfigLocation(String location) {
		stringBuilder.append(location).append("=");
		return this;
	}
	
	public SpringBootLoadingDefaultProperties addProperties(String properties) {
		propList.add(properties);
		return this;
	}
	
	public String builder() {
		if (propList.size() == 0) {
			throw new RuntimeException("you must set config properties file . . . ");
		}
		for (int i=0; i<propList.size(); i++) {
			if (i == 0) {
				stringBuilder.append(propList.get(i));
			} else {
				stringBuilder.append(",").append(propList.get(i));
			}
		}
		return stringBuilder.toString();
	}
	
}
