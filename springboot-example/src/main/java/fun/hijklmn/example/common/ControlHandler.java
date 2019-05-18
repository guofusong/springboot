package fun.hijklmn.example.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import fun.hijklmn.example.bo.ResultVo;
import fun.hijklmn.example.bo.SysUser;

public interface ControlHandler {

	ModelAndView handler(HttpServletRequest request, HttpServletResponse response, SysUser sysUser, ResultVo resultVo) throws Exception;
	
}
