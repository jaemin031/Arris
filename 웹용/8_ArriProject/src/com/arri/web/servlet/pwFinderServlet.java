package com.arri.web.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arri.biz.server.service.ArriServerService;
import com.arri.biz.server.service.Service;

public class pwFinderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service = new ArriServerService();
		
		String id = request.getParameter("Id_text");
		String name = request.getParameter("Name_text");
		Date day = Date.valueOf(request.getParameter("birthDate"));
		
		System.out.println(id);
		System.out.println(name);
		System.out.println(day);
		
		String pw = service.pwfind(id, name, day);
		if(pw != null) {
			System.out.println(pw);
			request.setAttribute("findPw", pw);
			request.setAttribute("findId", id);
			String view = "index.jsp?content=PwResult.jsp"; 	
			request.getRequestDispatcher(view).forward(request, response);
		}
		else {
			response.sendRedirect("index.jsp?content=PwResult.jsp");
		}
	}
}
