package com.arri.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arri.biz.server.service.ArriServerService;
import com.arri.biz.server.service.Service;
import com.arri.biz.server.vo.BoardVo;

public class BoardSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Service service = new ArriServerService();
		HttpSession session = request.getSession();
		session.removeAttribute("list");
		request.setCharacterEncoding("UTF-8");
		String condition = request.getParameter("condition");
		String keyword = request.getParameter("keyword");
		System.out.println(condition + ",,,,,,,,," + keyword);
		
		List<BoardVo> list = service.searchBoard(condition, keyword);
		request.setAttribute("list", list);
		request.setAttribute("content", "boardlist.jsp");
		String view = "index.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}
}
