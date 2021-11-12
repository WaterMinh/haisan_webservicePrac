package com.bkap.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bkap.entity.Messages;
import com.bkap.utils.CallWebService;
import com.bkap.entity.HaiSan;
import com.google.gson.Gson;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String ten = request.getParameter("ten");
		String ncc = request.getParameter("ncc");
		String dvt = request.getParameter("dvt");
		int soluong = Integer.parseInt(request.getParameter("soluong"));
		float giatien = Float.parseFloat(request.getParameter("giatien"));
		Boolean tinhtrang = Boolean.parseBoolean(request.getParameter("tinhtrang"));
		String anh = request.getParameter("anh");

		HaiSan hs = new HaiSan(ten, ncc, dvt, soluong, giatien, tinhtrang, anh);
		CallWebService service = new CallWebService();
		String json = service.insert(hs);

		
		Gson gson = new Gson();
		Messages mess = gson.fromJson(json, Messages.class);

		request.setAttribute("mess", mess);
		request.getRequestDispatcher("insert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
