package fun.hijklmn.search.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConstantsConf {

    public Integer port;

    public Integer getPort() {
        return port;
    }

    @Value("${server.port}")
    public void setPort(Integer port) {
        this.port = port;
    }
}
