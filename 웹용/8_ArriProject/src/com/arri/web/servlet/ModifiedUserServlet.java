package com.arri.web.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arri.biz.server.service.ArriServerService;
import com.arri.biz.server.service.Service;
import com.arri.biz.server.vo.UsersVo;

public class ModifiedUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service = new ArriServerService();
		HttpSession session = request.getSession();
		UsersVo data = (UsersVo)session.getAttribute("login");
		
		String id = data.getId();
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		Date date = Date.valueOf(request.getParameter("birthDate"));
		UsersVo uv = new UsersVo(id, pw, name, gender, date);
		System.out.println(uv);
		System.out.println(uv);
		if(service.updateUser(uv)) {
			session.removeAttribute("login");
			UsersVo user = service.getUser(id);
			session.setAttribute("login", user);
			response.sendRedirect("index.jsp?content=prMain.jsp");
			
		}
		
		
	}
}
