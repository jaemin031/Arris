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
import com.arri.biz.server.vo.HireInfoVo;

public class HireInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("이곳은 서블릿~");
		if (session.getAttribute("login") != null) {
			Service service = new ArriServerService();
			System.out.println(request.getParameter("hireid") + "-------서블릿");
			String id = request.getParameter("hireid");
			int num = -1;
			String insuCheck = request.getParameter("choiceInsu");
			int d_day = Integer.parseInt(request.getParameter("dayweek_Text"));
			int e_day = Integer.parseInt(request.getParameter("weekend_Text"));
			int d_time = Integer.parseInt(request.getParameter("dayTime_Text"));
			int n_time = Integer.parseInt(request.getParameter("nightTime_Text"));
			int wage = Integer.parseInt(request.getParameter("Sal_Text"));
			int payMoney = Integer.parseInt(request.getParameter("Pay_Text"));
			int jobNum = Integer.parseInt(request.getParameter("choiceJob"));
			String disPay = "";
			if (request.getParameter("check_Women") == null) {
				disPay += "N/";
			} else {
				disPay += request.getParameter("check_Women") + "/";
			}
			if (request.getParameter("checkPrregnancy") == null) {
				disPay += "N/";
			} else {
				disPay += request.getParameter("checkPrregnancy") + "/";
			}
			disPay += request.getParameter("choicePrWomen1") + "/" + request.getParameter("choicePrWomen2") + "/"
					+ request.getParameter("choicePrWomen3") + "/" + request.getParameter("choicePrWomen4");
			String getMoney = request.getParameter("choiceRest");
			String sal = request.getParameter("choicePens") + "/" + request.getParameter("choicePrepaid") + "/"
					+ request.getParameter("choiceTier") + "/" + request.getParameter("choiceVac") + "/"
					+ request.getParameter("choice") + "/" + request.getParameter("textField");
			String vioCheck = request.getParameter("choiceVio");
			String docCheck = "";
			String fireCheck = "";

			if (request.getParameter("check_a3") == null) {
				docCheck += "N/";
			} else {
				docCheck += request.getParameter("check_a3") + "/";
			}
			if (request.getParameter("check_a4") == null) {
				docCheck += "N/";
			} else {
				docCheck += request.getParameter("check_a4") + "/";
			}
			if (request.getParameter("check_a5") == null) {
				docCheck += "N";
			} else {
				docCheck += request.getParameter("check_a5");
			}
			if (request.getParameter("check_a6") == null) {
				fireCheck += "N/";
			} else {
				fireCheck += request.getParameter("check_a6") + "/";
			}
			if (request.getParameter("check_a7") == null) {
				fireCheck += "N/";
			} else {
				fireCheck += request.getParameter("check_a7") + "/";
			}

			if (request.getParameter("check_a8") == null) {
				fireCheck += "N/";
			} else {
				fireCheck += request.getParameter("check_a8") + "/";
			}

			if (request.getParameter("check_a9") == null) {
				fireCheck += "N/";
			} else {
				fireCheck += request.getParameter("check_a9") + "/";
			}
			if (request.getParameter("check_a10") == null) {
				fireCheck += "N";
			} else {
				fireCheck += request.getParameter("check_a10");
			}

			HireInfoVo v2 = new HireInfoVo(id, num, wage, insuCheck, vioCheck, payMoney, d_day, e_day, d_time, n_time,
					jobNum, fireCheck, disPay, getMoney, docCheck, sal);

			if (service.inserHireInfo(v2)) {
				session.removeAttribute("hire");
				session.setAttribute("hire", v2);
				String view = "prMain.do";
				System.out.println("이곳은 inser");
				request.setAttribute("successHireSign", "정보 등록 완료");
				request.getRequestDispatcher(view).forward(request, response);
			} else {
				System.out.println("이곳은 1else");
				System.out.println("send");
				response.sendRedirect("index.jsp?content=HireInfo.jsp");
			}
		} else {
			System.out.println("이곳은 2else");
			session.removeAttribute("content");
			response.sendRedirect("index.jsp");
		}
	}

}
