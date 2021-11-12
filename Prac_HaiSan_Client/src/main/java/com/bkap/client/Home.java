package com.bkap.client;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bkap.entity.HaiSan;
import com.bkap.entity.Paging;
import com.bkap.utils.CallWebService;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Home() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		List<HaiSan> lst = null;
		CallWebService service = new CallWebService();
		
		int total = service.getTotalPage();
		int limit = 10;
		List<Paging> lstPage = new ArrayList<Paging>();
		int page = (int) Math.ceil((double) total / (double) limit);

		for (int i = 0; i < page; i++) {
			lstPage.add(new Paging(i, i * limit));

		}
		request.setAttribute("page", lstPage);

		String Strpage = request.getParameter("page");
		if (Strpage != null && !Strpage.isEmpty()) {
			lst = service.loadPage(Integer.parseInt(Strpage), limit);
		} else {
			lst = service.loadPage(0, limit);
		}
		String search = request.getParameter("txtSearch");

		if (search != null && !search.isEmpty()) {

			lst = service.search(search);

		}
		request.setAttribute("lst", lst);


		request.getRequestDispatcher("list-haisan.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
