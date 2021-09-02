package com.arri.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arri.biz.server.service.ArriServerService;
import com.arri.biz.server.service.Service;
import com.arri.biz.server.vo.UsersVo;

public class DropUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service = new ArriServerService();
		HttpSession session = request.getSession();
		UsersVo uv = (UsersVo)session.getAttribute("login");
		String id = uv.getId();
		
		if(service.deleteUser(id)) {
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.info("회원 탈퇴  /  " + id);
			session.removeAttribute("login");
			session.removeAttribute("hire");
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
				
	}

}
