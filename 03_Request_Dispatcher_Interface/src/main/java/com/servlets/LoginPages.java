package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginPages  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String em = req.getParameter("email");
		String ps = req.getParameter("password");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		RequestDispatcher rd ;
		if("demo@gmail.com".equals(em) && "demo".equals(ps)) {
//			go to next servlet pagge
//			rd = req.getRequestDispatcher("/secondser");
//			rd.forward(req, resp);
			
			resp.sendRedirect("secondser");
			
		}else {
//			still on same servlet page
			out.println("<h1>Invalid email and password</h1>");
			rd = req.getRequestDispatcher("/index.html");
			rd.include(req, resp);
		}
	

	}	

}
