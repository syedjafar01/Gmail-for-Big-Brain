package com.razorthink.trackmymail;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.getWriter().append("Served at: ").append(request.getContextPath());
		String username=request.getParameter("userid");
		String password=request.getParameter("password");
		System.out.println(username+" "+password);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		/*System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());
		try{
		String username=request.getParameter("userid");
		String password=request.getParameter("password");
		System.out.println(username+" "+password);
		Connection con=JDBCHelper.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from user");
		ResultSet rs=null;
		rs=ps.executeQuery();
		String userid="";String pwd="";
		while(rs.next())
		{
			userid=(rs.getString(2));//since there is only one user now I am comparing outside while for validity
			pwd=(rs.getString(3));
		}
		System.out.println(userid+" "+pwd);
		if(userid.equals(username) && pwd.equals(password))
		{
			System.out.println("Valid user");
		}
		else
		{
			System.out.println("Invalid user");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		HttpSession session=request.getSession(false);
		System.out.println("Session "+session+" created for the user: "+userid);
		session.setAttribute("userid", userid);
		response.sendRedirect("https://accounts.google.com/o/oauth2/auth?redirect_uri=http%3A%2F%2Flocalhost%3A8080%2FTrackMyMail%2FafterGettingAuthCode.do&response_type=code&client_id=929742997040-rbs5bbha3dqcp52klqtd8h1257q86i06.apps.googleusercontent.com&scope=https%3A%2F%2Fmail.google.com%2F&approval_prompt=force");
		System.out.println("doPostEnded");
	}

}
