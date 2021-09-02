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

public class GetBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("login") != null) {
			Service service = new ArriServerService();

			List<BoardVo> list = service.printsBoard();
			request.setAttribute("list", list);
			request.setAttribute("content", "boardlist.jsp");
			String view = "index.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		} else {
			session.removeAttribute("content");
			response.sendRedirect("index.jsp");
		}
	}
}
