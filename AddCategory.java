package com.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminModel;
import com.dto.Category;

@WebServlet("/addCategory")
public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String name = request.getParameter("name");
		String description = request.getParameter("description");

		Category cat= new Category(uid, name, description);
		AdminModel am = new AdminModel();

		int i =am.addCategory(cat);
		RequestDispatcher rd = request.getRequestDispatcher("addCategory.jsp");
		if (i != 0) {
			request.setAttribute("msg", "success");
		} else {
			request.setAttribute("msg", "fail");
		}
		rd.forward(request, response);
	}
}
