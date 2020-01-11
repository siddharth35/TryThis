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
@WebServlet("/LoginVerification")
public class LoginVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Long id = Long.parseLong(request.getParameter("id"));
		String pass = request.getParameter("pass");
		CredService cs = new CredServiceImpl();
		String error = null;
		User user = cs.getUserById(id);
		if(user!=null) {
			if(pass.equals(user.getPass())) {
				session.setAttribute("session", session);
				session.setAttribute("user", user);
				response.sendRedirect("welcome.jsp");
			} else {
				error = "Invalid Password";
				session.setAttribute("error", error);
				response.sendRedirect("login.jsp");
			}
		} else {
			error = "Invalid Username";
			session.setAttribute("error", error);
			response.sendRedirect("login.jsp");
		}
	}
}
