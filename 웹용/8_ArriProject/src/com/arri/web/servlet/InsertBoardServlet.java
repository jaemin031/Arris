package com.arri.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arri.biz.server.service.ArriServerService;
import com.arri.biz.server.service.Service;
import com.arri.biz.server.vo.BoardVo;
import com.arri.biz.server.vo.UsersVo;

public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service = new ArriServerService();
		HttpSession session = request.getSession();
		BoardVo bv = new BoardVo();
		UsersVo uv = (UsersVo)session.getAttribute("login");
		String title = request.getParameter("title");
		String writer = uv.getName();
		String part = request.getParameter("part").trim();
		
		String coment = request.getParameter("coment");
		String userid = request.getParameter("userid");
		bv.setTitle(title);
		bv.setWriter(writer);
		bv.setComent(coment);
		bv.setUserid(userid);
		bv.setPart(part);
		
		if(service.inserBoard(bv)) {
			String view = "getBoardList.do";							//보드 결과값들어갈꺼
			request.setAttribute("insertBoard", "게시글 등록 성공");	//보드 결과값들어갈꺼
			request.getRequestDispatcher(view).forward(request, response);
		}
		else {
			String view = "getBoardList.do";
			request.setAttribute("insertBoard", "게시글 등록 실패");
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

}
