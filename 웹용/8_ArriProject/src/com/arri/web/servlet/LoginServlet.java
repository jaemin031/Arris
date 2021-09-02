package com.arri.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arri.biz.server.dao.DAO;
import com.arri.biz.server.dao.DAOImpl;
import com.arri.biz.server.service.ArriServerService;
import com.arri.biz.server.service.Service;
import com.arri.biz.server.vo.HireInfoVo;
import com.arri.biz.server.vo.UsersVo;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Service service = new ArriServerService();
		System.out.println(service.login(id, pw));
		if(service.login(id, pw)) {
			UsersVo user = service.getUser(id);
			HireInfoVo hire = service.getInfo(id);
			HttpSession session = request.getSession();
			Logger logger = LoggerFactory.getLogger(getClass());
			logger.info("login  /  "+id);
			session.setAttribute("login", user);
			session.setAttribute("hire", hire);
			response.sendRedirect("index.jsp?content=prMain.jsp");
		}else {
			String view = "index.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		}
	}
}
