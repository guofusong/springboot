package fun.hijklmn.example.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import fun.hijklmn.common.utils.ResponseUtils;
import fun.hijklmn.example.bo.ResultVo;

public class HandlerProxy {

	private static final Logger logger = LoggerFactory.getLogger(HandlerProxy.class);
	
	public static ModelAndView assemb(ControlHandler controlHandler, HttpServletRequest request, HttpServletResponse response) {
		try {
			return controlHandler.handler(request, response, null, null);
		} catch (Exception e) {
			logger.error(">>>>>>>>>>>>>>>>>>>>：操作出现错误！", e);
			return new ModelAndView("error");
		}
	}
	
	public static void assembAjax(ControlHandler controlHandler, HttpServletRequest request, HttpServletResponse response) {
		final ResultVo resultVo = new ResultVo();
		try {
			controlHandler.handler(request, response, null, resultVo);
		} catch (Exception e) {
			resultVo.setSysErr();
			logger.error(">>>>>>>>>>>>>>>>>>>>：操作出现错误！", e);
		}
		ResponseUtils.outData(resultVo, response);
	}
	
}
