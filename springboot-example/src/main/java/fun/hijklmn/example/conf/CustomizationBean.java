package fun.hijklmn.example.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

/**
 * 
 * Desc: 在这儿进行相关配置，和application.properties配置一样
 * Author:GuoFusong
 * Projectname:springboot
 * Filename:CustomizationBean.java
 * Tags:
 * Datetime:2019年3月20日下午6:09:16
 * Version:1.0.0
 */
@Component
public class CustomizationBean implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

	@Autowired
	private ConstantsConf constantsConf;
	
	@Override
	public void customize(ConfigurableServletWebServerFactory factory) {
		factory.setPort(constantsConf.getServerPort());
	}

}
