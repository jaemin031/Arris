package com.arri.web.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arri.biz.server.service.ArriServerService;
import com.arri.biz.server.service.Service;
import com.arri.biz.server.vo.HireInfoVo;
import com.arri.biz.server.vo.LawInfoVo;
import com.arri.biz.server.vo.LawyerVo;
import com.arri.biz.server.vo.UsersVo;

public class UnfairServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		HireInfoVo hv = (HireInfoVo)session.getAttribute("hire");
		if (session.getAttribute("login") != null) {
			if (hv.getWage() >0) {
				Service service = new ArriServerService();
				UsersVo user = (UsersVo) session.getAttribute("login");
				Object[] result = service.prints(user.getId());
				Vector<LawInfoVo> law = (Vector<LawInfoVo>) result[0];
				Vector<LawyerVo> lawyer = (Vector<LawyerVo>) result[1];
				int resultPay = (int) result[2];
				int comPay = (int) result[3];
				int payMoney = (int) result[4];

				request.setAttribute("law", law);
				request.setAttribute("lawyer", lawyer);
				request.setAttribute("resultPay", resultPay);
				request.setAttribute("comPay", comPay);
				request.setAttribute("payMoney", payMoney);
				request.setAttribute("content", "UnfairJobResult.jsp");
				String view = "index.jsp";
				request.getRequestDispatcher(view).forward(request, response);
			}
			else {
				session.removeAttribute("content");
				response.sendRedirect("index.jsp");
			}
		} else {
			session.removeAttribute("content");
			response.sendRedirect("index.jsp");
		}
	}
}
