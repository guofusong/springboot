package fun.hijklmn.example.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fun.hijklmn.common.utils.JSONUtils;
import fun.hijklmn.common.utils.WebParamsGetter;
import fun.hijklmn.example.bo.ResultVo;
import fun.hijklmn.example.bo.SysUser;
import fun.hijklmn.example.common.ControlHandler;
import fun.hijklmn.example.common.HandlerProxy;
import fun.hijklmn.example.po.HSQLExample;

@RestController
public class RedisController extends BaseController {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@RequestMapping("/redis/put")
	public void put(HttpServletRequest request, HttpServletResponse response) {
		
		HandlerProxy.assembAjax(new ControlHandler() {

			@Override
			public ModelAndView handler(HttpServletRequest request, HttpServletResponse response, SysUser sysUser,
					ResultVo resultVo) {
				
				String params = WebParamsGetter.getString("params", request);
				
				long templateId = System.currentTimeMillis();
				
				HSQLExample template = null;
				
				if (StringUtils.isBlank(params)) {
					template = new HSQLExample(templateId, "默认模板", "YAS43F32DF86G84BV3DF34DF", UUID.randomUUID().toString().replaceAll("-", ""), System.currentTimeMillis() + "");
				} else {
					template = JSONUtils.toBean(params, HSQLExample.class);
					template.setId(templateId);
				}
				
				stringRedisTemplate.opsForValue().set(templateId + "", JSONUtils.toJsonStr(template));
				
				resultVo.setResult(template);
				
				return null;
				
			}}, request, response);
		
	}
	
	@RequestMapping("/redis/get")
	public void get(HttpServletRequest request, HttpServletResponse response) {
		
		HandlerProxy.assembAjax(new ControlHandler() {

			@Override
			public ModelAndView handler(HttpServletRequest request, HttpServletResponse response, SysUser sysUser,
					ResultVo resultVo) {

				String templateId = WebParamsGetter.getString("templateId", request);
				
				String templateStr = stringRedisTemplate.opsForValue().get(templateId);
				
				HSQLExample template = null;
				
				template = JSONUtils.toBean(templateStr, HSQLExample.class);
				
				resultVo.setResult(template);
				
				return null;
				
			}}, request, response);
		
	}
	
}
