package com.arri.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arri.biz.server.service.ArriServerService;
import com.arri.biz.server.service.Service;
import com.arri.biz.server.vo.BoardVo;

public class ViewBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		Service service = new ArriServerService();
		HttpSession session = request.getSession();
		String seq = request.getParameter("seq");
		BoardVo bv = service.printBoard(Integer.parseInt(seq));
		session.setAttribute("board",bv);
		request.setAttribute("content", "viewBoard.jsp");
		String view = "index.jsp";
		request.getRequestDispatcher(view).forward(request, response);
 	}

}
