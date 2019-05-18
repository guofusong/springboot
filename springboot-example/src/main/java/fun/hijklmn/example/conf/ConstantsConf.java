package fun.hijklmn.example.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConstantsConf {

	private Integer serverPort;

	public Integer getServerPort() {
		return serverPort;
	}

	@Value("${server.port}")
	public void setServerPort(Integer serverPort) {
		this.serverPort = serverPort;
	}

	@Override
	public String toString() {
		return "ConstantsConf [serverPort=" + serverPort + "]";
	}

}
