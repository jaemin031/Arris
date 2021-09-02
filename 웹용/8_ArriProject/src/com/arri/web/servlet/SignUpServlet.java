package com.arri.web.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arri.biz.server.service.ArriServerService;
import com.arri.biz.server.service.Service;
import com.arri.biz.server.vo.UsersVo;

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service = new ArriServerService();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String pw = request.getParameter("pw");
		Date day = Date.valueOf(request.getParameter("birthDate"));
		
		UsersVo user = new UsersVo(id,pw,name,gender,day);
		String view = "index.jsp?content=SignUpResult.jsp";
		if(service.sign(user)) {
			request.setAttribute("signup", user);
			request.setAttribute("successSign", "회원가입 성공");
			request.getRequestDispatcher(view).forward(request, response);
		}
		else {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}
}
