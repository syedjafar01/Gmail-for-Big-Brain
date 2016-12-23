package com.razorthink.trackmymail;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Inside doGet() of Controller Servlet");
		RequestDispatcher rd=null;
		if(request.getRequestURI().contains("login.do"))
		{
			rd=request.getRequestDispatcher("login");
			rd.forward(request, response);
		}
		if(request.getRequestURI().contains("logout.do"))
		{
			rd=request.getRequestDispatcher("logout");
			rd.forward(request, response);
		}
		if(request.getRequestURI().contains("afterGettingAuthCode.do"))
		{
			rd=request.getRequestDispatcher("afterGettingAuthCode");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
