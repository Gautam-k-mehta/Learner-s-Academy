package com.xadmin.usermanagement.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/Login")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static boolean isLoggedIn = false;
	 public static String password = "gautam";
	    public static String email = "gautam";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		PrintWriter out = resp.getWriter();
        out.println("</html></body>");

        String email = req.getParameter("uname");
        String pass = req.getParameter("pwd");

        if (email.equals(UserLogin.email) && pass.equals(UserLogin.password)){
        	isLoggedIn = true;
            out.println("You have LoggedIn");
            resp.sendRedirect("user-list.jsp");
        }
        else {
        	isLoggedIn = false;
            out.println("Invalid email and Password");
        }
        out.close();
	}

	}

