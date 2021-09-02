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
import com.arri.biz.server.vo.UsersVo;

public class DeleteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Service service = new ArriServerService();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		UsersVo uv = (UsersVo)session.getAttribute("login");
		BoardVo bv = new BoardVo();
		String userid =  request.getParameter("userid");
		System.out.println(userid);
		bv.setSeq(Integer.parseInt(request.getParameter("seq")));
		if(userid.equals(uv.getId())) {
			service.deleteBoard(bv);
			response.sendRedirect("getBoardList.do");
		}else {
			response.sendRedirect("getBoardList.do");
		}

	}

}
