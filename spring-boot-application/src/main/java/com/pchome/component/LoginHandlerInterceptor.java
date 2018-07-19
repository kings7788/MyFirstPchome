package com.pchome.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登陸請求
 */
public class LoginHandlerInterceptor implements HandlerInterceptor{
	//目標方法執行之前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {		
		Object user = request.getSession().getAttribute("LoginOK");
		if(user==null) {
			//未登錄, 返回登入葉面
			request.setAttribute("msg", "沒有權限請先登錄");
			request.getRequestDispatcher("/index.html").forward(request, response);
			return false;
		}else {
			//已登錄 , 放行請求
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
