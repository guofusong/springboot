package fun.hijklmn.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fun.hijklmn.common.utils.JSONUtils;
import fun.hijklmn.common.utils.WebParamsGetter;
import fun.hijklmn.example.bo.ResultVo;
import fun.hijklmn.example.bo.SysUser;
import fun.hijklmn.example.common.ControlHandler;
import fun.hijklmn.example.common.HandlerProxy;
import fun.hijklmn.example.dao.HSQLExampleRepository;
import fun.hijklmn.example.po.HSQLExample;

@Controller
@RequestMapping("/templates")
public class TemplateController extends BaseController{

	@Autowired
	private HSQLExampleRepository templateRepository;
	
	@RequestMapping("/put")
	public void put(HttpServletRequest request, HttpServletResponse response) {
		HandlerProxy.assembAjax(new ControlHandler() {
			@Override
			public ModelAndView handler(HttpServletRequest request, HttpServletResponse response, SysUser sysUser, ResultVo resultVo) {
				
				String params = WebParamsGetter.getString("params", request);
				
				HSQLExample template = null;
				
				if (StringUtils.isBlank(params)) {
					template = new HSQLExample(null, "默认模板", "YAS43F32DF86G84BV3DF34DF", UUID.randomUUID().toString().replaceAll("-", ""), System.currentTimeMillis() + "");
				} else {
					template = JSONUtils.toBean(params, HSQLExample.class);
				}
				
				HSQLExample template2 = templateRepository.save(template);
				
				if (template2 == null) {
					resultVo.setCustomerReason(null, "添加失败！");
				} else {
					resultVo.setResult(template2);
				}
				
				return null;
				
			}
		}, request, response);
	}
	
	@RequestMapping("/listAll")
	public void listAll(HttpServletRequest request, HttpServletResponse response) {
		HandlerProxy.assembAjax(new ControlHandler() {
			@Override
			public ModelAndView handler(HttpServletRequest request, HttpServletResponse response, SysUser sysUser, ResultVo resultVo) {
				
				Iterable<HSQLExample> iterable = templateRepository.findAll();

				List<Object> list = new ArrayList<>();
				
				iterable.forEach(new Consumer<HSQLExample>() {
					@Override
					public void accept(HSQLExample template) {
						list.add(template);
					}
				});
				
				resultVo.setItems(list);
				
				return null;
				
			}
		}, request, response);
	}

}
