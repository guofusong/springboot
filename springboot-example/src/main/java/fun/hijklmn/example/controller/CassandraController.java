package fun.hijklmn.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fun.hijklmn.common.utils.RandomUtils;
import fun.hijklmn.example.bo.ResultVo;
import fun.hijklmn.example.bo.SysUser;
import fun.hijklmn.example.common.ControlHandler;
import fun.hijklmn.example.common.HandlerProxy;
import fun.hijklmn.example.po.CassandraExample;

@Controller
public class CassandraController extends BaseController {

	@Autowired
	private CassandraTemplate cassandraTemplate;
	
	@RequestMapping(value = "/cassandra/put")
	public void put(HttpServletRequest request, HttpServletResponse response) {
		
		HandlerProxy.assembAjax(new ControlHandler() {

			@Override
			public ModelAndView handler(HttpServletRequest request, HttpServletResponse response, SysUser sysUser,
					ResultVo resultVo) throws Exception {

				long timeStamp = System.currentTimeMillis();
				
				CassandraExample example = new CassandraExample(timeStamp, "Cassandra模板", "DF87SDFLKKLNVB3432JFDLGI543JHKJ", RandomUtils.getUUID(), timeStamp + "");
				
				CassandraExample example2 = cassandraTemplate.insert(example);
				
				resultVo.setResult(example2);
				
				return null;
				
			}}, request, response);
		
	}
	
}
