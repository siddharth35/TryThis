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
@WebServlet("/UpdateVerification")
public class UpdateVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("session")==null) {
			response.sendRedirect("login.jsp");
		} else {
			User user = (User)session.getAttribute("user");
			String error = null, newpass = request.getParameter("pass");
			String oldpass = user.getPass();
			user.setPass(newpass);
			CredService cs = new CredServiceImpl();
			try {
				cs.updateUser(user);
				session.setAttribute("user", user);
				response.sendRedirect("updated.jsp");
			} catch(Exception e) {
				user.setPass(oldpass);
				session.setAttribute("user", user);
				error = e.getMessage();
				session.setAttribute("error", error);
				response.sendRedirect("update.jsp");
			}
			
		}
	}

}
