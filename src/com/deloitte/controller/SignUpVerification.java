package com.deloitte.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deloitte.model.User;
import com.deloitte.service.CredService;
import com.deloitte.service.CredServiceImpl;
@WebServlet("/SignUpVerification")
public class SignUpVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = null;
		HttpSession session = request.getSession();
		Long id = Long.parseLong(request.getParameter("id"));
		String  pass = request.getParameter("pass"), 
				name = request.getParameter("name"), 
				gender = request.getParameter("gender"), 
				country = request.getParameter("country");
		User user = new User(id, pass, name, gender, country);
		try {
			CredService cs = new CredServiceImpl();
			cs.addUser(user);
			response.sendRedirect("login.jsp");
		} catch(Exception e) {
			e.printStackTrace();
			error = e.getMessage();
			session.setAttribute("error", error);
			response.sendRedirect("signup.jsp");
		}
		
	}

}
