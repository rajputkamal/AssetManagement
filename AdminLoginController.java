package com.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminModel;

@WebServlet("/adminLogin")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pwd");
		AdminModel model = new AdminModel();
		int i = model.loginCheck(uname, pass);

		HttpSession session = null;

		if (i != 0) {
			session = request.getSession();
			session.setAttribute("user", uname);
			
			RequestDispatcher rd = request.getRequestDispatcher("adminHome.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("msg", "Incorrect User Name Or Password");
			rd.forward(request, response);
		}
		// response.sendRedirect("login.jsp");
	}

}
