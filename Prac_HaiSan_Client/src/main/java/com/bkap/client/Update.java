package com.bkap.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.bkap.entity.HaiSan;
import com.bkap.entity.Messages;
import com.bkap.utils.CallWebService;
import com.google.gson.Gson;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		CallWebService service = new CallWebService();
		String idHaiSan = request.getParameter("idHaiSan");
		if (idHaiSan !=null && !idHaiSan.isEmpty()) {
			
			HaiSan haisan = service.loadDetail(idHaiSan);
			request.setAttribute("haisan", haisan);
		}
		
		boolean isUpdate = request.getParameter("submit") !=null ? true : false;
		if (isUpdate) {
			int id = Integer.parseInt(request.getParameter("id"));
			String ten = request.getParameter("ten");
			String ncc = request.getParameter("ncc");
			String dvt = request.getParameter("dvt");
			int soluong = Integer.parseInt(request.getParameter("soluong"));
			float giatien = Float.parseFloat(request.getParameter("giatien"));
			Boolean tinhtrang = Boolean.parseBoolean(request.getParameter("tinhtrang"));
			String anh = request.getParameter("anh");
			
			HaiSan haisan = new HaiSan(id,ten, ncc, dvt, soluong, giatien, tinhtrang, anh);
			String json = service.update(haisan);
			Gson gson = new Gson();
			Messages mess = gson.fromJson(json, Messages.class);
			request.setAttribute("mess", mess);
			request.setAttribute("haisan", haisan);
		}
		
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
