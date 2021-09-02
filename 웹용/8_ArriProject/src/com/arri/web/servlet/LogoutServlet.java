package com.arri.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arri.biz.server.vo.UsersVo;


public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UsersVo data = (UsersVo)session.getAttribute("login");
		Logger logger = LoggerFactory.getLogger(getClass());
		logger.info("logout  /  "  + data.getId());
		
		session.removeAttribute("login");
		session.removeAttribute("hire");
		session.invalidate();
		response.sendRedirect("index.jsp");
	}
}
