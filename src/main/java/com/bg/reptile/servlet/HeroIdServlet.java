package com.bg.reptile.servlet;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bg.reptile.js.JsClient;

/**
 * Servlet implementation class HeroIdServlet
 */
@WebServlet("/HeroIdServlet")
public class HeroIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HeroIdServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String heros = request.getParameter("heros");
		if(null == heros){
			System.out.println("传入的参数为空");
			return;
		}
		String[] ids = heros.split(",");
		if(null != ids && ids.length > 0){
			for(String id : ids){
				System.out.println("name:"+id);
				JsClient.parseJs(id);
			}
		}
	}

}
