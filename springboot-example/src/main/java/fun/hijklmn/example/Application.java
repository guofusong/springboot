package fun.hijklmn.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import fun.hijklmn.example.conf.ConstantsConf;

@SpringBootApplication
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		
		String propertyStr = new SpringBootLoadingDefaultProperties().setConfigLocation("spring.config.location").addProperties("file:/conf/application.properties").builder();
		
		logger.info("------------> 默认配置文件：" + propertyStr);

		ConfigurableApplicationContext context = new SpringApplicationBuilder(Application.class).properties(propertyStr).run(args);
		
		String[] beanArry = context.getBeanDefinitionNames();
		
		logger.info("========================= Print BeanDefinitionNames ======================");
		
		int count = 0;
		
		for (String value : beanArry) {
			count++;
			logger.info("[ " + count + "/" + beanArry.length + " ]---------------->" + value);
		}
		
		logger.info("===================================End=======================================");
		
		ConstantsConf constantsConf = (ConstantsConf) context.getBean("constantsConf");
		
		logger.info("------------> 配置文件信息：" + constantsConf);
		
	}
	
}
