package com.arri.web.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arri.biz.server.service.ArriServerService;
import com.arri.biz.server.service.Service;

public class IdFinderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service = new ArriServerService();
		
		String name = request.getParameter("Name_text");
		Date day = Date.valueOf(request.getParameter("birthDate"));
		
		String id = service.idfind(name, day);
		if(id != null) {
			request.setAttribute("findId", id);
			request.setAttribute("findName", name);
			String view = "index.jsp?content=IDresult.jsp"; 	
			request.getRequestDispatcher(view).forward(request, response);
		}
		else {
			response.sendRedirect("index.jsp?content=IDfinder.jsp");
		}
	}
}
