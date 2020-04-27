package fun.hijklmn.search.controller;

import fun.hijklmn.search.conf.ConstantsConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class ContentController {

    @Autowired
    private ConstantsConf constantsConf;

    @RequestMapping(value = "/search")
    public Map search(HttpServletRequest request) {
        String search = request.getParameter("content");
        Map dataMap = new HashMap<String, String>();
        dataMap.put("port", constantsConf.getPort());
        dataMap.put("content", search);
        dataMap.put("uuid", UUID.randomUUID().toString());
        return dataMap;
    }


}
